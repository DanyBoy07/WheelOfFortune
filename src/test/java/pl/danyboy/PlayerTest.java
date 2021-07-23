package pl.danyboy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PlayerTest {

    @Test
    public void shouldCreatePlayerWhenNameIsCorrect() {
        String name = "Arek";
        Player player = new Player(name);

        assertEquals(name, player.getName());
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenNameIsNullOrEmpty() {
        String name = "";
        String nameB = null;
        assertThrows(IllegalArgumentException.class, () -> new Player(name));
        assertThrows(IllegalArgumentException.class, () -> new Player(nameB));
    }

    @Test
    public void testToStringMethod() {
        String name = "Jan";
        String result = "[<" + name + ">]";
        Player player = new Player(name);
        assertEquals(player.toString(), result);
    }

}