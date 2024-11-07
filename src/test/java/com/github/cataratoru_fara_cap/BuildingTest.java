package com.github.cataratoru_fara_cap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.cataratoru_fara_cap.Character.Player;
import com.github.cataratoru_fara_cap.Building.Effect;

public class BuildingTest {
    private Player player;
    private Building attackBuilding;
    private Building defenseBuilding;
    private Building healthBuilding;

    @BeforeEach
    public void setUp() {
        player = new Player("TestPlayer", 100, 50, 200, 0, 0, 0);
        attackBuilding = new Building("Attack Building", Effect.ATTACK);
        defenseBuilding = new Building("Defense Building", Effect.DEFENSE);
        healthBuilding = new Building("Health Building", Effect.HEALTH);
    }

    @Test
    public void testApplyAttackEffect() {
        attackBuilding.applyEffect(player);
        assertEquals(110, player.attack, 0.01);
    }

    @Test
    public void testApplyDefenseEffect() {
        defenseBuilding.applyEffect(player);
        assertEquals(55, player.defense, 0.01);
    }

    @Test
    public void testApplyHealthEffect() {
        healthBuilding.applyEffect(player);
        assertEquals(220, player.health, 0.01);
    }
}
