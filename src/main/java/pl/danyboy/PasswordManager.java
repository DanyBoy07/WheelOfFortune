package pl.danyboy;

import java.util.*;

import static java.lang.Character.isLetter;

public class PasswordManager {
    //true if password can be used, false is password was used during the game
    private Map<String, Boolean> passwords = new HashMap<>();
    private final List<Character> corectGuesses = new ArrayList<>();
    private String currentPassword = null;

    public PasswordManager() {
        passwords.put("Apetyt rośnie, w miarę jedzenia", true);
        passwords.put("Co dwie głowy to nie jedna", true);
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
            String password = keys.get(numberGenerator(keys.size()));
            if (usedPassword(password)) {
                corectGuesses.clear();
                return currentPassword = password;
            }
        }
    }

    public String getObscuredPassword() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < currentPassword.length(); i++) {
            if (corectGuesses.contains(currentPassword.charAt(i))) {
                stringBuilder.append(currentPassword.charAt(i));
            } else if (isNotALetter(i)) {
                stringBuilder.append(currentPassword.charAt(i));
            } else {
                stringBuilder.append('-');
            }

        }
        return stringBuilder.toString();
    }

    public boolean checkPassword() {
        return currentPassword.equalsIgnoreCase(getObscuredPassword());
    }

    private boolean isNotALetter(int index) {
        return !(isLetter(currentPassword.charAt(index)));
    }

    public long guessLetter(String inputFromUser) {
        char guessLetter = transformToChar(inputFromUser);
        if (!(corectGuesses.contains(guessLetter) && (currentPassword.toLowerCase().contains(inputFromUser)))) {
            lettersAddToCorectGuesses(guessLetter);
            return currentPassword.toLowerCase().chars().filter(ch -> ch == Character.toLowerCase(guessLetter)).count();
        }
        return 0;
    }

    private void lettersAddToCorectGuesses(char letter) {
        corectGuesses.add(letter);
        corectGuesses.add(switchCharToOpposite(letter));
    }

    public boolean guessPassword(String guessPassword, String password) {
        return password.equalsIgnoreCase(guessPassword);
    }



    private boolean usedPassword(String password) {
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

    private char transformToChar(String inputFromUser) {
        int index = 0;
        return inputFromUser.trim().charAt(index);
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    private int numberGenerator(int number) {
        Random random = new Random();
        return random.nextInt(number);
    }

    private char switchCharToOpposite(char letter) {
        if (Character.isLowerCase(letter)) {
            return Character.toUpperCase(letter);
        }
        return Character.toLowerCase(letter);
    }

}
