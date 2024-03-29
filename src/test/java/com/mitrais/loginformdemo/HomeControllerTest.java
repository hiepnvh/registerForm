package com.mitrais.loginformdemo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mitrais.registerformdemo.controller.HomeController;
import com.mitrais.registerformdemo.model.User;
import com.mitrais.registerformdemo.service.UserService;
import com.mitrais.registerformdemo.util.UserValidator;

@RunWith(SpringRunner.class)
@SpringBootTest( classes = HomeController.class)
@AutoConfigureMockMvc(secure=false)
public class HomeControllerTest {
	
	@Autowired
    private MockMvc mvc;
	
	@InjectMocks
	private HomeController homeController;
	
	@MockBean
	private UserService userService;
	
	@MockBean
	private UserValidator userValidator;
	
	@Before
    public void setUp() throws Exception {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/");
        viewResolver.setSuffix(".jsp");
        
        MockitoAnnotations.initMocks(this);

        mvc = MockMvcBuilders.standaloneSetup(homeController)
                                 .setViewResolvers(viewResolver)
                                 .build();
    }
	
	@Test
//	@Transactional
	public void register() throws Exception{
		User newUser = new User();
		newUser.setEmail("test@abc.com");
		newUser.setFirstName("test");
		newUser.setLastName("test");
		newUser.setMobileNumber("0999123123");
		mvc.perform(post("/registration")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
	            .content(buildUrlEncodedFormEntity(
	                    "email", "test@abc.com", 
	                    "mobileNumber", "0999123123",
	                    "firstName","sdf",
	                    "lastName","sdfsd",
	                    "dateOfBirth","",
	                    "gender",""
	               )))
                .andExpect(status().isOk());
	}
	
	@Test
	public void registerGet() throws Exception{
		mvc.perform(get("/registration"))
                .andExpect(status().isOk());
	}
	
	
	private String buildUrlEncodedFormEntity(String... params) {
	    if( (params.length % 2) > 0 ) {
	       throw new IllegalArgumentException("Need to give an even number of parameters");
	    }
	    StringBuilder result = new StringBuilder();
	    for (int i=0; i<params.length; i+=2) {
	        if( i > 0 ) {
	            result.append('&');
	        }
	        try {
	            result.
	            append(URLEncoder.encode(params[i], StandardCharsets.UTF_8.name())).
	            append('=').
	            append(URLEncoder.encode(params[i+1], StandardCharsets.UTF_8.name()));
	        }
	        catch (UnsupportedEncodingException e) {
	            throw new RuntimeException(e);
	        }
	    }
	    return result.toString();
	 }

}
