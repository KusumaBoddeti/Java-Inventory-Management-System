import java.util.ArrayList;

public class Inventory {
    private ArrayList<Product> products;

    public Inventory() {
        products = new ArrayList<>();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println(product.getName() + " added to inventory.");
    }

    public void sellProduct(String productName, int quantity) {
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(productName)) {
                if (p.getQuantity() >= quantity) {
                    p.setQuantity(p.getQuantity() - quantity);
                    System.out.println(quantity + " units of " + productName + " sold.");
                    return;
                } else {
                    System.out.println("Not enough stock.");
                    return;
                }
            }
        }
        System.out.println("Product not found.");
    }

    public void updateProduct(String productName, double newPrice, int newReorderLevel) {
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(productName)) {
                p.setPrice(newPrice);
                p.setReorderLevel(newReorderLevel);
                System.out.println(productName + " updated.");
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public void searchProduct(String productName) {
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(productName)) {
                p.displayProduct();
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public void displayAllProducts() {
        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        for (Product p : products) {
            p.displayProduct();
        }
    }

    public void showLowStock() {
        boolean found = false;
        for (Product p : products) {
            if (p.needsReorder()) {
                System.out.println(p.getName() + " needs reorder!");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No products need reordering.");
        }
    }
}
