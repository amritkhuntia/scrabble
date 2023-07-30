package com.amrit.org.scrabble.scrabble.controller;

import com.amrit.org.scrabble.scrabble.entity.ScrabbleScore;
import com.amrit.org.scrabble.scrabble.service.ScrabbleService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scrabble")
public class ScrabbleController {

    @Autowired
    private ScrabbleService scrabbleService;

    @PostMapping(value = "/v1/input")
    public ScrabbleScore scrabble(@NotNull @RequestParam String word){
        return scrabbleService.getScore(word.toUpperCase());
    }

    @PostMapping("/v1/save")
    public ScrabbleScore saveScore(@NotNull @RequestParam String word){
        return scrabbleService.saveScore(word.toUpperCase());
    }

    @GetMapping("/v1/get_top_ten")
    public List<ScrabbleScore> getTopTen(){
        return scrabbleService.getTopTenScores();
    }
}
