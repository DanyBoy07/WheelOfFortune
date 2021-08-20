package pl.danyboy;

public class GuessStage {

    private final PasswordManager passwordManager;

    public GuessStage(PasswordManager passwordManager) {
        this.passwordManager = passwordManager;
    }

    public void passwordGuessesInformation(String password, String inputFromUser) {

        String charOrPasswordFromUser = transformToLower(inputFromUser);
        if (charOrPasswordFromUser.length() <= 1) {
            System.out.println("Zgaduję literę");
            System.out.println(transformToLower(password).contains(charOrPasswordFromUser) ? "Zgadnięta" : "Taka litera nie występuje w haśle");
            passwordManager.guessLetter(charOrPasswordFromUser, password);

        } else {
            System.out.println("Zgaduję hasło");
            System.out.println((passwordManager.guessPassword(password, charOrPasswordFromUser) ? "Hasło odgadnięte" : "Niepoprawne hasło"));
        }
    }

    private String transformToLower(String value) {
        return value.toLowerCase();
    }

}
