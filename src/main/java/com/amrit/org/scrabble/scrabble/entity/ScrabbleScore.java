package com.amrit.org.scrabble.scrabble.entity;

import lombok.Generated;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Setter
@Getter
@Entity
public class ScrabbleScore {

    @Id
    @GeneratedValue
    private int id;

    @NonNull
    String word;

    int score;
}
