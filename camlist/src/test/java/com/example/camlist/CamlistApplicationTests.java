package com.example.camlist;

import com.example.camlist.controllers.UserController;
import com.example.camlist.dtos.CreatedUserDTO;
import com.example.camlist.dtos.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.BDDMockito.given;
@SpringBootTest
class CamlistApplicationTests {
	@Autowired
	private MockMvc mvc;

	@MockBean
	private UserController userController;
	@Autowired
	private TestEntityManager entityManager;
	@Test
	void contextLoads() {
	}


}
