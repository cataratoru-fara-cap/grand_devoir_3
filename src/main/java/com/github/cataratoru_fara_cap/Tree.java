package com.github.cataratoru_fara_cap;
public class Tree extends Gatherable{
    public Tree(int quantity, Rarity rarity) {
        super(quantity, rarity);
    }
    public double getWood() {
        return getQuantity() * getRarity().getMultiplier();
    }
}
