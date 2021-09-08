package pl.danyboy;

import java.util.List;

public class Game {
    private final PasswordManager passwordManager;
    private final LineReader lineReader;
    private final Validation validation;
    private final Viewer viewer;

    public Game(PasswordManager passwordManager, LineReader lineReader, Validation validation, Viewer viewer) {
        this.passwordManager = passwordManager;
        this.lineReader = lineReader;
        this.validation = validation;
        this.viewer = viewer;
    }

    public void roundsOfGame(List<Player> players) throws IllegalStateException {
        int rounds = 4;
        for (int i = 0; i < rounds; i++) {
            System.out.println("Rozpoczęła się runda " + (i + 1));
            passwordManager.getRandomPassword();
            boolean isRoundContinue = true;
            while (isRoundContinue) {
                for (Player player : players) {
                    if (singleRound(player)) {
                        isRoundContinue = false;
                    }
                }
            }

        }
    }

    private boolean singleRound(Player player) {
        boolean answerFlag = true;
        while (answerFlag) {
            System.out.println(passwordManager.getObscuredPassword());
            System.out.println("Tura gracza " + player.toString());
            System.out.println("Wpisz hasło lub pojedyńczą literę: ");
            String input = lineReader.readLineFromUser();
            if (validation.isALetter(input)) {
                answerFlag = passwordManager.guessLetter(input) > 0;
                viewer.letterAnnouncement(answerFlag);
                if (passwordManager.checkPassword()) {
                    viewer.passwordAnnouncement(passwordManager.checkPassword());
                    return true;
                }
            } else {
                viewer.passwordAnnouncement(passwordManager.checkPassword());
                answerFlag = passwordManager.checkPassword();
            }

        }
        return false;
    }
}
