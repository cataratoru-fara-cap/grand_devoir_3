public abstract class Gatherable{
    private int quantity;
    private Rarity rarity;

    public Gatherable(int quantity, Rarity rarity) {
        this.quantity = quantity;
        this.rarity = rarity;
    }

    public int getQuantity() {
        return quantity;
    }
    public Rarity getRarity() {
        return rarity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }
    public String toString() {
        return "Quantity: " + quantity + ", Rarity: " + rarity;
    }
}
