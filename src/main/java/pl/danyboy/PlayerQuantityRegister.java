package pl.danyboy;

public class PlayerQuantityRegister {
    private LineReader lineReader;

    public PlayerQuantityRegister(LineReader lineReader) {
        this.lineReader = lineReader;
    }

    public int setQuantityOfPlayers() {
        int min = 2;
        int max = 4;

        System.out.println("Proszę podaj liczbę graczy?");
        int numberOfPlayers = Integer.parseInt(lineReader.readLineFromUser());

        if (numberOfPlayers < min || numberOfPlayers > max) {
            throw new IllegalArgumentException();
        }
        return numberOfPlayers;
    }
}
