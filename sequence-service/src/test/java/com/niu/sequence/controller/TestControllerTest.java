package com.niu.sequence.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @program: analysis-sequence
 * @description:
 * @author: zhengzz
 * @create: 2020-01-03 11:31
 **/
@AutoConfigureMockMvc
@Slf4j
public class TestControllerTest extends  BaseController{
    @Autowired
    protected MockMvc mockMvc;

    @Before
    public void before() {
        mockMvc = MockMvcBuilders.standaloneSetup(TestController.class).build();
    }
    @Test
    public void testGetSequence() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/server/info"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}
