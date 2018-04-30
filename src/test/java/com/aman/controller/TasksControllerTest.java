package com.aman.controller;

import com.aman.WalsmartTests;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class TasksControllerTest extends WalsmartTests {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void tasksList() throws Exception{
        mockMvc.perform(get("/tasks")).andExpect(status().isOk())
                .andExpect(view().name("tasks"))
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(model().attributeExists("tasks"))
                .andExpect(model().attribute("tasks", hasItem(
                        allOf(
                                hasProperty("taskId", is(1L)),
                                hasProperty("taskName", is("Move Boxes")),
                                hasProperty("taskPriority", is("Medium")),
                                hasProperty("taskEstimatedTime", is(2L))
                        )
                )))
                .andExpect(model().attribute("tasks", hasItem(
                        allOf(
                                hasProperty("taskId", is(2L)),
                                hasProperty("taskName", is("Deliver Goods")),
                                hasProperty("taskPriority", is("High")),
                                hasProperty("taskEstimatedTime", is(1L))
                        )
                )))
                .andExpect(model().attribute("tasks", hasItem(
                        allOf(
                                hasProperty("taskId", is(3L)),
                                hasProperty("taskName", is("Arrange Shelf Items")),
                                hasProperty("taskPriority", is("Low")),
                                hasProperty("taskEstimatedTime", is(3L))
                        )
                )));
    }

    @Test
    public void saveTask() throws Exception{
        mockMvc.perform(post("/savetask")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"taskName\": \"Test Task\",\n" +
                        "  \"taskPriority\": \"Medium\",\n" +
                        "  \"taskEstimatedTime\": \"2\"\n" +
                        "}"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().string("4"));
    }
}