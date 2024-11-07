package com.github.cataratoru_fara_cap.Item;

import com.github.cataratoru_fara_cap.Effect;
import com.github.cataratoru_fara_cap.Rarity;
import com.github.cataratoru_fara_cap.Character.Character;

public abstract class Item {
    protected String name;
    protected Effect effect;
    protected Rarity rarity;

    public Item(String name, Effect effect, Rarity rarity) {
        this.name = name;
        this.effect = effect;
        this.rarity = rarity;
    }

    abstract public void use(Character character);
    
    public String getName() {
        return name;
    }

    public Effect getEffect() {
        return effect;
    }
    
    public Rarity getRarity() {
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

    public static int compareItems(Item item1, Item item2) {
        int rarityComparison = item1.rarity.compareTo(item2.rarity);
        if (rarityComparison != 0) {
            return rarityComparison;
        }

        int effectComparison = item1.effect.compareTo(item2.effect);
        if (effectComparison != 0) {
            return effectComparison;
        }

        return item1.name.compareTo(item2.name);
    }
}
