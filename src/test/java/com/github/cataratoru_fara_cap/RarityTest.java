package com.github.cataratoru_fara_cap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Rarity Tests")
public class RarityTest {
    @Nested
    @DisplayName("Get Multiplier Method Tests")
    class GetMultiplierTests {
        @Test
        @DisplayName("Common Rarity")
        public void testCommonRarity() {
            assertEquals(1.0, Rarity.COMMON.getMultiplier());
        }

        @Test
        @DisplayName("Rare Rarity")
        public void testRareRarity() {
            assertEquals(2.0, Rarity.RARE.getMultiplier());
        }

        @Test
        @DisplayName("Epic Rarity")
        public void testEpicRarity() {
            assertEquals(5.0, Rarity.EPIC.getMultiplier());
        }
        @Test
        @DisplayName("Epic Rarity")
        public void testUnimplementedRarity() {
            assertEquals(1, Rarity.NONE.getMultiplier());
        }
    }
}
