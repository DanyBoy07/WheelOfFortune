package pl.danyboy;

import java.util.ArrayList;
import java.util.List;

public class PasswordStage {
    private final List<Character> corectGuesses = new ArrayList<>();

    public String getObscuredPassword(String password, String inputFromUser) {
        StringBuilder stringBuilder = new StringBuilder();

        if (inputCheck(password, inputFromUser)) return password;

        addLetterToCorectGuess(password, inputFromUser);

        createPassword(password, stringBuilder);
        return stringBuilder.toString();

    }

    private boolean inputCheck(String password, String inputFromUser) {
        return password.equalsIgnoreCase(inputFromUser);
    }

    private void addLetterToCorectGuess(String password, String inputFromUser) {
        char letter;
        if (inputFromUser != null && password.contains(inputFromUser)) {
            letter = transformToLetter(inputFromUser);
            lettersAddToCorectGuesses(letter);
        }
    }

    private void createPassword(String password, StringBuilder stringBuilder) {
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) == ' ') {
                stringBuilder.append(' ');
            } else if (corectGuesses.contains(password.charAt(i))) {
                stringBuilder.append(password.charAt(i));
            } else {
                stringBuilder.append('-');
            }
        }
    }

    public void resetListOfChars() {
        corectGuesses.clear();
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
