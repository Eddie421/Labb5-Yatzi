package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class YatziTest {
    @Test
    void isYatziWhenAllDiceMatches() {
        Die[] dice = new Die[]{
                new Die(), new Die(), new Die(), new Die(), new Die()
        };
        for (Die die : dice) {
            die.setValue(6);
        }

        Yatzi yatzi = new Yatzi();
        yatzi.setDice(dice);
        assertTrue(yatzi.isYatzi());
    }

    @Test
    void isNotYatziWhenOneDieIsNotMatchingTheOther() {
        Die[] dice = new Die[]{
                new Die(), new Die(), new Die(), new Die(), new Die()

        };
        for (Die die : dice) {
            die.setValue(6);
        }
        dice[4].setValue(1);
        Yatzi yatzi = new Yatzi();
        yatzi.setDice(dice);
        assertFalse(yatzi.isYatzi());
    }
}