package pl.danyboy;

import java.util.List;

public class Game {
    private static int ROUNDS = 4;

    public void roundOfGame(List<Player> players) {
        for (int i = 0; i < ROUNDS; i++) {
            System.out.println("Rozpoczęła się runda " + (i + 1));
            for (Player player : players) {
                System.out.println("Tura gracza " + player.toString());
            }
        }
    }
}
