package com.example.camlist.services.serviceImpl;

import com.example.camlist.Enums.ErrorMessages;
import com.example.camlist.dtos.*;
import com.example.camlist.entities.product.Pet;
import com.example.camlist.entities.store.Bid;
import com.example.camlist.entities.store.Category;
import com.example.camlist.entities.store.Order;
import com.example.camlist.entities.store.Tag;
import com.example.camlist.entities.user.User;
import com.example.camlist.exceptions.ResourceIsAlreadyExistException;
import com.example.camlist.exceptions.ResourceNotExistException;
import com.example.camlist.exceptions.ResourceSaveException;
import com.example.camlist.repositories.BidRepository;
import com.example.camlist.repositories.CategoryRepository;
import com.example.camlist.repositories.OrderRepository;
import com.example.camlist.repositories.TagRepository;
import com.example.camlist.services.PetService;
import com.example.camlist.services.StoreService;
import com.example.camlist.services.UserService;
import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StoreServiceImpl implements StoreService {
    private static final Logger logger = LoggerFactory.getLogger(StoreServiceImpl.class);
    private CategoryRepository categoryRepository;
    private TagRepository tagRepository;
    private PetService petService;
    private UserService userService;
    private OrderRepository orderRepository;
    private BidRepository bidRepository;

    public StoreServiceImpl( CategoryRepository categoryRepository, TagRepository tagRepository,UserService userService
            ,OrderRepository orderRepository,PetService petService,BidRepository bidRepository)
    {
        this.categoryRepository=categoryRepository;
        this.tagRepository=tagRepository;
        this.userService=userService;
        this.orderRepository=orderRepository;
        this.petService=petService;
        this.bidRepository=bidRepository;
    }
    @Transactional
    public TagDTO addTag(TagDTO tagDTO)
    {
        try {
            Tag tag=new Tag(tagDTO.getName());
            tagRepository.save(tag);
            tagDTO.setId(tag.getId());
        }
        catch (Exception e){
            throw new ResourceIsAlreadyExistException(ErrorMessages.TAG_IS_EXIST.getValue());
        }
        return tagDTO;
    }
    @Transactional
    public CategoryDTO addCategory(CategoryDTO categoryDTO)
    {
        try {
        Category category=new Category(categoryDTO.getName());
        categoryRepository.save(category);
        categoryDTO.setId(category.getId());
        }
        catch (Exception e){

        throw new ResourceIsAlreadyExistException(ErrorMessages.CATEGORY_IS_EXIST.getValue());
    }
        return categoryDTO;
    }

    @Transactional
    public OrderDTO addOrder(OrderDTO orderDTO) {
        User user=userService.getCurrentUser(SecurityContextHolder.getContext().getAuthentication().getName());

        Pet pet = petService.findById(orderDTO.getPetId());

        // this line to avoid save the same order
        List<Order> orders=user.getOrders().stream().filter(x->pet.getId().equals(x.getPetOrder().getId())).collect(Collectors.toList());

       if(!orders.isEmpty()) return orderDTO;

        Order order=new Order();
        order.setOrderDate(orderDTO.getShipDate());
        order.setOrderStatus(orderDTO.getStatus());
        order.setBuyer(user);
        order.setPetOrder(pet);

    try {
        orderRepository.save(order);
        logger.info("order saved.....");
    }

    catch (HibernateException exception){

        logger.error("exception while saving order "+ exception.getMessage());
        exception.printStackTrace();
        throw new ResourceSaveException(ErrorMessages.ORDER_IS_EXIST.getValue());
    }

        return orderDTO;
    }

    @Override
    public BidDTO addBid(BidDTO bidDTO) {
        User user=userService.getCurrentUser(SecurityContextHolder.getContext().getAuthentication().getName());

        Pet pet = petService.findById(bidDTO.getPetId());

        Bid bid=bidRepository.findByUserIdAndPetId(user.getId(),pet.getId());

        if (Objects.nonNull(bid))
            bid.setPrice(bidDTO.getBitAmount());
        else
              bid =new Bid(pet,user, pet.getPrice());

        try {
            bidRepository.save(bid);
            logger.info("bid saved.....");
        }

        catch (HibernateException exception){

            logger.error("exception while saving bid "+ exception.getMessage());
            exception.printStackTrace();
            throw new ResourceSaveException(exception.getMessage());
        }
        return bidDTO;
    }

    @Override
    public List<BidResultDto> getPids(Integer petId) {

        User user=userService.getCurrentUser(SecurityContextHolder.getContext().getAuthentication().getName());

        Optional<Pet> pet = user.getPets().stream().filter(x->x.getId().equals(petId)).findAny();
        if(pet==null||!pet.isPresent())
        throw new ResourceNotExistException(ErrorMessages.USER_HAVE_NO_PET_WITH_THIS_ID.getValue());
        List<BidResultDto> bidResultDtos=pet.get().getBids().stream().map(x->convertBidToDto(x)).collect(Collectors.toList());

        return bidResultDtos;
    }
    private BidResultDto convertBidToDto(Bid bid)
    {
        BidResultDto bidResultDto = new BidResultDto(bid.getUserBids().getUsername(),bid.getPrice());
        return bidResultDto;
    }
}
