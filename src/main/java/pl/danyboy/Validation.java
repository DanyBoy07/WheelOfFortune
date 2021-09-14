package pl.danyboy;

public class Validation {

    public boolean checkLettersInPassword(String password, String inputFromUser) {
        inputFromUser = inputFromUser.trim();
        return password.toLowerCase().indexOf(Character.toLowerCase(inputFromUser.charAt(0))) >= 0;
    }

    public boolean checkPassword(String password, String inputPassword) {
        return password.equalsIgnoreCase(inputPassword);
    }

    public boolean isALetter(String input) {
        return input.trim().length() <= 1;
    }


}
