package pl.danyboy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PasswordManagerTest {

    @Test
    public void shouldDrawPasswordWhenIsNeverUsed() {
        PasswordManager passwordManager = new PasswordManager();
        String password = passwordManager.getRandomPassword();

        if (password.equals("Apetyt rośnie w miarę jedzenia")) {
            assertEquals(password, "Apetyt rośnie w miarę jedzenia");
        } else if (password.equals("Co dwie głowy, to nie jedna")) {
            assertEquals(password, "Co dwie głowy, to nie jedna");
        } else if (password.equals("Ćwiczenie czyni mistrza")) {
            assertEquals(password, "Ćwiczenie czyni mistrza");
        } else if (password.equals("Ćwiczenie czyni mistrza")) {
            assertEquals(password, "Ćwiczenie czyni mistrza");
        } else if (password.equals("Darowanemu koniowi w zęby się nie zagląda")) {
            assertEquals(password, "Darowanemu koniowi w zęby się nie zagląda");
        } else if (password.equals("Diabeł tkwi w szczegółach")) {
            assertEquals(password, "Diabeł tkwi w szczegółach");
        } else if (password.equals("Elektryka prąd nie tyka")) {
            assertEquals(password, "Elektryka prąd nie tyka");
        }

    }


    @Test
    public void shouldThrowIllegalStateExceptionWhenPasswordIsRepeated() {
        PasswordManager passwordManager = new PasswordManager();
        int sizeOfList = 6;

        for (int i = 0; i < sizeOfList; i++) {
            passwordManager.getRandomPassword();
        }

        assertThrows(IllegalStateException.class, () -> passwordManager.getRandomPassword());
    }
}