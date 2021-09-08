package pl.danyboy;

public class App {

    public static void main(String[] args) {

        LineReader lineReader = new LineReader();
        System.out.println("Witaj w Kole Fortuny");
        PlayersRepository playersRepository = new PlayersRepository();
        PlayerFactory playerFactory = new PlayerFactory(lineReader, playersRepository);
        PasswordManager passwordManager = new PasswordManager();

        Validation guessStage = new Validation();
        Viewer viewer = new Viewer();

        Game game = new Game(passwordManager, lineReader, guessStage, viewer);
        try {
            game.roundsOfGame(playerFactory.createPlayers());
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println(e);
        }

    }


}
