package com.github.cataratoru_fara_cap.Gatherable;

import com.github.cataratoru_fara_cap.Rarity;
public abstract class Gatherable {
    protected String name;
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
    
    public String getName() {
        return name;
    }

    abstract public String toString();

    abstract public double gather();
}
