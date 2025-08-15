import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.getProducts().addAll(FileHandler.loadFromFile());

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==== Inventory Management ====");
            System.out.println("1. Add Product");
            System.out.println("2. Sell Product");
            System.out.println("3. Search Product");
            System.out.println("4. Update Product");
            System.out.println("5. Display All Products");
            System.out.println("6. Show Low Stock");
            System.out.println("7. Save & Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter quantity: ");
                    int qty = sc.nextInt();
                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();
                    System.out.print("Enter reorder level: ");
                    int reorder = sc.nextInt();
                    inventory.addProduct(new Product(name, qty, price, reorder));
                    break;

                case 2:
                    System.out.print("Enter product name: ");
                    String sellName = sc.nextLine();
                    System.out.print("Enter quantity to sell: ");
                    int sellQty = sc.nextInt();
                    inventory.sellProduct(sellName, sellQty);
                    break;

                case 3:
                    System.out.print("Enter product name to search: ");
                    String searchName = sc.nextLine();
                    inventory.searchProduct(searchName);
                    break;

                case 4:
                    System.out.print("Enter product name to update: ");
                    String updateName = sc.nextLine();
                    System.out.print("Enter new price: ");
                    double newPrice = sc.nextDouble();
                    System.out.print("Enter new reorder level: ");
                    int newReorder = sc.nextInt();
                    inventory.updateProduct(updateName, newPrice, newReorder);
                    break;

                case 5:
                    inventory.displayAllProducts();
                    break;

                case 6:
                    inventory.showLowStock();
                    break;

                case 7:
                    FileHandler.saveToFile(inventory.getProducts());
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 7);

        sc.close();
    }
}
