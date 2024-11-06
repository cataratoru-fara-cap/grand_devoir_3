package com.github.cataratoru_fara_cap.Character;

public abstract class Character {
    public String name;
    public boolean isAlive;
    public double attack;
    public double defense;
    public double health;
    
    abstract public void damage(Character enemy);
    abstract public void takeDamage(Character enemy);
    abstract public void die();
}
