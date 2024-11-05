import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.github.cataratoru_fara_cap.Gatherable;
import com.github.cataratoru_fara_cap.Rarity;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Gatherable Tests")
public class GatherableTest {
    @Nested
    @DisplayName("Gatherable Methods Tests")
    class GatherableMethodsTests {
        @Test
        @DisplayName("Test Getters")
        public void testGetters() {
            Gatherable gatherable = new Gatherable(10, Rarity.COMMON) {};
            assertEquals(10, gatherable.getQuantity());
            assertEquals(Rarity.COMMON, gatherable.getRarity());
        }

        @Test
        @DisplayName("Test Setters")
        public void testSetters() {
            Gatherable gatherable = new Gatherable(10, Rarity.COMMON) {};
            gatherable.setQuantity(20);
            gatherable.setRarity(Rarity.RARE);
            assertEquals(20, gatherable.getQuantity());
            assertEquals(Rarity.RARE, gatherable.getRarity());
        }
    }
}
