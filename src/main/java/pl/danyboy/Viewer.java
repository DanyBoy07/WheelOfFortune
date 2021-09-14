package pl.danyboy;

public class Viewer {

    public void letterAnnouncement(boolean option) {
        System.out.println("Zgaduję literę");
        if (option) {
            System.out.println("Zgadnięta");
        } else {
            System.out.println("Taka litera nie występuje w haśle");
        }

    }

    public void passwordAnnouncement(boolean option) {
        if (option) {
            System.out.println("Hasło odgadnięte");
        } else {
            System.out.println("Niepoprawne hasło");
        }
    }
}
