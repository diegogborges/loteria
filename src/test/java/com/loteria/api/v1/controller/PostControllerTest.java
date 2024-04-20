package com.loteria.api.v1.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class PostControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Spy
    private PostController postController;

    @BeforeEach
    public void setup() {

    }

    @Test
    void test() {
    }

}