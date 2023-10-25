import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    private Product product;

    @BeforeEach
    public void setUp() {
        product = new Product(1, "Test Product", 100);
    }

    @Test
    public void testGetters() {
        assertEquals(1, product.getId());
        assertEquals("Test Product", product.getName());
        assertEquals(100, product.getPrice());
    }

    @Test
    public void testSetters() {
        product.setId(2);
        product.setName("New Product");
        product.setPrice(150);

        assertEquals(2, product.getId());
        assertEquals("New Product", product.getName());
        assertEquals(150, product.getPrice());
    }
}
