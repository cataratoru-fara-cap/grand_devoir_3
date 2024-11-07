package com.github.cataratoru_fara_cap;

import com.github.cataratoru_fara_cap.Item;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Item Tests")
public class ItemTest {
    @Nested
    @DisplayName("Item Methods Tests")
    class ItemMethodsTests {
        @Test
        @DisplayName("Test Getters")
        public void testGetters() {
            Item item = new Item("Healing", "Health");
            assertEquals("Healing", item.getName());
            assertEquals("Health", item.getAttribute());
        }

        @Test
        @DisplayName("Test Setters")
        public void testSetters() {
            Item item = new Item("Healing", "Health");
            item.setName("Mana");
            item.setAttribute("Magic");
            assertEquals("Mana", item.getName());
            assertEquals("Magic", item.getAttribute());
        }
    }
}
