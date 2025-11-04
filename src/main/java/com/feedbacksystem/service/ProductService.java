package com.feedbacksystem.service;

import com.feedbacksystem.database.ProductDAO;
import com.feedbacksystem.exception.DatabaseException;
import com.feedbacksystem.model.Product;
import com.feedbacksystem.util.LoggerUtil;

import java.util.List;

public class ProductService {

    private final ProductDAO productDAO = new ProductDAO();

    public boolean addProduct(Product product) {
        try {
            boolean added = productDAO.addProduct(product);
            if (added) {
                LoggerUtil.logger.info("Product added successfully!");
            }
            return added;
        } catch (DatabaseException e) {
            LoggerUtil.logger.error("Failed to add product!", e);
            return false;
        }
    }

    public List<Product> getAllProducts() {
        try {
            return productDAO.getAllProducts();
        } catch (Exception e) {
            LoggerUtil.logger.error("Error fetching products!", e);
            return List.of();
        }
    }

    public boolean updateProduct(Product product) {
        try {
            boolean updated = productDAO.updateProduct(product);
            if (updated) {
                LoggerUtil.logger.info("Product updated successfully!");
            }
            return updated;
        } catch (DatabaseException e) {
            LoggerUtil.logger.error("Failed to update product!", e);
            return false;
        }
    }

    public boolean deleteProduct(int productId) {
        try {
            boolean deleted = productDAO.deleteProduct(productId);
            if (deleted) {
                LoggerUtil.logger.info("Product deleted successfully!");
            }
            return deleted;
        } catch (DatabaseException e) {
            LoggerUtil.logger.error("Failed to delete product!", e);
            return false;
        }
    }
}
