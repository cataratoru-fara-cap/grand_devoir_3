package com.github.cataratoru_fara_cap.Character;

import java.util.ArrayList;

import com.github.cataratoru_fara_cap.Item.Item;

public abstract class Character {
    public String name;
    public boolean isAlive;
    public double attack;
    public double defense;
    public double health;
    public ArrayList<Item> Items;

    
    abstract public void damage(Character enemy);
    abstract public void takeDamage(Character enemy);
    abstract public void die();
}
