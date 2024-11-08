package com.github.cataratoru_fara_cap.Gatherable;

import com.github.cataratoru_fara_cap.Rarity;
public class Tree extends Gatherable {
    public Tree() {
        super(Gatherable.initQuantity(), Rarity.getRandom());
        this.name = "wood";
    }

    public Tree(int quantity, Rarity rarity) {
        super(quantity, rarity);
        this.name = "wood";
    }

    public double gather() {
        double gathered = getQuantity() * getRarity().getMultiplier();
        System.out.println("Got Wood! Amount: " + gathered);
        return gathered;
    }

    public String toString() {
        return "Wood: " + getQuantity() + " Rarity: " + getRarity();
    }
    
}
