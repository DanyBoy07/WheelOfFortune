package pl.danyboy;

public class GuessStage {

    private final LineReader lineReader;
    private final PasswordManager passwordManager;

    public GuessStage(LineReader lineReader, PasswordManager passwordManager) {
        this.lineReader = lineReader;
        this.passwordManager = passwordManager;
    }

    public void passwordGuessesInformation(String password) {
        String charOrPasswordFromUser = transformToLower(lineReader.readLineFromUser());
        if (charOrPasswordFromUser.length() <= 1) {
            System.out.println("Zgaduję literę");
            System.out.println(transformToLower(password).contains(charOrPasswordFromUser) ? "Zgadnięta" : "Taka litera nie występuje w haśle");
            int index = 0;
            passwordManager.guessLetter(charOrPasswordFromUser.charAt(index), password);
        } else {
            System.out.println("Zgaduję hasło");
            System.out.println(transformToLower(password).contains(charOrPasswordFromUser) ? "Hasło odgadnięte" : "Niepoprawne hasło");
            passwordManager.guessPassword(password, charOrPasswordFromUser);
        }
    }

    private String transformToLower(String value) {
        return value.toLowerCase();
    }

}
