package com.github.cataratoru_fara_cap.Gatherable;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.github.cataratoru_fara_cap.Rarity;

public class GatherableTest {
    @Test
    public void testGatherableSetters() {
        Tree tree = new Tree(10, Rarity.COMMON);
        tree.setQuantity(100);
        tree.setRarity(null);
        assertEquals(100, tree.getQuantity());
        assertNull(tree.getRarity());
    }
    
    @Test
    public void testGatherableInit() {
        Tree tree = new Tree(10, null);
        assertEquals(Rarity.COMMON, tree.getRarity());
        assertEquals("wood", tree.getName());
    }
    @Test
    public void testTreeGather() {
        Tree tree = new Tree(10, Rarity.COMMON);
        assertEquals(10.0, tree.gather());
    }

    @Test
    public void testRockGather() {
        Rock rock = new Rock(5, Rarity.RARE);
        assertEquals(10.0, rock.gather()); // Assuming Rarity.RARE has a multiplier of 2.0
    }

    @Test
    public void testGrainGather() {
        Grain grain = new Grain(20, Rarity.EPIC);
        assertEquals(100.0, grain.gather()); // Assuming Rarity.UNCOMMON has a multiplier of 1.5
    }

    @Test
    public void testToString() {
        Tree tree = new Tree(10, Rarity.COMMON);
        assertEquals("Wood: 10.0 Rarity: COMMON", tree.toString());

        Rock rock = new Rock(5, Rarity.RARE);
        assertEquals("Stone: 5.0 Rarity: RARE", rock.toString());

        Grain grain = new Grain(20, Rarity.EPIC);
        assertEquals("Grain: 20.0 Rarity: EPIC", grain.toString());
    }

    @Test
    public void testTreeRandomInit() {
        Tree tree = new Tree();
        assertNotNull(tree.getRarity(), "Rarity should not be null");
        assertTrue(tree.getQuantity() >= 0 && tree.getQuantity() <= 10, "Quantity should be between 0 and 10");
    }

    @Test
    public void testRockRandomInit() {
        Rock rock = new Rock();
        assertNotNull(rock.getRarity(), "Rarity should not be null");
        assertTrue(rock.getQuantity() >= 0 && rock.getQuantity() <= 10, "Quantity should be between 0 and 10");
    }

    @Test
    public void testGrainRandomInit() {
        Grain grain = new Grain();
        assertNotNull(grain.getRarity(), "Rarity should not be null");
        assertTrue(grain.getQuantity() >= 0 && grain.getQuantity() <= 10, "Quantity should be between 0 and 10");
    }
}
