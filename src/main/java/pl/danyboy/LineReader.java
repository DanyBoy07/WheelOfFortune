package pl.danyboy;

import java.util.Scanner;

public class LineReader {
    private static final Scanner input = new Scanner(System.in);

    public String readLineFromUser() {
        return input.nextLine();
    }
}
