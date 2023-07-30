package com.amrit.org.scrabble.scrabble;

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
    private ResultMatcher resultMatcher;


 /*   @Test
    void testCalculateScore() throws Exception {

        resultMatcher = result -> mockMvc.perform(post("/scrabble/v1/input/?word=gudu")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$['response'].score", is("1" )));
    }*/
}
