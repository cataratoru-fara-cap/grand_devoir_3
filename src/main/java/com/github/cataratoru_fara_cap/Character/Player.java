package com.github.cataratoru_fara_cap.Character;
import java.util.HashMap;

import com.github.cataratoru_fara_cap.Building;
import com.github.cataratoru_fara_cap.Effect;
import com.github.cataratoru_fara_cap.Rarity;
import com.github.cataratoru_fara_cap.Gatherable.Gatherable;
import com.github.cataratoru_fara_cap.Item.*;

public class Player extends Character {
    public HashMap<String, Double> resources;

    public Player(String name, double attack, double defense, double health,
                 double wood, double rock, double grain) {
        this.name = name;
        this.isAlive = true;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.Items = new HashMap<String, Item>();
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

    public void eatItem(String itemName) { //Our Character is very hungry and eats a lot
        Item item = this.Items.get(itemName);
        if (item != null) {
            item.use(this);
            this.Items.remove(itemName);
        } else {
            System.out.println("Item not found in inventory.");
        }
    }

    public void makeItem(String itemType, Rarity rarity) {
        double woodRequired = 0;
        double rockRequired = 0;
        double grainRequired = 0;

        switch (itemType.toLowerCase()) {
            case "sword":
                woodRequired = 5 * rarity.getMultiplier();
                rockRequired = 3 * rarity.getMultiplier();
                if (resources.get("wood") >= woodRequired && resources.get("rock") >= rockRequired) {
                    Item newItem = new Sword("Crafted Sword", rarity);
                    this.Items.put(newItem.getName(), newItem);
                    resources.put("wood", resources.get("wood") - woodRequired);
                    resources.put("rock", resources.get("rock") - rockRequired);
                    System.out.println("Crafted a new sword: " + newItem.getName());
                } else {
                    System.out.println("Not enough resources to craft a sword.");
                }
                break;
            case "shield":
                woodRequired = 7 * rarity.getMultiplier();
                rockRequired = 2 * rarity.getMultiplier();
                if (resources.get("wood") >= woodRequired && resources.get("rock") >= rockRequired) {
                    Item newItem = new Shield("Crafted Shield", rarity);
                    this.Items.put(newItem.getName(), newItem);
                    resources.put("wood", resources.get("wood") - woodRequired);
                    resources.put("rock", resources.get("rock") - rockRequired);
                    System.out.println("Crafted a new shield: " + newItem.getName());
                } else {
                    System.out.println("Not enough resources to craft a shield.");
                }
                break;
            case "food":
                grainRequired = 10 * rarity.getMultiplier();
                if (resources.get("grain") >= grainRequired) {
                    Item newItem = new Food("Crafted Food", rarity);
                    this.Items.put(newItem.getName(), newItem);
                    resources.put("grain", resources.get("grain") - grainRequired);
                    System.out.println("Crafted new food: " + newItem.getName());
                } else {
                    System.out.println("Not enough resources to craft food.");
                }
                break;
            default:
                System.out.println("Unknown item type.");
                break;
        }
    }

    public Building makeLifeFountain() {
        double requiredWood = 50;
        double requiredStone = 30;

        if (resources.getOrDefault("wood", 0.0) >= requiredWood
                && resources.getOrDefault("stone", 0.0) >= requiredStone) {
            resources.put("wood", resources.get("wood") - requiredWood);
            resources.put("stone", resources.get("stone") - requiredStone);
            Building lifeFountain = new Building("lifeFountain", Effect.HEALTH);
            return lifeFountain;
        } else {
            System.out.println("Not enough resources to build Life Fountain.");
            return null;
        }
    }

    public Building makeArmory() {
        double requiredWood = 70;
        double requiredStone = 50;

        if (resources.getOrDefault("wood", 0.0) >= requiredWood
                && resources.getOrDefault("stone", 0.0) >= requiredStone) {
            resources.put("wood", resources.get("wood") - requiredWood);
            resources.put("stone", resources.get("stone") - requiredStone);
            Building armory = new Building("armory", Effect.DEFENSE);
            return armory;
        } else {
            System.out.println("Not enough resources to build Armory.");
            return null;
        }
    }

    public Building makeWeaponsHold() {
        double requiredWood = 100;
        double requiredStone = 80;

        if (resources.getOrDefault("wood", 0.0) >= requiredWood
                && resources.getOrDefault("stone", 0.0) >= requiredStone) {
            resources.put("wood", resources.get("wood") - requiredWood);
            resources.put("stone", resources.get("stone") - requiredStone);
            Building weaponsHold = new Building("weaponsHold", Effect.ATTACK);
            return weaponsHold;
        } else {
            System.out.println("Not enough resources to build Weapons Hold.");
            return null;
        }
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
