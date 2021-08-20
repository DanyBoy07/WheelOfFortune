package pl.danyboy;

public class App {

    public static void main(String[] args) {

        LineReader lineReader = new LineReader();
        System.out.println("Witaj w Kole Fortuny");
        PlayerFactory playerFactory = new PlayerFactory(lineReader);
        PasswordManager passwordManager = new PasswordManager();
        PasswordStage passwordStage = new PasswordStage();
        GuessStage guessStage = new GuessStage();
        Viewer viewer = new Viewer();

        Game game = new Game(passwordManager, lineReader, passwordStage, guessStage, viewer);
        try {
            game.roundsOfGame(playerFactory.createPlayers());
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println(e);
        }

    }

}
