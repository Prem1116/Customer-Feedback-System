package com.feedbacksystem;

import com.feedbacksystem.database.ProductDAO;
import com.feedbacksystem.model.Product;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductDAOTest {

    static ProductDAO productDAO;
    static int testProductId;

    @BeforeAll
    static void setup() {
        productDAO = new ProductDAO();
    }

    @Test
    @Order(1)
    public void testAddProduct() {
        Product p = new Product();
        p.setName("Test Product");
        p.setDescription("This is a test product for CRUD operations");
        p.setPrice(499.99);

        boolean result = productDAO.addProduct(p);
        assertTrue(result, "Product insertion should return true");

        List<Product> all = productDAO.getAllProducts();
        testProductId = all.get(all.size() - 1).getProductId();

        System.out.println("Product added successfully with ID: " + testProductId);
    }

    @Test
    @Order(2)
    public void testGetAllProducts() {
        List<Product> products = productDAO.getAllProducts();
        assertNotNull(products, "Product list should not be null");
        assertTrue(products.size() > 0, "Product list should not be empty");
        System.out.println("Product list fetched successfully!");
    }

    @Test
    @Order(3)
    public void testUpdateProduct() {
        Product updated = new Product();
        updated.setProductId(testProductId);
        updated.setName("Updated Test Product");
        updated.setDescription("Updated product description");
        updated.setPrice(599.99);

        boolean result = productDAO.updateProduct(updated);
        assertTrue(result, "Product should be updated successfully");
        System.out.println("Product updated successfully for ID: " + testProductId);
    }

    @Test
    @Order(4)
    public void testDeleteProduct() {
        boolean deleted = productDAO.deleteProduct(testProductId);
        assertTrue(deleted, "Product should be deleted successfully");
        System.out.println("Product deleted successfully for ID: " + testProductId);
    }
}
