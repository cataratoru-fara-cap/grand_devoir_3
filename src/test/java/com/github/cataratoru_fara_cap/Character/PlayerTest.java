package com.github.cataratoru_fara_cap.Character;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.github.cataratoru_fara_cap.Gatherable.*;
import com.github.cataratoru_fara_cap.Item.*;
import com.github.cataratoru_fara_cap.Building;
import com.github.cataratoru_fara_cap.Effect;
import com.github.cataratoru_fara_cap.Rarity;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PlayerTest {
    private Player player;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    public void setUp() {
        player = new Player("TestPlayer", 10, 10, 100, 0.0, 0.0, 0.0);
    }

    @Nested
    @DisplayName("Resource Gathering Tests")
    class ResourceGatheringTests {
        @Test
        public void testGatherWood() {
            Tree tree = new Tree(10, Rarity.COMMON);
            player.gatherResource(tree);
            assertEquals(10.0, player.resources.get("wood"));
        }

        @Test
        public void testGatherRock() {
            Rock rock = new Rock(5, Rarity.RARE);
            player.gatherResource(rock);
            assertEquals(10.0, player.resources.get("rock")); // Assuming Rarity.RARE has a multiplier of 2.0
        }

        @Test
        public void testGatherGrain() {
            Grain grain = new Grain(20, Rarity.EPIC);
            player.gatherResource(grain);
            assertEquals(100.0, player.resources.get("grain")); // Assuming Rarity.UNCOMMON has a multiplier of 1.5
        }
    }

    @Nested
    @DisplayName("Combat Tests")
    class CombatTests {
        @Test
        public void testTakeDamage() {
            Enemy enemy = new Enemy("TestEnemy", 5, 5, 50);
            player.takeDamage(enemy);
            assertEquals(99.5, player.health);
        }

        @Test
        public void testAttackEnemy() {
            Enemy enemy = new Enemy("TestEnemy", 5, 5, 50);
            player.damage(enemy);
            assertEquals(48, enemy.health);
        }

        @Test
        public void testDie() {
            Enemy enemy = new Enemy("TestEnemy", 1000, 5, 50);
            player.attack = 1000;
            player.damage(enemy);
            player.takeDamage(enemy);
            assertFalse(player.isAlive);
        }
    }

    @Nested
    @DisplayName("Item Consumption Tests")
    class ItemConsumptionTests {
        @Test
        public void testEatFood() {
            Item food = new Food("Apple", Rarity.COMMON);
            player.Items.put("Apple", food);
            player.eatItem("Apple");
            assertFalse(player.Items.containsKey("Apple"));
            // Assuming the food item increases health
            assertEquals(130, player.health);
        }

        @Test
        public void testEatSword() {
            Item sword = new Sword("Sword", Rarity.COMMON);
            player.Items.put("Sword", sword);
            player.eatItem("Sword");
            assertFalse(player.Items.containsKey("Sword"));
            // Assuming the sword item increases attack
            assertEquals(40, player.attack);
        }

        @Test
        public void testEatShield() {
            Item shield = new Shield("Shield", Rarity.COMMON);
            player.Items.put("Shield", shield);
            player.eatItem("Shield");
            assertFalse(player.Items.containsKey("Shield"));
            // Assuming the shield item increases defense
            assertEquals(40, player.defense);
        }
    }

    @Nested
    @DisplayName("Item Crafting Tests")
    class ItemCraftingTests {
        @BeforeEach
        public void setUpMakeItemTests() {
            outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));
        }

        @Test
        public void testMakeItemSword() {
            player.resources.put("wood", 10.0);
            player.resources.put("rock", 10.0);
            player.makeItem("sword", Rarity.COMMON);
            assertTrue(player.Items.containsKey("Crafted Sword"));
            assertEquals(5.0, player.resources.get("wood"));
            assertEquals(7.0, player.resources.get("rock"));

            // Not enough resources
            player.resources.put("wood", 2.0);
            player.resources.put("rock", 1.0);
            player.makeItem("sword", Rarity.COMMON);
            assertFalse(player.Items.containsKey("Crafted Sword 2"));
            assertTrue(outContent.toString().contains("Not enough resources to craft a sword."));
        }

        @Test
        public void testMakeItemShield() {
            player.resources.put("wood", 10.0);
            player.resources.put("rock", 10.0);
            player.makeItem("shield", Rarity.COMMON);
            assertTrue(player.Items.containsKey("Crafted Shield"));
            assertEquals(3.0, player.resources.get("wood"));
            assertEquals(8.0, player.resources.get("rock"));

            // Not enough resources
            player.resources.put("wood", 5.0);
            player.resources.put("rock", 1.0);
            player.makeItem("shield", Rarity.COMMON);
            assertFalse(player.Items.containsKey("Crafted Shield 2"));
            assertTrue(outContent.toString().contains("Not enough resources to craft a shield."));
        }

        @Test
        public void testMakeItemFood() {
            player.resources.put("grain", 20.0);
            player.makeItem("food", Rarity.COMMON);
            assertTrue(player.Items.containsKey("Crafted Food"));
            assertEquals(10.0, player.resources.get("grain"));

            // Not enough resources
            player.resources.put("grain", 5.0);
            player.makeItem("food", Rarity.COMMON);
            assertFalse(player.Items.containsKey("Crafted Food 2"));
            assertTrue(outContent.toString().contains("Not enough resources to craft food."));
        }
    }

    @Nested
    @DisplayName("Building Construction Tests")
    class BuildingConstructionTests {
        @Test
        public void testMakeLifeFountain() {
            player.resources.put("wood", 50.0);
            player.resources.put("stone", 30.0);
            Building lifeFountain = player.makeLifeFountain();
            assertNotNull(lifeFountain);
            assertEquals("lifeFountain", lifeFountain.name);
            assertEquals(Effect.HEALTH, lifeFountain.effect);
            assertEquals(0.0, player.resources.get("wood"));
            assertEquals(0.0, player.resources.get("stone"));

            // Not enough resources
            player.resources.put("wood", 20.0);
            player.resources.put("stone", 10.0);
            lifeFountain = player.makeLifeFountain();
            assertNull(lifeFountain);
        }

        @Test
        public void testMakeArmory() {
            player.resources.put("wood", 70.0);
            player.resources.put("stone", 50.0);
            Building armory = player.makeArmory();
            assertNotNull(armory);
            assertEquals("armory", armory.name);
            assertEquals(Effect.DEFENSE, armory.effect);
            assertEquals(0.0, player.resources.get("wood"));
            assertEquals(0.0, player.resources.get("stone"));

            // Not enough resources
            player.resources.put("wood", 30.0);
            player.resources.put("stone", 20.0);
            armory = player.makeArmory();
            assertNull(armory);
        }

        @Test
        public void testMakeWeaponsHold() {
            player.resources.put("wood", 100.0);
            player.resources.put("stone", 80.0);
            Building weaponsHold = player.makeWeaponsHold();
            assertNotNull(weaponsHold);
            assertEquals("weaponsHold", weaponsHold.name);
            assertEquals(Effect.ATTACK, weaponsHold.effect);
            assertEquals(0.0, player.resources.get("wood"));
            assertEquals(0.0, player.resources.get("stone"));

            // Not enough resources
            player.resources.put("wood", 50.0);
            player.resources.put("stone", 30.0);
            weaponsHold = player.makeWeaponsHold();
            assertNull(weaponsHold);
        }
    }

    @Test
    public void testToString() {
        String expected = "Player: TestPlayer Health: 100.0 Attack: 10.0 Defense: 10.0 Resources: {rock=0.0, wood=0.0, grain=0.0}";
        assertEquals(expected, player.toString());
    }
}
