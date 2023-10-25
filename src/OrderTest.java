import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OrderTest {

    private Order order;
    private Product mockProduct;

    @BeforeEach
    public void setUp() {
        mockProduct = mock(Product.class); // Створюємо мок для Product

        // Визначаємо поведінку моку
        when(mockProduct.getId()).thenReturn(1L);
        when(mockProduct.getName()).thenReturn("Mock Product");
        when(mockProduct.getPrice()).thenReturn(100.0);

        order = new Order(1, Arrays.asList(mockProduct));
    }

    @Test
    public void testGetters() {
        assertEquals(1, order.getOrderId());
        Product retrievedProduct = order.getProducts().get(0); // Припускаючи, що продукт є єдиним в списку

        assertEquals(1, retrievedProduct.getId());
        assertEquals("Mock Product", retrievedProduct.getName());
        assertEquals(100, retrievedProduct.getPrice());
        assertEquals("Pending", order.getStatus());

        // Перевіряємо, чи дійсно гетери продукту викликалися
        verify(mockProduct, times(1)).getId();
        verify(mockProduct, times(1)).getName();
        verify(mockProduct, times(1)).getPrice();
    }

    @Test
    public void testSetters() {
        order.setOrderId(2);

        Product newMockProduct = mock(Product.class);
        when(newMockProduct.getId()).thenReturn(2L);
        when(newMockProduct.getName()).thenReturn("New Mock Product");
        when(newMockProduct.getPrice()).thenReturn(150.0);

        order.setProducts(Arrays.asList(newMockProduct));
        order.setStatus("Completed");

        assertEquals(2, order.getOrderId());
        assertFalse(order.getProducts().contains(mockProduct));
        Product retrievedProduct = order.getProducts().get(0);

        assertEquals(2, retrievedProduct.getId());
        assertEquals("New Mock Product", retrievedProduct.getName());
        assertEquals(150, retrievedProduct.getPrice());
        assertEquals("Completed", order.getStatus());

        // Перевіряємо, чи гетери нового моку продукту були викликані
        verify(newMockProduct, times(1)).getId();
        verify(newMockProduct, times(1)).getName();
        verify(newMockProduct, times(1)).getPrice();
    }
}
