package pl.danyboy;

import java.util.List;

public class PlayerFactory {
    private final LineReader reader;
    private final PlayersRepository playersRepository;

    public PlayerFactory(LineReader reader, PlayersRepository playersRepository) {
        this.reader = reader;
        this.playersRepository = playersRepository;
    }

    public List<Player> createPlayers() throws IllegalArgumentException {
        int numbersOfPlayers = setQuantityOfPlayers();

        for (int i = 0; i < numbersOfPlayers; i++) {
            playersRepository.addPlayer(setNameOfPlayerFromUser());
        }
        return playersRepository.getPlayers();
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
