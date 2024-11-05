import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Potion Tests")
public class PotionTest {
    @Nested
    @DisplayName("Potion Methods Tests")
    class PotionMethodsTests {
        @Test
        @DisplayName("Test Getters")
        public void testGetters() {
            Potion potion = new Potion("Healing", "Health");
            assertEquals("Healing", potion.getName());
            assertEquals("Health", potion.getAttribute());
        }

        @Test
        @DisplayName("Test Setters")
        public void testSetters() {
            Potion potion = new Potion("Healing", "Health");
            potion.setName("Mana");
            potion.setAttribute("Magic");
            assertEquals("Mana", potion.getName());
            assertEquals("Magic", potion.getAttribute());
        }
    }
}
