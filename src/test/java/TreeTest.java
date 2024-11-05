import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.github.cataratoru_fara_cap.Rarity;
import com.github.cataratoru_fara_cap.Tree;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tree Tests")
public class TreeTest {
    @Nested
    @DisplayName("Get Wood Method Tests")
    class GetWoodTests {
        @Test
        @DisplayName("Common Tree")
        public void testCommonTree() {
            Tree commonTree = new Tree(10, Rarity.COMMON);
            assertEquals(10.0, commonTree.getWood());
        }

        @Test
        @DisplayName("Rare Tree")
        public void testRareTree() {
            Tree rareTree = new Tree(10, Rarity.RARE);
            assertEquals(20.0, rareTree.getWood());
        }

        @Test
        @DisplayName("Epic Tree")
        public void testEpicTree() {
            Tree epicTree = new Tree(10, Rarity.EPIC);
            assertEquals(50.0, epicTree.getWood());
        }
    }
}
