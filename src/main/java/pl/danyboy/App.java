package pl.danyboy;

public class App {

    public static void main(String[] args) {
        System.out.println("Witaj w Kole Fortuny");
       PlayerFactory playerFactory = new PlayerFactory();
        try{
            System.out.println(playerFactory.createPlayers());
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

    }
}
