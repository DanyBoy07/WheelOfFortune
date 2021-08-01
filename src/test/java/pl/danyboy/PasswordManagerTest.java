package pl.danyboy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PasswordManagerTest {

    @Test
    public void shouldAddPasswordWhenIsUnique() {
        List<String> passwords = new ArrayList<>();
        passwords.add("Apetyt rośnie w miarę jedzenia");
        passwords.add("Co dwie głowy, to nie jedna");
        passwords.add("Ćwiczenie czyni mistrza");
        passwords.add("Darowanemu koniowi w zęby się nie zagląda");
        passwords.add("Diabeł tkwi w szczegółach");
        passwords.add("Elektryka prąd nie tyka");

        PasswordManager passwordManager = new PasswordManager();
        String password = passwordManager.getRandomPassword();

        assertTrue(passwords.contains(password));


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