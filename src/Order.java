import java.util.LinkedList;
import java.util.List;

public class Order {
    private long orderId;
    private List<Product> products;
    private String status;

    public Order(long orderId, List<Product> products) {
        this.orderId = orderId;
        this.products = new LinkedList<>(products);
        this.status = "Pending";
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public List<Product> getProducts() {
        System.out.println(products);
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", products=" + products +
                ", status='" + status + '\'' +
                '}';
    }
}
