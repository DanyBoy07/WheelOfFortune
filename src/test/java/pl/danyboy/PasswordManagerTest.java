package pl.danyboy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordManagerTest {

    @Test
    public void shouldAddPasswordWhenIsUnique() {
        PasswordManager passwordManager = new PasswordManager();
        String password = "Apetyt rośnie w miarę jedzenia";

        passwordManager.setPasswords(password);

        assertEquals(password, passwordManager.getRandomPassword());
    }

    @Test
    public void shouldThrowIllegalStateExceptionWhenPasswordIsRepeated() {
        PasswordManager passwordManager = new PasswordManager();
        String password = "Apetyt rośnie w miarę jedzenia";

        passwordManager.setPasswords(password);
        passwordManager.getRandomPassword();

        assertThrows(IllegalStateException.class, ()-> passwordManager.getRandomPassword());
    }
}