package com.github.cataratoru_fara_cap;

public abstract class Character {
    protected String name;
    protected boolean isAlive;
    protected int attack;
    protected int defense;
    protected int health;
    
    abstract public void damage(int damage, Character enemy);
    abstract public void takeDamage(int damage, Character enemy);
    abstract public void die();
}
