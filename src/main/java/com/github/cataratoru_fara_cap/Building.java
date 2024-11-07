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
                player.attack += player.attack/10;
                break;
            case DEFENSE:
                player.defense += player.defense/10;
                break;
            case HEALTH:
                player.health += player.health/10;
                break;
            default:
                System.out.println("The building you are in is just a normal house and provides no bonus");
        }
    }
}