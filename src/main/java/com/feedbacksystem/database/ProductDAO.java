package com.feedbacksystem.database;

import com.feedbacksystem.exception.DatabaseException;
import com.feedbacksystem.model.Product;
import com.feedbacksystem.util.DBUtil;
import com.feedbacksystem.util.LoggerUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public boolean addProduct(Product product) {
        String query = "INSERT INTO product (name, description, price) VALUES (?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            ps.setDouble(3, product.getPrice());

            int rows = ps.executeUpdate();
            LoggerUtil.logger.info("Product inserted successfully!");
            return rows > 0;

        } catch (Exception e) {
            throw new DatabaseException("Error inserting product", e);
        }
    }

    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM product";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Product p = new Product();
                p.setProductId(rs.getInt("product_id"));
                p.setName(rs.getString("name"));
                p.setDescription(rs.getString("description"));
                p.setPrice(rs.getDouble("price"));
                p.setCreatedAt(rs.getTimestamp("created_at"));
                list.add(p);
            }
            LoggerUtil.logger.info("Fetched all products!");
        } catch (Exception e) {
            LoggerUtil.logger.error("Error fetching products", e);
        }
        return list;
    }

    public boolean updateProduct(Product product) {
        String query = "UPDATE product SET name=?, description=?, price=? WHERE product_id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            ps.setDouble(3, product.getPrice());
            ps.setInt(4, product.getProductId());

            int rows = ps.executeUpdate();
            LoggerUtil.logger.info("Product updated successfully!");
            return rows > 0;
        } catch (Exception e) {
            throw new DatabaseException("Error updating product", e);
        }
    }

    public boolean deleteProduct(int productId) {
        String query = "DELETE FROM product WHERE product_id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, productId);
            int rows = ps.executeUpdate();
            LoggerUtil.logger.info("Product deleted successfully!");
            return rows > 0;
        } catch (Exception e) {
            throw new DatabaseException("Error deleting product", e);
        }
    }
}
