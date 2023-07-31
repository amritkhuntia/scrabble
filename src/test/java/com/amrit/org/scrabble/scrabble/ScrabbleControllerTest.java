package com.amrit.org.scrabble.scrabble;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ScrabbleControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    @DisplayName("Test english letters")
    void testCalculateScore() throws Exception {

        mockMvc.perform(post("/scrabble/v1/input/?word=exciting")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(content().string("{\"id\":0,\"word\":\"EXCITING\",\"score\":18}"));
    }

    @Test
    @DisplayName("Test Non characters")
    void testCalculateScore_Non_Characters() throws Exception {

        mockMvc.perform(post("/scrabble/v1/input/?word=468gfug")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(content().string("{\"id\":0,\"word\":\"468GFUG\",\"score\":0}"));
    }
}
