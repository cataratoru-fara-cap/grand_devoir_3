package com.github.cataratoru_fara_cap.Gatherable;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.github.cataratoru_fara_cap.Rarity;

public class GatherableTest {

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
}
