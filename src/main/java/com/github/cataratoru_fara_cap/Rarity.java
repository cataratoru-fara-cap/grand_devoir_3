package com.github.cataratoru_fara_cap;

public enum Rarity {
    NONE,
    COMMON,
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
            //Unimplemented rarity is treated as common
            //Implemented in order to future-proof the code
        }
    }

    public static Rarity getRandom() {
        double randomValue = Math.random();
        if (randomValue < 0.5) {
            return COMMON;
        } else if (randomValue < 0.85) {
            return RARE;
        } else {
            return EPIC;
        }
    }
}
