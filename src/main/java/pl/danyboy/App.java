package pl.danyboy;

public class App {
    public static void main(String[] args) {
        System.out.println("Witaj w Kole Fortuny");
        try {
            Player player = new Player("Jan");
            System.out.println(player);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
