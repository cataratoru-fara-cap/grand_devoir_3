package com.github.cataratoru_fara_cap.Character;

import java.util.HashMap;
import com.github.cataratoru_fara_cap.Item.Item;

public abstract class Character {
    public String name;
    public boolean isAlive;
    public double attack;
    public double defense;
    public double health;
    public HashMap<String, Item> Items;

    abstract public void damage(Character enemy);
    abstract public void takeDamage(Character enemy);
    abstract public void die();
}
