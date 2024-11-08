package com.github.cataratoru_fara_cap.Gatherable;

import com.github.cataratoru_fara_cap.Rarity;
public class Grain extends Gatherable {
    public Grain() {
        super(Gatherable.initQuantity(), Rarity.getRandom());
        this.name = "grain";
    }

    public Grain(int quantity, Rarity rarity) {
        super(quantity, rarity);
         this.name = "grain";
    }

    public double gather() {
        double gathered = getQuantity() * getRarity().getMultiplier();
        System.out.println("Got Grain! Amount: " + gathered);
        return gathered;
    }

    public String toString() {
        return "Grain: " + getQuantity() + " Rarity: " + getRarity();
    }
    
}
