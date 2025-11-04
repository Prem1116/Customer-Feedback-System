package com.feedbacksystem.service;

import com.feedbacksystem.database.CustomerDAO;
import com.feedbacksystem.exception.DatabaseException;
import com.feedbacksystem.model.Customer;
import com.feedbacksystem.util.LoggerUtil;

import java.util.List;

public class CustomerService {

    private final CustomerDAO customerDAO = new CustomerDAO();

    public boolean registerCustomer(Customer customer) {
        try {
            boolean added = customerDAO.addCustomer(customer);
            if (added) {
                LoggerUtil.logger.info("Customer registered successfully!");
            }
            return added;
        } catch (DatabaseException e) {
            LoggerUtil.logger.error("Failed to register customer!", e);
            return false;
        }
    }

    public List<Customer> getAllCustomers() {
        try {
            return customerDAO.getAllCustomers();
        } catch (Exception e) {
            LoggerUtil.logger.error("Error fetching customers!", e);
            return List.of();
        }
    }

    public boolean updateCustomer(Customer customer) {
        try {
            boolean updated = customerDAO.updateCustomer(customer);
            if (updated) {
                LoggerUtil.logger.info("Customer updated successfully!");
            }
            return updated;
        } catch (DatabaseException e) {
            LoggerUtil.logger.error("Failed to update customer!", e);
            return false;
        }
    }

    public boolean deleteCustomer(int customerId) {
        try {
            boolean deleted = customerDAO.deleteCustomer(customerId);
            if (deleted) {
                LoggerUtil.logger.info("Customer deleted successfully!");
            }
            return deleted;
        } catch (DatabaseException e) {
            LoggerUtil.logger.error("Failed to delete customer!", e);
            return false;
        }
    }
}

