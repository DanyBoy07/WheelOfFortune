package pl.danyboy;

import java.util.List;

public class PlayerFactory {
    private LineReader reader = new LineReader();

    public List<Player> createPlayers() throws IllegalArgumentException {
        PlayerQuantityRegister playerQuantityRegister = new PlayerQuantityRegister(reader);
        int numbersOfPlayers = playerQuantityRegister.setQuantityOfPlayers();

        PlayerNameRegister playerNameRegister = new PlayerNameRegister(reader);
        ListOfPlayers listOfPlayers = new ListOfPlayers();
        for (int i = 0; i < numbersOfPlayers; i++) {
            listOfPlayers.addPlayer(playerNameRegister.getNameFromUser());
        }
        return listOfPlayers.getPlayers();

    }

}
