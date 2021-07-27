package pl.danyboy;

import java.util.ArrayList;
import java.util.List;

public class PasswordManager {
    private List<String> passwords;
    private RandomGenerator randomGenerator = new RandomGenerator();

    public PasswordManager() {
        passwords = new ArrayList<>();
        passwords.add("Apetyt rośnie w miarę jedzenia");
        passwords.add("Co dwie głowy, to nie jedna");
        passwords.add("Cwiczenie czyni mistrza");
        passwords.add("Darowanemu koniowi w zęby się nie zagląda");
        passwords.add("Diabeł tkwi w szczegółach");
        passwords.add("Elektryka prąd nie tyka");
    }

    public String getRandomPassword() {
        return passwords.get(randomGenerator.numberGenerator(passwords.size()));
    }
}
