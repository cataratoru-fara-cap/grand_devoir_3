package com.github.cataratoru_fara_cap.Character;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.cataratoru_fara_cap.Gatherable.Grain;
import com.github.cataratoru_fara_cap.Gatherable.Rock;
import com.github.cataratoru_fara_cap.Gatherable.Tree;
import com.github.cataratoru_fara_cap.Rarity;

public class PlayerTest {
    private Player player;

    @BeforeEach
    public void setUp() {
        player = new Player("TestPlayer", 10, 10, 100, 0.0, 0.0, 0.0);
    }

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

    @Test
    public void testToString() {
        String expected = "Player: TestPlayer Health: 100.0 Attack: 10.0 Defense: 10.0 Resources: {rock=0.0, wood=0.0, grain=0.0}";
        assertEquals(expected, player.toString());
    }

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
