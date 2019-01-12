package com.example.smit;

import com.example.smit.controller.AuthController;
import com.example.smit.repository.RoleRepository;
import com.example.smit.request.SignUpForm;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import java.io.IOException;
import java.util.*;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SmitApplication.class)
@WebAppConfiguration
public class SmitApplicationTest {

    @InjectMocks
    private AuthController authController;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private RoleRepository roleRepository;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(this.authController).build();
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }

    protected <T> T mapFromJson(String json, Class<T> clazz)
            throws JsonParseException, JsonMappingException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, clazz);
    }

    @Test
    public void signUpStatusTest() throws Exception {
        String url = "http://localhost:8888/auth/signup";
        Set<String> roles = new HashSet<>();
        roles.add("smit");
        roles.add("user");
        roles.add("admin");
        SignUpForm signUpForm = new SignUpForm();
        signUpForm.setFullName("Smit User");
        signUpForm.setPassword("123456789");
        signUpForm.setPhoneNumber("5012345");
        signUpForm.setRole(roles);
        signUpForm.setUserName("smitUser");

        String json = mapToJson(signUpForm);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(json)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }
}
