package com.feedbacksystem;

import com.feedbacksystem.database.CustomerDAO;
import com.feedbacksystem.database.FeedbackDAO;
import com.feedbacksystem.database.ProductDAO;
import com.feedbacksystem.model.Customer;
import com.feedbacksystem.model.Feedback;
import com.feedbacksystem.model.Product;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FeedbackDAOTest {

    static FeedbackDAO feedbackDAO;
    static int testCustomerId;
    static int testFeedbackId;
    static int testProductId;

    @BeforeAll
    static void setup() {
        feedbackDAO = new FeedbackDAO();

        //1. Create a test customer
        CustomerDAO customerDAO = new CustomerDAO();
        Customer c = new Customer();
        c.setName("Naseema");
        c.setEmail("nasee72@gmail.com");
        c.setPhone("8754841125");
        c.setGender("Female");

        boolean addedCustomer = customerDAO.addCustomer(c);
        assertTrue(addedCustomer, "Customer should be added successfully");

        List<Customer> customers = customerDAO.getAllCustomers();
        testCustomerId = customers.get(customers.size() - 1).getCustomerId();

        System.out.println("Test customer created with ID: " + testCustomerId);
        System.out.println("Test Customer ID: " + testCustomerId);

        //2. Create a test product
        ProductDAO productDAO = new ProductDAO();
        Product p = new Product();
        p.setName("Laptop");
        p.setDescription("Performance is excellent");
        p.setPrice(60000.00);

        boolean addedProduct = productDAO.addProduct(p);
        assertTrue(addedProduct, "Product should be added successfully");

        List<Product> products = productDAO.getAllProducts();
        testProductId = products.get(products.size() - 1).getProductId();

        System.out.println("Test product created with ID: " + testProductId);
        System.out.println("Test product ID: " + testProductId);
    }

    @Test
    @Order(1)
    public void testAddFeedback() {
        Feedback f = new Feedback();
        f.setCustomerId(testCustomerId);
        f.setProductId(testProductId);
        f.setMessage("Really good quality product!");
        f.setRating(5);

        boolean result = feedbackDAO.addFeedback(f);
        assertTrue(result, "Feedback insertion should return true");

        List<Feedback> all = feedbackDAO.getAllFeedback();
        testFeedbackId = all.get(all.size() - 1).getFeedbackId();

        System.out.println("Feedback added successfully with ID: " + testFeedbackId);
    }

    @Test
    @Order(2)
    public void testGetAllFeedback() {
        List<Feedback> feedbackList = feedbackDAO.getAllFeedback();
        assertNotNull(feedbackList, "Feedback list should not be null");
        assertTrue(!feedbackList.isEmpty(), "Feedback list should not be empty");
        System.out.println("Feedback list fetched successfully!");
    }

    @Test
    @Order(3)
    public void testUpdateFeedback() {
        Feedback updated = new Feedback();
        updated.setFeedbackId(testFeedbackId);
        updated.setCustomerId(testCustomerId);
        updated.setProductId(testProductId);
        updated.setMessage("Updated feedback message from JUnit");
        updated.setRating(4);

        boolean result = feedbackDAO.updateFeedback(updated);
        assertTrue(result, "Feedback should be updated successfully");
        System.out.println("Feedback updated successfully for ID: " + testFeedbackId);
    }

    @Test
    @Order(4)
    public void testDeleteFeedback() {
        boolean deleted = feedbackDAO.deleteFeedback(testFeedbackId);
        assertTrue(deleted, "Feedback should be deleted successfully");
        System.out.println("Feedback deleted successfully for ID: " + testFeedbackId);
    }
}
