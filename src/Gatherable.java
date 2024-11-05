public abstract class Gatherable{
    private float quantity;
    private Rarity rarity;

    public Gatherable(int quantity, Rarity rarity) {
        this.quantity = quantity;
        this.rarity = rarity;
    }

    public double getQuantity() {
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
