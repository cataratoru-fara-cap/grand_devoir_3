import java.util.ArrayList;

public abstract class Character {
    private String name;
    private boolean isAlive;
    private int attack;
    private int defense;
    private int health;
    private ArrayList<Potion> potions;
    private ArrayList<Gatherable> resources;
    
    abstract public void damage(int damage);
    abstract public void takeDamage(int damage);
    abstract public void die();
}
