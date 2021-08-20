package pl.danyboy;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordStage {
    private final List<Character> corectGuesses = new ArrayList<>();

    public String getObscuredPassword(String password, String inputFromUser) {

        if (inputCheck(password, inputFromUser)) return password;

        addLetterToCorectGuess(inputFromUser);

        return createPassword(password, getObscuredPassword(password));

    }

    public String getObscuredPassword(String password) {
        String replace = "-";
        StringBuilder stringBuilder = new StringBuilder(password);
        Pattern pattern = Pattern.compile("\\p{L}");
        Matcher matcher = pattern.matcher(stringBuilder);

        int startIndex = 0;
        while (matcher.find(startIndex)) {
            stringBuilder.replace(matcher.start(), matcher.end(), replace);
        }
        return stringBuilder.toString();
    }

    public void resetListOfChars() {
        corectGuesses.clear();
    }

    private boolean inputCheck(String password, String inputFromUser) {
        return password.equalsIgnoreCase(inputFromUser);
    }

    private void addLetterToCorectGuess(String inputFromUser) {
        lettersAddToCorectGuesses(transformToLetter(inputFromUser));
    }

    private String createPassword(String password, String actualPassword) {

        StringBuilder stringBuilder = new StringBuilder(actualPassword);
        for (int i = 0; i < password.length(); i++) {
            if (corectGuesses.contains(password.charAt(i))) {
                stringBuilder.setCharAt(i, password.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    private char transformToLetter(String letterFromUser) {
        int index = 0;
        return letterFromUser.trim().charAt(index);
    }

    private void lettersAddToCorectGuesses(char letter) {
        corectGuesses.add(letter);
        corectGuesses.add(switchCharToOpposite(letter));
    }

    private char switchCharToOpposite(char letter) {
        if (Character.isLowerCase(letter)) {
            return Character.toUpperCase(letter);
        }
        return Character.toLowerCase(letter);
    }
}
