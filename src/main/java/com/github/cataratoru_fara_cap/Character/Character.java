package com.github.cataratoru_fara_cap.Character;

public abstract class Character {
    public String name;
    public boolean isAlive;
    public int attack;
    public int defense;
    public int health;
    
    abstract public void damage(int damage, Character enemy);
    abstract public void takeDamage(int damage, Character enemy);
    abstract public void die();
}
