package com.github.cataratoru_fara_cap;

public class Rock extends Gatherable{
    public Rock(int quantity, Rarity rarity) {
        super(quantity, rarity);
    }

    public double getStone() {
        return getQuantity() * getRarity().getMultiplier();
    }
    
    public void gather(Player player) {
        player.resources.add(this);
    }

    public String toString() {
        return "Stone: " + getQuantity() + " Rarity: " + getRarity();
    }
    

}
