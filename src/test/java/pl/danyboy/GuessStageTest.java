package pl.danyboy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuessStageTest {

    @Test
    public void shouldReturnTrueWhenPasswordIsEqual() {
        GuessStage guessStage = new GuessStage();
        String passwordA = "AASDsssdfffAA";
        String passwordB = "aaSDsssdfffaa";

        assertEquals(guessStage.checkPassword(passwordA, passwordB), true);

    }

    @Test
    public void shouldReturnFalseWhenPasswordIsNotEqual() {
        GuessStage guessStage = new GuessStage();
        String passwordA = "AASDsssdfffAA";
        String passwordB = "111aaaddddDDDAS";

        assertEquals(guessStage.checkPassword(passwordA, passwordB), false);
    }
}
