package pl.danyboy;

import java.util.ArrayList;
import java.util.List;

public class ListOfPlayers {
    private List<Player> players = new ArrayList<>();

    public void addPlayer(String name) throws IllegalArgumentException {
        players.add(new Player(name));
    }

    public List<Player> getPlayers() {
        return players;
    }
}
