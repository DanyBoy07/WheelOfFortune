package pl.danyboy;

import java.util.List;

public class PlayerFactory {
    private final LineReader reader;

    public PlayerFactory(LineReader reader) {
        this.reader = reader;
    }

    public List<Player> createPlayers() throws IllegalArgumentException {

        int numbersOfPlayers = setQuantityOfPlayers();

        ListOfPlayers listOfPlayers = new ListOfPlayers();
        for (int i = 0; i < numbersOfPlayers; i++) {
            listOfPlayers.addPlayer(setNameOfPlayerFromUser());
        }
        return listOfPlayers.getPlayers();
    }

    private String setNameOfPlayerFromUser() {
        System.out.println("Proszę podaj imię gracza:");
        return reader.readLineFromUser();
    }

    private int setQuantityOfPlayers() {
        int min = 2;
        int max = 4;

        System.out.println("Proszę podaj liczbę graczy?");
        int numberOfPlayers = Integer.parseInt(reader.readLineFromUser());

        if (numberOfPlayers < min || numberOfPlayers > max) {
            throw new IllegalArgumentException();
        }
        return numberOfPlayers;
    }

}
