package com.aman.controller;

import com.aman.WalsmartTests;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

public class AssignmentsControllerTest extends WalsmartTests {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void tasksList() throws Exception{
        mockMvc.perform(get("/assignments")).andExpect(status().isOk())
                .andExpect(view().name("assignments"))
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(model().attributeExists("tasks"))
                .andExpect(model().attributeExists("users"))
                .andExpect(model().attributeExists("assignments"));
    }

    @Test
    public void saveAssignment() throws Exception{
        mockMvc.perform(post("/createassignment")
                .param("userId", "1")
                .param("taskId", "1")
                .param("date", "1525941863000"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().string("2"));
    }

    @Test
    public void removeAssignment() throws Exception{
        mockMvc.perform(post("/removeassignment")
                .param("Id", "1"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().string("1"));
    }

    @Test
    public void closeAssignment() throws Exception{
        mockMvc.perform(post("/closeassignment")
                .param("Id", "1"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().string("1"));
    }

    @Test
    public void updateAssignment() throws Exception{
        mockMvc.perform(post("/updateassignment")
                .param("Id", "1")
                .param("notes", "Test Notes"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().string("1"));
    }
}