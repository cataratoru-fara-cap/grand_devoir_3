package com.github.cataratoru_fara_cap;

public class Enemy extends Character {
    public Enemy(String name, int attack, int defense, int health) {
        this.name = name;
        this.isAlive = true;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
    }

    public void damage(int damage, Character player) {
        player.health -= damage*this.attack / player.defense ;
        if (player.health <= 0) {
            player.die();
        }
    }

    public void takeDamage(int damage, Character player) {
        this.health -= damage*player.attack / this.defense;
        if (this.health <= 0) {
            this.die();
        }
    }

    public void die() {
        this.isAlive = false;
    }

    public String toString() {
        return "Enemy: " + this.name + " Health: " + this.health + " Attack: " + this.attack + " Defense: " + this.defense;
    }

}
