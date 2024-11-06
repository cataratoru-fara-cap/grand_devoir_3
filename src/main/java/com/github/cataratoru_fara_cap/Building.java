package com.github.cataratoru_fara_cap;

import com.github.cataratoru_fara_cap.Character.Player;

public class Building {
    public String name;
    public Effect effect;

    public Building (String name, Effect effect) {
        this.name = name;
        this.effect = effect;
    }

    public void applyEffect(Player player) {
        switch (effect) {
            case ATTACK:
                player.attack += 5;
                break;
            case DEFENSE:
                player.defense += 5;
                break;
            case HEALTH:
                player.health += 5;
                break;
            default:
                throw new IllegalArgumentException("Unknown effect: " + effect);
        }
    }
    public enum Effect {
        ATTACK,
        DEFENSE,
        HEALTH;
        }
    }
}