package com.github.cataratoru_fara_cap.Gatherable;

import com.github.cataratoru_fara_cap.Rarity;
import com.github.cataratoru_fara_cap.Character.Player;

public abstract class Gatherable{
    private float quantity;
    private Rarity rarity;

    public Gatherable(int quantity, Rarity rarity) {
        this.quantity = quantity;
        this.rarity = rarity;
    }

    public double getQuantity() {
        return quantity;
    }
    public Rarity getRarity() {
        return rarity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    abstract public String toString();

    abstract public void gather(Player player);
}
