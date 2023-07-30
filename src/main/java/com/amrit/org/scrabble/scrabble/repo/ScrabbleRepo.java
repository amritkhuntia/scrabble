package com.amrit.org.scrabble.scrabble.repo;

import com.amrit.org.scrabble.scrabble.entity.ScrabbleScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScrabbleRepo extends JpaRepository<ScrabbleScore, Integer> {

    @Query(value = "select * from scrabble_score  ORDER BY score DESC limit 10", nativeQuery = true)
    public List<ScrabbleScore> getTopTenScores();
}
