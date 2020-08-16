package com.library.controller;


import static org.junit.Assert.assertEquals;

import java.io.IOException;

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

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.LibraryManagement;
import com.library.dto.LibraryDTO;
import com.library.dto.ResponseDetails;
import com.library.utils.JsonMappingUtils;


// TODO: Auto-generated Javadoc
/**
 * The Class LibraryControllerTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = LibraryManagement.class)
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ActiveProfiles("test")
public class LibraryControllerTest {

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
     * Test add library.
     *
     * @throws Exception the exception
     */
    @Test
    public void testAddLibrary() throws Exception {
        String uri = "/library/addlibrary";
        LibraryDTO libDto = new LibraryDTO();
        libDto.setLibId(1);
        libDto.setLibName("ABC Library");
        libDto.setAddress("Sec 10, Noida");
        libDto.setPhoneNumber("981111111");
        String inputJson = JsonMappingUtils.mapToJson(libDto);

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        ResponseDetails response = JsonMappingUtils.mapFromJson(content, ResponseDetails.class);
        assertEquals("Library Added successfully", response.getMessage());
        System.out.println(" testAddLibrary Successfull");
    }
    
}
