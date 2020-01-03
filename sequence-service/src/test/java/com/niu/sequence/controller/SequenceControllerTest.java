package com.niu.sequence.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @program: analysis-sequence
 * @description:
 * @author: zhengzz
 * @create: 2019-12-31 12:23
 **/
@AutoConfigureMockMvc
@Slf4j
public class SequenceControllerTest extends  BaseController{
    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private SequenceController sequenceController;

    @Before
    public void before() {
        mockMvc = MockMvcBuilders.standaloneSetup(sequenceController).build();
    }
    @Test
    public void testGetSequence() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/niu/v1/sequence/snow").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }




}
