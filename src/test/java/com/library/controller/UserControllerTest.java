package com.library.controller;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.library.LibraryManagement;
import com.library.dto.ResponseDetails;
import com.library.dto.UserDTO;
import com.library.utils.JsonMappingUtils;

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

     /**
     * Sets the up.
     */
    @Before
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
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
        UserDTO.setRoleId("1");
        UserDTO.setPhoneNumber("98111111");
        UserDTO.setAddress("Noida");
        UserDTO.setEmail("abc@123.com");
        String inputJson = JsonMappingUtils.mapToJson(UserDTO);

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        ResponseDetails response = JsonMappingUtils.mapFromJson(content, ResponseDetails.class);
        assertEquals("User Added successfully", response.getMessage());
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
        UserDTO[] resultBooks = JsonMappingUtils.mapFromJson(content, UserDTO[].class);
        assertEquals("Ram", resultBooks[0].getUserName());
        System.out.println(" testGetAllUsers Successful");
    }

}
