package com.github.cataratoru_fara_cap.Character;
import java.util.ArrayList;
import java.util.HashMap;

import com.github.cataratoru_fara_cap.Gatherable.Gatherable;
import com.github.cataratoru_fara_cap.Item.Item;

public class Player extends Character {
    public HashMap<String, Double> resources;

    public Player(String name, double attack, double defense, double health,
                 double wood, double rock, double grain) {
        this.name = name;
        this.isAlive = true;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.Items = new ArrayList<Item>();
        this.resources = new HashMap<String, Double>();
        this.resources.put("wood", wood);
        this.resources.put("rock", rock);
        this.resources.put("grain", grain);
    }

    public void damage(Character enemy) {
        enemy.health -= this.attack / enemy.defense ;
        if (enemy.health <= 0) {
            enemy.die();
        }
    }

    public void takeDamage(Character enemy) {
        this.health -= enemy.attack / this.defense;
        if (this.health <= 0) {
            this.die();
        }
    }

    public void die() {
        this.isAlive = false;
    }

    public void useItem(Item item) {
        throw new UnsupportedOperationException("Unimplemented method 'useItem'");
    }

    public void makeItem() {
        throw new UnsupportedOperationException("Unimplemented method 'makeItem'");
    }

    public void makeBuilding(Item item) {
        throw new UnsupportedOperationException("Unimplemented method 'makeBuilding'");
    }

    public void gatherResource(Gatherable resourceType) {
        String name = resourceType.getName();
        double quantity = this.resources.get(name) + resourceType.gather();
        this.resources.put(name, quantity);
    }

    public String toString() {
        return "Player: " + this.name + " Health: " + this.health + " Attack: " + this.attack + " Defense: " + this.defense +
               " Resources: " + this.resources.toString();
    }
}
