package com.liabrary.controller;


import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.LibraryManagement;
import com.library.dto.UserDTO;
import com.library.dto.ResponseDetails;


// TODO: Auto-generated Javadoc
/**
 * The Class UserControllerTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = LibraryManagement.class)
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ActiveProfiles("test")
public class UserControllerTest {

    /** The mvc. */
    protected MockMvc mvc;

    /** The web application context. */
    @Autowired
    WebApplicationContext webApplicationContext;

    /** The my propertytestapp. */
    @Value("${myProperty.test.app:0}")
    private String myPropertytestapp;

    /**
     * Sets the up.
     */
    @Before
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    /**
     * Map to json.
     *
     * @param obj the obj
     * @return the string
     * @throws JsonProcessingException the json processing exception
     */
    private String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }

    /**
     * Map from json.
     *
     * @param <T> the generic type
     * @param json the json
     * @param clazz the clazz
     * @return the t
     * @throws JsonParseException the json parse exception
     * @throws JsonMappingException the json mapping exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private <T> T mapFromJson(String json, Class<T> clazz) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, clazz);
    }

    /**
     * Test add user.
     *
     * @throws Exception the exception
     */
    @Test
    public void testAddUser() throws Exception {
        String uri = "/user/adduser";
        UserDTO UserDTO = new UserDTO();
        UserDTO.setUserId(1);
        UserDTO.setUserName("Ram");
        UserDTO.setPassword("Ram");
        UserDTO.setRoleId("1");
        UserDTO.setPhoneUmber("98111111");
        UserDTO.setAddress("Noida");
        UserDTO.setEmail("abc@123.com");
        String inputJson = mapToJson(UserDTO);

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        ResponseDetails response = mapFromJson(content, ResponseDetails.class);
        assertEquals("User Added successfully", response.getMessageReason());
        System.out.println(" testAddBook Successfull");
    }

    /**
     * Test get all users.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetAllUsers() throws Exception {
        String uri = "/user/listusers"; 
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        UserDTO[] resultBooks = mapFromJson(content, UserDTO[].class);
        assertEquals("Ram", resultBooks[0].getUserName());
        System.out.println(" testGetAllUsers Successful");
    }

}
