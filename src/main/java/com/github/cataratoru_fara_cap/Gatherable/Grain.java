package com.github.cataratoru_fara_cap.Gatherable;

import com.github.cataratoru_fara_cap.Rarity;
import com.github.cataratoru_fara_cap.Character.Player;

public class Grain extends Gatherable{
    public Grain(int quantity, Rarity rarity) {
        super(quantity, rarity);
    }

    public double getGrain() {
        return getQuantity() * getRarity().getMultiplier();
    }
    
    public void gather(Player player) {
        player.resources.add(this);
    }

    public String toString() {
        return "Grain: " + getQuantity() + " Rarity: " + getRarity();
    }
    
}
