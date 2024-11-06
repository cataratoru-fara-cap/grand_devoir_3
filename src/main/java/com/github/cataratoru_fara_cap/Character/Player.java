package com.github.cataratoru_fara_cap.Character;
import java.util.ArrayList;

import com.github.cataratoru_fara_cap.Potion;
import com.github.cataratoru_fara_cap.Gatherable.Gatherable;

public class Player extends Character {
    public ArrayList<Potion> potions;
    public ArrayList<Gatherable> resources;

    public Player(String name, int attack, int defense, int health) {
        this.name = name;
        this.isAlive = true;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.potions = new ArrayList<Potion>();
        this.resources = new ArrayList<Gatherable>();
    }

    public void damage(int damage, Character enemy) {
        enemy.health -= damage*this.attack / enemy.defense ;
        if (enemy.health <= 0) {
            enemy.die();
        }
    }

    public void takeDamage(int damage, Character enemy) {
        this.health -= damage*enemy.attack / this.defense;
        if (this.health <= 0) {
            this.die();
        }
    }

    public void die() {
        this.isAlive = false;
    }

    public void usePotion(Potion potion) {
        throw new UnsupportedOperationException("Unimplemented method 'usePotion'");
    }

    public String toString() {
        return "Player: " + this.name + " Health: " + this.health + " Attack: " + this.attack + " Defense: " + this.defense;
    }


}
