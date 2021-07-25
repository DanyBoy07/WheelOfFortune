package pl.danyboy;

public class PlayerNameRegister {
    private LineReader lineReader;

    public PlayerNameRegister(LineReader lineReader) {
        this.lineReader = lineReader;
    }

    public String getNameFromUser() {
        System.out.println("Proszę podaj imię gracza");
        return lineReader.readLineFromUser();
    }

}
