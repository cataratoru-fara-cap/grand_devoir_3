package com.github.cataratoru_fara_cap.Gatherable;

import com.github.cataratoru_fara_cap.Rarity;
public class Rock extends Gatherable {
    public Rock() {
        super(Gatherable.initQuantity(), Rarity.getRandom());
        this.name = "rock";
    }
    
    public Rock(int quantity, Rarity rarity) {
        super(quantity, rarity);
         this.name = "rock";
    }

    public double gather() {
        double gathered = getQuantity() * getRarity().getMultiplier();
        System.out.println("Got Rock! Amount: " + gathered);
        return gathered;
    }

    public String toString() {
        return "Stone: " + getQuantity() + " Rarity: " + getRarity();
    }

}
