package com.github.cataratoru_fara_cap.Character;

import java.util.ArrayList;

import com.github.cataratoru_fara_cap.Item.Item;

public class Enemy extends Character {
    public Enemy(String name, double attack, double defense, double health) {
        this.name = name;
        this.isAlive = true;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.Items = new ArrayList<Item>();

    }

    public void damage(Character player) {
        player.health -= this.attack / player.defense ;
        if (player.health <= 0) {
            player.die();
        }
    }

    public void takeDamage(Character player) {
        this.health -= player.attack / this.defense;
        if (this.health <= 0) {
            this.die();
        }
    }

    public void dropItem() {
        //Function that randomly drops an inventory item upon death
        throw new UnsupportedOperationException("Unimplemented method 'dropItem'");
    }

    public void die() {
        this.isAlive = false;
    }

    public String toString() {
        return "Enemy: " + this.name + " Health: " + this.health + " Attack: " + this.attack + " Defense: " + this.defense;
    }

}
