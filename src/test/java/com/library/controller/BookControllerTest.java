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
import com.library.dto.BookDTO;
import com.library.dto.ResponseDetails;
import com.library.utils.JsonMappingUtils;



/**
 * The Class BookControllerTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = LibraryManagement.class)
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ActiveProfiles("test")
public class BookControllerTest {

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
     * Test add book.
     *
     * @throws Exception the exception
     */
    @Test
    public void testAddBook() throws Exception {
        String uri = "/book/addbook";
        BookDTO bookDto = new BookDTO();
        bookDto.setAuthor("Ram");
        bookDto.setBookId(1);
        bookDto.setIsbn("978-3-16-148410-0");
        bookDto.setLibId(1);
        bookDto.setNumOfCopies(1);
        bookDto.setPublisher("A-Press");
        bookDto.setTitle("Java");
        bookDto.setYearOfPublication("2020");
        String inputJson = JsonMappingUtils.mapToJson(bookDto);

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        ResponseDetails response =  JsonMappingUtils.mapFromJson(content, ResponseDetails.class);
        assertEquals("Book Added successfully", response.getMessage());
        System.out.println(" testAddBook Successfull");
    }

    /**
     * Test get all books.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetAllBooks() throws Exception {
        String uri = "/book/listBooks"; 
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        BookDTO[] resultBooks =  JsonMappingUtils.mapFromJson(content, BookDTO[].class);
        assertEquals("Java", resultBooks[0].getTitle());
        System.out.println(" get List of books done");
    }

}
