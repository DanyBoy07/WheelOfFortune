package pl.danyboy;

import java.util.List;

public class Game {
    private final PasswordManager passwordManager;
    private final LineReader lineReader;
    private final PasswordStage passwordStage;
    private final GuessStage guessStage;
    private final Viewer viewer;

    public Game(PasswordManager passwordManager, LineReader lineReader, PasswordStage passwordStage, GuessStage guessStage, Viewer viewer) {
        this.passwordManager = passwordManager;

        this.lineReader = lineReader;
        this.passwordStage = passwordStage;
        this.guessStage = guessStage;
        this.viewer = viewer;
    }

    public void roundsOfGame(List<Player> players) throws IllegalStateException {
        int rounds = 4;
        for (int i = 0; i < rounds; i++) {
            System.out.println("Rozpoczęła się runda " + (i + 1));
            String randomPassword = passwordManager.getRandomPassword();
            System.out.println(passwordStage.getObscuredPassword(randomPassword));
            System.out.println(randomPassword);
            for (Player player : players) {
                if (SingleRound(randomPassword, player)) {
                    break;
                }
            }
            passwordStage.resetListOfChars();
        }
    }

    private boolean SingleRound(String randomPassword, Player player) {
        boolean answerFlag = true;
        while (answerFlag) {
            System.out.println("Tura gracza " + player.toString());
            System.out.println("Wpisz hasło lub pojedyńczą literę: ");
            String input = lineReader.readLineFromUser();
            if (guessStage.isALetter(input)) {
                viewer.letterAnnouncement(guessStage.checkLettersInPassword(randomPassword, input));
                System.out.println(passwordStage.getObscuredPassword(randomPassword, input));
                return guessStage.checkPassword(randomPassword, passwordStage.getObscuredPassword(randomPassword, input));

            } else {
                viewer.passwordAnnouncement(guessStage.checkPassword(randomPassword, input));
                return guessStage.checkPassword(randomPassword, input);

            }
        }
        return false;
    }
}
