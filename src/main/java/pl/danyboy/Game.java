package pl.danyboy;

import java.util.List;

public class Game {
    private PasswordManager passwordManager;

    public Game(PasswordManager passwordManager) {
        this.passwordManager = passwordManager;
    }

    public void roundsOfGame(List<Player> players) {
        int rounds = 4;
        for (int i = 0; i < rounds; i++) {
            System.out.println("Rozpoczęła się runda " + (i + 1));
            System.out.println(passwordManager.getRandomPassword());
            for (Player player : players) {
                System.out.println("Tura gracza " + player.toString());
            }
        }
    }
}
