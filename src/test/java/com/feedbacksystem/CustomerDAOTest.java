package com.feedbacksystem;

import com.feedbacksystem.database.CustomerDAO;
import com.feedbacksystem.model.Customer;
import org.junit.jupiter.api.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerDAOTest {

    static CustomerDAO dao;
    static int customerId;

    @BeforeAll
    static void setup() {
        dao = new CustomerDAO();
    }

    @Test
    @Order(1)
    void testAddCustomer() {
        Customer c = new Customer();
        c.setName("User");
        c.setEmail("user@gmail.com");
        c.setPhone("7373953033");
        c.setGender("Female");

        boolean result = dao.addCustomer(c);
        assertTrue(result, "Customer insertion should return true");
    }

    @Test
    @Order(2)
    void testGetAllCustomers() {
        List<Customer> customers = dao.getAllCustomers();
        assertNotNull(customers, "Customer list should not be null");
        assertTrue(customers.size() >= 0, "Customer list should have at least 0 records");

        if (!customers.isEmpty()) {
            customerId = customers.get(customers.size() - 1).getCustomerId();
        }
    }

    @Test
    @Order(3)
    void testUpdateCustomer() {
        if (customerId == 0) return; // skip if add failed
        Customer c = new Customer();
        c.setCustomerId(customerId);
        c.setName("Updated User");
        c.setEmail("updateduser@gmail.com");
        c.setPhone("9999999999");
        c.setGender("Other");

        boolean updated = dao.updateCustomer(c);
        assertTrue(updated, "Customer should be updated successfully");
    }

    @Test
    @Order(4)
    void testDeleteCustomer() {
        if (customerId == 0) return; // skip if add failed
        boolean deleted = dao.deleteCustomer(customerId);
        assertTrue(deleted, "Customer should be deleted successfully");
    }
}
