package pl.danyboy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidationTest {

    @Test
    public void shouldReturnTrueWhenPasswordIsEqual() {
        Validation guessStage = new Validation();
        String passwordA = "AASDsssdfffAA";
        String passwordB = "aaSDsssdfffaa";

        assertEquals(guessStage.checkPassword(passwordA, passwordB), true);

    }

    @Test
    public void shouldReturnFalseWhenPasswordIsNotEqual() {
        Validation guessStage = new Validation();
        String passwordA = "AASDsssdfffAA";
        String passwordB = "111aaaddddDDDAS";

        assertEquals(guessStage.checkPassword(passwordA, passwordB), false);
    }
}
