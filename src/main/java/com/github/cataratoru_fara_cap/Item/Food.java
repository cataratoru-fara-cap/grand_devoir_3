package com.github.cataratoru_fara_cap.Item;

import com.github.cataratoru_fara_cap.Rarity;
import com.github.cataratoru_fara_cap.Effect;
import com.github.cataratoru_fara_cap.Character.Character;


public class Food extends Item {
    public Food(String name, Effect effect, Rarity rarity) {
        super(name, effect, rarity);
    }

    @Override
    public void use(Character character) {
        double value = 30 * rarity.getMultiplier();
        character.health += value;
        System.out.println("You ate " + this.getName());
    }
}
