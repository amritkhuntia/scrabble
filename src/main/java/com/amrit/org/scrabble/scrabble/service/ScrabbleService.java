package com.amrit.org.scrabble.scrabble.service;

import com.amrit.org.scrabble.scrabble.entity.ScrabbleScore;
import com.amrit.org.scrabble.scrabble.repo.ScrabbleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class ScrabbleService {

    @Autowired
    private ScrabbleRepo scrabbleRepo;

    public ScrabbleScore saveScore(String word){
        int score = calculate(word);
        ScrabbleScore scrabble = new ScrabbleScore();
        scrabble.setWord(word);
        scrabble.setScore(score);
        return scrabbleRepo.save(scrabble);
    }

    public ScrabbleScore getScore(String word) {
        int score = calculate(word);
        ScrabbleScore scrabble = new ScrabbleScore();
        scrabble.setWord(word);
        scrabble.setScore(score);
        return scrabble;
    }
    private int calculate(String word){
        if(isMatchingPattern(word)) {
            int score = 0;
            char[] scrabbleArray = word.toCharArray();

            for (Character alphabet : scrabbleArray) {
                score += getCharacterValue(alphabet);
            }
            System.out.println("score: " + score);
            return score;
        }else {
            return 0;
        }
    }

    private int getCharacterValue(char alphabet){
        if(Character.isAlphabetic(alphabet)){
            switch(alphabet){
                case 'D':
                case 'G': return 2;

                case 'B':
                case 'C':
                case 'M':
                case 'P': return 3;

                case 'F':
                case 'H':
                case 'V':
                case 'W':
                case 'Y': return 4;

                case 'K': return 6;

                case 'J':
                case 'X': return 8;

                case 'Q':
                case 'Z': return 10;

                default: return 1;
            }
        }else {
            return 0;
        }
    }

    public boolean isMatchingPattern(String word){
        String pattern ="[a-zA-Z]+";
        return Pattern.matches(pattern, word);
    }

    public List<ScrabbleScore> getTopTenScores(){
        return scrabbleRepo.getTopTenScores();
    }

}
