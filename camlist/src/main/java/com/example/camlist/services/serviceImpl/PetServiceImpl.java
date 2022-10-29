package com.example.camlist.services.serviceImpl;

import com.example.camlist.Enums.ErrorMessages;
import com.example.camlist.dtos.CategoryDTO;
import com.example.camlist.dtos.PetDTO;
import com.example.camlist.dtos.TagDTO;
import com.example.camlist.entities.product.Pet;
import com.example.camlist.entities.store.Category;
import com.example.camlist.entities.store.Tag;
import com.example.camlist.entities.user.User;
import com.example.camlist.exceptions.ResourceNotExistException;
import com.example.camlist.exceptions.ResourceSaveException;
import com.example.camlist.repositories.CategoryRepository;
import com.example.camlist.repositories.PetRepository;
import com.example.camlist.repositories.TagRepository;
import com.example.camlist.services.PetService;
import com.example.camlist.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PetServiceImpl implements PetService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private PetRepository petRepository;
    private CategoryRepository categoryRepository;
    private TagRepository tagRepository;
    private UserService userService;

    public PetServiceImpl(PetRepository petRepository,CategoryRepository categoryRepository,TagRepository tagRepository,UserService userService)
    {
        this.categoryRepository=categoryRepository;
        this.petRepository=petRepository;
        this.tagRepository=tagRepository;
        this.userService=userService;
    }
    @Transactional
    public PetDTO addPet(PetDTO petDTO)
    {

         List<Tag> tags=petDTO.getTags().stream().map(x->isTagExist(x.getName())).collect(Collectors.toList());

         Category category=isCategoryExist(petDTO.getPetCategory().getName());

         User user=userService.getCurrentUser(SecurityContextHolder.getContext().getAuthentication().getName());
         Pet pet=new Pet.Builder().name(petDTO.getName())
                .price(petDTO.getPrice())
                .petStatus(petDTO.getPetStatus())
                .tags(tags)
                .petCategory(category)
                 .owner(user)
                .build();
         try{
            pet = petRepository.save(pet);
            }
             catch (Exception exception){

        logger.error("exception while saving pet "+ exception.getMessage());
        throw new ResourceSaveException(exception.getMessage());
    }

         petDTO.setPetId(pet.getId());

          return petDTO;
    }
    private Tag isTagExist(String tag)
    {
       Tag storedTag= tagRepository.findByName(tag);
       if(Objects.nonNull(storedTag))
           return storedTag;
       throw new ResourceNotExistException(ErrorMessages.TAG_NOT_FOUND.getValue());
    }
    private Category isCategoryExist(String category){
        Category storedCategory = categoryRepository.findByName(category);
        if(Objects.nonNull(storedCategory))
            return storedCategory;
        throw new ResourceNotExistException(ErrorMessages.CATEGORY_NOT_FOUND.getValue());
    }

    public List<PetDTO> findByTag(String tag){

       Tag storedTag=tagRepository.findByName(tag);

       if (storedTag!=null&&Objects.nonNull(storedTag.getPets())){
           return storedTag.getPets().stream().map(x->convertToDto(x)).collect(Collectors.toList());
       }

       return new ArrayList<>();
    }

    private PetDTO convertToDto(Pet pet){

        if (pet!=null && Objects.nonNull(pet)){
            PetDTO petDTO = PetDTO.builder().petId(pet.getId()).name(pet.getName())
                .petCategory(new CategoryDTO(pet.getPetCategory().getId(),pet.getPetCategory().getName()))
                .petStatus(pet.getPetStatus())
                .price(pet.getPrice())
                .tags(pet.getTags().stream().map(x->new TagDTO(x.getId(),x.getName())).collect(Collectors.toList()))
                .build();
        return petDTO;
        }
        return null;
    }

    public Pet findById(Integer id)
    {
      Pet pet= petRepository.findByIdCustom(id);
      if (pet!=null)return pet;
      throw new ResourceNotExistException(ErrorMessages.PET_ID_NOT_EXIST.getValue());
    }
}
