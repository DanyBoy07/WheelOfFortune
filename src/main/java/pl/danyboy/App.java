package pl.danyboy;

public class App {

    public static void main(String[] args) {
        LineReader lineReader = new LineReader();
        System.out.println("Witaj w Kole Fortuny");
        PlayerFactory playerFactory = new PlayerFactory(lineReader);
        PasswordManager passwordManager = new PasswordManager();
        Game game = new Game(passwordManager);
        try {
            game.roundsOfGame(playerFactory.createPlayers());
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

    }
}
