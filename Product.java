public class Product {
    private String name;
    private int quantity;
    private double price;
    private int reorderLevel;

    public Product(String name, int quantity, double price, int reorderLevel) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.reorderLevel = reorderLevel;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public int getReorderLevel() {
        return reorderLevel;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setReorderLevel(int reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public boolean needsReorder() {
        return quantity < reorderLevel;
    }

    @Override
    public String toString() {
        return name + "," + quantity + "," + price + "," + reorderLevel;
    }

    public void displayProduct() {
        System.out.println(
                "Name: " + name + " | Qty: " + quantity + " | Price: ₹" + price + " | Reorder Level: " + reorderLevel);
    }
}
