package pl.danyboy;

public class Player {

    private final String name;

    public Player(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return "[<" + name + ">]";
    }

    public String getName() {
        return name;
    }
}
