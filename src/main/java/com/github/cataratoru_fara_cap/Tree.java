package com.github.cataratoru_fara_cap;
public class Tree extends Gatherable{
    public Tree(int quantity, Rarity rarity) {
        super(quantity, rarity);
    }

    public double getWood() {
        return getQuantity() * getRarity().getMultiplier();
    }
    
    public void gather(Player player) {
        player.resources.add(this);
    }

    public String toString() {
        return "Wood: " + getQuantity() + " Rarity: " + getRarity();
    }
    
}
