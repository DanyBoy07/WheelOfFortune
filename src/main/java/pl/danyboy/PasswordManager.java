package pl.danyboy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PasswordManager {
    //true if password can be used, false is password was used during the game
    private final Map<String, Boolean> passwords = new HashMap<>();
    private final RandomGenerator randomGenerator = new RandomGenerator();

    public PasswordManager() {
        passwords.put("Apetyt rośnie w miarę jedzenia", true);
        passwords.put("Co dwie głowy, to nie jedna", true);
        passwords.put("Ćwiczenie czyni mistrza", true);
        passwords.put("Darowanemu koniowi w zęby się nie zagląda", true);
        passwords.put("Diabeł tkwi w szczegółach", true);
        passwords.put("Elektryka prąd nie tyka", true);
    }

    public String getRandomPassword() {
        List<String> keys = new ArrayList<>(passwords.keySet());
        while (true) {
            if (checkValues()) {
                throw new IllegalStateException("brak unikalnego hasła");
            }
            String password = keys.get(randomGenerator.numberGenerator(keys.size()));
            if (extracted(password)) {
                return password;
            }
        }
    }

    public long guessLetter(char guessLetter, String password) {
        return password.toLowerCase().chars().filter(ch -> ch == Character.toLowerCase(guessLetter)).count();
    }

    public boolean guessPassword(String guessPassword, String password) {
        return password.equalsIgnoreCase(guessPassword);
    }

    public void setPasswords(String newPassword) {
        if (passwords.containsKey(newPassword)) {
            throw new IllegalArgumentException("Podane hasło już istnieje");
        }
        passwords.put(newPassword, true);
    }

    private boolean extracted(String password) {
        if (passwords.get(password)) {
            passwords.put(password, false);
            return true;
        }
        return false;
    }

    private boolean checkValues() {
        for (Boolean value : passwords.values()) {
            if (value) {
                return false;
            }
        }
        return true;
    }
}
