package com.github.cataratoru_fara_cap.Character;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EnemyTest {
    private Enemy enemy;
    private Player player;

    @BeforeEach
    public void setUp() {
        enemy = new Enemy("TestEnemy", 10, 10, 100);
        player = new Player("TestPlayer", 10, 10, 100, 0.0, 0.0, 0.0);
    }

    @Test
    public void testDamage() {
        enemy.damage(player);
        assertEquals(99, player.health);
    }

    @Test
    public void testTakeDamage() {
        enemy.takeDamage(player);
        assertEquals(99, enemy.health);
    }

    @Test
    public void testDie() {
        player.attack = 1000;
        enemy.attack = 1000;
        enemy.takeDamage(player);
        enemy.damage(player);
        assertFalse(enemy.isAlive);
    }

    @Test
    public void testToString() {
        String expected = "Enemy: TestEnemy Health: 100.0 Attack: 10.0 Defense: 10.0";
        assertEquals(expected, enemy.toString());
    }
}
