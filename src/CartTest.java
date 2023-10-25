import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CartTest {

    private Cart cart;
    private Product mockProduct;

    @BeforeEach
    public void setUp() {
        cart = new Cart();
        mockProduct = mock(Product.class); // Create a mock of Product

        // Define behaviors of the mock
        when(mockProduct.getId()).thenReturn(1L);
        when(mockProduct.getName()).thenReturn("Mock Product");
        when(mockProduct.getPrice()).thenReturn(100.0);
    }

    @Test
    public void testAddProduct() {
        cart.addProduct(mockProduct);
        assertTrue(cart.getProducts().contains(mockProduct));
    }

    @Test
    public void testRemoveProduct() {
        cart.addProduct(mockProduct);
        cart.removeProduct(mockProduct);
        assertFalse(cart.getProducts().contains(mockProduct));
    }

    @Test
    public void testPlaceOrder() {
        cart.addProduct(new Product(1,"111",1));
        Order order = cart.placeOrder(1);
        assertNotNull(order);
        assertEquals(1, order.getOrderId());
        assertEquals(1,order.getProducts().size());
    }
}
