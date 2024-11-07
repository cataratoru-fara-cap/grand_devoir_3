package com.github.cataratoru_fara_cap.Item;

import com.github.cataratoru_fara_cap.Rarity;
import com.github.cataratoru_fara_cap.Effect;
import com.github.cataratoru_fara_cap.Character.Character;

public class Sword extends Item {
    public Sword(String name, Effect effect, Rarity rarity) {
        super(name, effect, rarity);
    }

    @Override
    public void use(Character character) {
        double value = 30 * rarity.getMultiplier();
        character.attack += value;
        System.out.println("You ate another sword and are now stronger by " + value);
    }
}
