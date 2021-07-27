package pl.danyboy;

public class App {

    public static void main(String[] args) {
        LineReader lineReader = new LineReader();
        System.out.println("Witaj w Kole Fortuny");
       PlayerFactory playerFactory = new PlayerFactory(lineReader);
       Game game = new Game();
        try{
            game.roundOfGame(playerFactory.createPlayers());
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

    }
}
