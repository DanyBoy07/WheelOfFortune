package pl.danyboy;

import java.util.List;

public class Game {
    private final PasswordManager passwordManager;
    private final GuessStage guessStage;

    public Game(PasswordManager passwordManager, GuessStage guessStage) {
        this.passwordManager = passwordManager;
        this.guessStage = guessStage;
    }

    public void roundsOfGame(List<Player> players) throws IllegalStateException {
        int rounds = 4;
        for (int i = 0; i < rounds; i++) {
            System.out.println("Rozpoczęła się runda " + (i + 1));
            String randomPassword = passwordManager.getRandomPassword();
            System.out.println(randomPassword);
            for (Player player : players) {
                System.out.println("Tura gracza " + player.toString());
                guessStage.passwordGuesses(randomPassword);
            }
        }
    }
}
