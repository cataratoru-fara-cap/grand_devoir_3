package com.github.cataratoru_fara_cap.Gatherable;

import com.github.cataratoru_fara_cap.Rarity;
public abstract class Gatherable {
    protected String name;
    private float quantity;
    private Rarity rarity = Rarity.COMMON;

    public Gatherable(int quantity, Rarity rarity) {
        this.quantity = quantity;
        if (rarity != null) {
            this.rarity = rarity;
        }
    }

    public double getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public Rarity getRarity() {
        return rarity;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }
    
    public String getName() {
        return name;
    }
    // we don t need a setter for Name

    abstract public String toString();

    abstract public double gather();
}
