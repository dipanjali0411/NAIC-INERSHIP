import java.util.ArrayList;
import java.util.Scanner;

class Product {
    private final String name;
    private int quantity;

    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product: " + name + " | Quantity: " + quantity;
    }
}

public class InventorySystem {
    private static final ArrayList<Product> products = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        System.out.println("Welcome to the Inventory System!");

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. List Products");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            String input = scanner.nextLine();
            int choice;

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                continue;
            }

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> removeProduct();
                case 3 -> listProducts();
                case 4 -> {
                    running = false;
                    System.out.println("Exiting... Goodbye!");
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addProduct() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter quantity: ");
        String quantityInput = scanner.nextLine();
        int quantity;

        try {
            quantity = Integer.parseInt(quantityInput);
            if (quantity < 0) {
                System.out.println("Quantity cannot be negative.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid quantity. Must be a number.");
            return;
        }

        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(name)) {
                p.setQuantity(p.getQuantity() + quantity);
                System.out.println("Product exists. Quantity updated.");
                return;
            }
        }

        products.add(new Product(name, quantity));
        System.out.println("Product added successfully!");
    }

    private static void removeProduct() {
        System.out.print("Enter product name to remove: ");
        String name = scanner.nextLine().trim();

        boolean removed = false;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equalsIgnoreCase(name)) {
                products.remove(i);
                removed = true;
                System.out.println("Product removed successfully!");
                break;
            }
        }

        if (!removed) {
            System.out.println("Product not found.");
        }
    }

    private static void listProducts() {
        if (products.isEmpty()) {
            System.out.println("No products in inventory.");
        } else {
            System.out.println("\nInventory List:");
            for (Product p : products) {
                System.out.println(p);
            }
        }
    }
}
