package com.github.cataratoru_fara_cap.Item;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.github.cataratoru_fara_cap.Effect;
import com.github.cataratoru_fara_cap.Rarity;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Item Tests")
public class ItemTest {
    @Nested
    @DisplayName("Item Methods Tests")
    class ItemMethodsTests {
        @Test
        @DisplayName("Test Getters")
        public void testGetters() {
            Effect effect = Effect.HEALTH;
            Rarity rarity = Rarity.COMMON;
            Item item = new Food("Jucy Burger", rarity);
            assertEquals("Jucy Burger", item.getName());
            assertEquals(effect, item.getEffect());
            assertEquals(rarity, item.getRarity());
        }

        @Test
        @DisplayName("Test Setters")
        public void testSetters() {
            Rarity rarity = Rarity.COMMON;
            Item item = new Sword("Healing Sword", rarity);
            Effect newEffect = Effect.ATTACK;
            Rarity newRarity = Rarity.RARE;
            item.setName("Mana Sword");
            item.setEffect(newEffect);
            item.setRarity(newRarity);
            assertEquals("Mana Sword", item.getName());
            assertEquals(newEffect, item.getEffect());
            assertEquals(newRarity, item.getRarity());
        }

        @Test
        @DisplayName("Test compareItems")
        public void testCompareItems() {
            Item item1 = new Sword("COMMON SWORD", Rarity.COMMON);
            Item item2 = new Sword("COMMON SWORD", Rarity.COMMON);
            Item item3 = new Sword("RARE SWORD",Rarity.RARE);
            Item item4 = new Shield("Average SHIELD", Rarity.RARE);
            Item item5 = new Shield("Strong SHIELD", Rarity.RARE);

            //Identical comparator
            assertEquals(0, Item.compareItems(item1, item2));
            //Rarity comparator
            assertTrue(Item.compareItems(item2, item3) < 0);
            //Effect comparator
            assertTrue(Item.compareItems(item3, item4) < 0);
            //Name comparator
            assertTrue(Item.compareItems(item4, item5) < 0);
        }

        @Test
        @DisplayName("Test toString")
        public void testToString() {
            Item item = new Sword("Epic Sword", Rarity.EPIC);
            String expectedString = "Item [name=Epic Sword, effect=ATTACK, rarity=EPIC]";
            assertEquals(expectedString, item.toString());
        }
    }
}
