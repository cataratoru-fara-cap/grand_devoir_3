package com.github.cataratoru_fara_cap;
public enum Rarity {
    COMMON,
    UNCOMMON,
    RARE,
    EPIC;

    public double getMultiplier() {
        switch (this) {
            case COMMON:
                return 1.0;
            case RARE:
                return 2.0;
            case EPIC:
                return 5.0;
            default:
                return 1.0;
                //Unimplemented rarity
                //Implemented in order to future-proof the code
        }
    }
}
