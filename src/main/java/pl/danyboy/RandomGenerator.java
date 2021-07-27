package pl.danyboy;

import java.util.Random;

public class RandomGenerator {
    public int numberGenerator(int number) {
        Random random = new Random();
        return random.nextInt(number);
    }
}
