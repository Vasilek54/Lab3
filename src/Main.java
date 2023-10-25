import java.util.*;

public class Main {
    private static final Cart cart = new Cart();
    private static long currentProductId = 1;
    private static long currentOrderId = 1;
    private static final Map<Long, Order> orders = new HashMap<>(); // store all orders

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n---- E-Commerce System ----");
            System.out.println("1. Add product to cart");
            System.out.println("2. Remove product from cart");
            System.out.println("3. View cart");
            System.out.println("4. Place an order");
            System.out.println("5. View all orders");
            System.out.println("6. Check order status");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addProductToCart(scanner);
                    break;
                case 2:
                    removeProductFromCart(scanner);
                    break;
                case 3:
                    viewCart();
                    break;
                case 4:
                    placeOrder();
                    break;
                case 5:
                    viewAllOrders();
                    break;
                case 6:
                    checkOrderStatus(scanner);
                    break;
                case 7:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addProductToCart(Scanner scanner) {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();

        Product product = new Product(currentProductId++, name, price);
        cart.addProduct(product);

        System.out.println("Product added to cart.");
    }

    private static void removeProductFromCart(Scanner scanner) {
        System.out.print("Enter product ID to remove: ");
        long id = scanner.nextLong();

        Product productToRemove = null;
        for (Product product : cart.getProducts()) {
            if (product.getId() == id) {
                productToRemove = product;
                break;
            }
        }

        if (productToRemove != null) {
            cart.removeProduct(productToRemove);
            System.out.println("Product removed from cart.");
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void viewCart() {
        System.out.println("\n---- Products in Cart ----");
        for (Product product : cart.getProducts()) {
            System.out.println(product);
        }
    }

    private static void placeOrder() {
        Order order = cart.placeOrder(currentOrderId++);
        orders.put(order.getOrderId(), order); // store the order in our orders map
        System.out.println("Order placed successfully. Your order ID is: " + order.getOrderId());
    }

    private static void viewAllOrders() {
        System.out.println("\n---- All Orders ----");
        for (Order order : orders.values()) {
            System.out.println(order);
        }
    }

    private static void checkOrderStatus(Scanner scanner) {
        System.out.print("Enter your order ID to check status: ");
        long id = scanner.nextLong();

        Order order = orders.get(id);
        if (order != null) {
            System.out.println("Order Status for Order ID " + order.getOrderId() + ": " + order.getStatus());
        } else {
            System.out.println("Order not found.");
        }
    }
}
