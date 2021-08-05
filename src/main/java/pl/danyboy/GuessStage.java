package pl.danyboy;

public class GuessStage {

    private final LineReader lineReader;

    public GuessStage(LineReader lineReader) {
        this.lineReader = lineReader;
    }

    public void passwordGuessesInformation(String password) {
        String charOrPasswordFromUser = transformToLower(lineReader.readLineFromUser());
        if (charOrPasswordFromUser.length() <= 1) {
            System.out.println("Zgaduję literę");
            System.out.println(transformToLower(password).contains(charOrPasswordFromUser) ? "Zgadnięta" : "Taka litera nie występuje w haśle");

        } else {
            System.out.println("Zgaduję hasło");
            System.out.println(transformToLower(password).contains(charOrPasswordFromUser) ? "Hasło odgadnięte" : "Niepoprawne hasło");
        }
    }

    private String transformToLower(String value) {
        return value.toLowerCase();
    }

}
