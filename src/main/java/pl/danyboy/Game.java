package pl.danyboy;

import java.util.List;

public class Game {
    private final PasswordManager passwordManager;
    private final GuessStage guessStage;
    private final LineReader lineReader;
    private final PasswordStage passwordStage;

    public Game(PasswordManager passwordManager, GuessStage guessStage, LineReader lineReader, PasswordStage passwordStage) {
        this.passwordManager = passwordManager;
        this.guessStage = guessStage;

        this.lineReader = lineReader;
        this.passwordStage = passwordStage;
    }

    public void roundsOfGame(List<Player> players) throws IllegalStateException {
        int rounds = 4;
        for (int i = 0; i < rounds; i++) {
            System.out.println("Rozpoczęła się runda " + (i + 1));
            String randomPassword = passwordManager.getRandomPassword();
            System.out.println(passwordStage.getObscuredPassword(randomPassword, null));
            for (Player player : players) {
                System.out.println("Tura gracza " + player.toString());
                System.out.println("Wpisz hasło lub pojedyńczą literę: ");
                String input = lineReader.readLineFromUser();
                guessStage.passwordGuessesInformation(randomPassword, input);
                System.out.println(passwordStage.getObscuredPassword(randomPassword, input));
            }
            passwordStage.resetListOfChars();
        }
    }
}
