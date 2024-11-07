package com.github.cataratoru_fara_cap.Item;

import com.github.cataratoru_fara_cap.Effect;
import com.github.cataratoru_fara_cap.Rarity;

public abstract class Item {
    private String name;
    private Effect effect = Effect.NONE;
    private Rarity rarity = Rarity.COMMON;

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, Effect effect) {
        this.name = name;
        this.effect = effect;
    }

    public Item(String name, Effect effect, Rarity rarity) {
        this.name = name;
        this.effect = effect;
        this.rarity = rarity;
    }

    public String getName() {
        return name;
    }

    public Effect getEffect() {
        return effect;
    }
    
    public Rarity geRarity() {
        return rarity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEffect(Effect effect) {
        this.effect = effect;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }
}
