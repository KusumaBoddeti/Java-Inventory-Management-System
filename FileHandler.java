import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    private static final String FILE_NAME = "inventory.csv";

    public static void saveToFile(ArrayList<Product> products) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Product p : products) {
                bw.write(p.toString());
                bw.newLine();
            }
            System.out.println("Inventory saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    public static ArrayList<Product> loadFromFile() {
        ArrayList<Product> products = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists())
            return products;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    products.add(new Product(data[0],
                            Integer.parseInt(data[1]),
                            Double.parseDouble(data[2]),
                            Integer.parseInt(data[3])));
                }
            }
            System.out.println("Inventory loaded from file.");
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
        return products;
    }
}
