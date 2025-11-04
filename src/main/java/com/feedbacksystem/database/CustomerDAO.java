package com.feedbacksystem.database;

import com.feedbacksystem.exception.DatabaseException;
import com.feedbacksystem.model.Customer;
import com.feedbacksystem.util.DBUtil;
import com.feedbacksystem.util.LoggerUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    public boolean addCustomer(Customer customer) {
        String query="INSERT INTO customer (name, email, phone, gender) VALUES (?, ?, ?, ?)";
        try (Connection conn= DBUtil.getConnection();
             PreparedStatement ps=conn.prepareStatement(query)) {

            ps.setString(1, customer.getName());
            ps.setString(2, customer.getEmail());
            ps.setString(3, customer.getPhone());
            ps.setString(4, customer.getGender());

            int rows=ps.executeUpdate();
            LoggerUtil.logger.info("Customer inserted successfully ");
            return rows > 0;

        } catch (Exception e) {
            throw new DatabaseException("Error inserting customer! ",e);
        }
    }

    public List<Customer> getAllCustomers() {
        List<Customer> list=new ArrayList<>();
        String query="SELECT * FROM Customer";

        try (Connection conn=DBUtil.getConnection();
             PreparedStatement ps=conn.prepareStatement(query);
             ResultSet rs=ps.executeQuery()) {

            while(rs.next()) {
                Customer c=new Customer();
                c.setCustomerId(rs.getInt("customer_id"));
                c.setName(rs.getString("name"));
                c.setEmail(rs.getString("email"));
                c.setPhone(rs.getString("phone"));
                c.setGender(rs.getString("gender"));
                c.setCreatedAt(rs.getTimestamp("created_at"));
                list.add(c);
            }
            LoggerUtil.logger.info("Fetched all customers ");

        } catch (Exception e) {
            LoggerUtil.logger.error("Error fetching customers! ",e);
        }
        return list;
    }
    public boolean updateCustomer(Customer customer) {
        String query = "UPDATE customer SET name=?, email=?, phone=?, gender=? WHERE customer_id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, customer.getName());
            ps.setString(2, customer.getEmail());
            ps.setString(3, customer.getPhone());
            ps.setString(4, customer.getGender());
            ps.setInt(5, customer.getCustomerId());

            int rows = ps.executeUpdate();
            LoggerUtil.logger.info("Customer updated successfully!");
            return rows > 0;

        } catch (Exception e) {
            throw new DatabaseException("Error updating customer!", e);
        }
    }

    // DELETE
    public boolean deleteCustomer(int customerId) {
        String query = "DELETE FROM customer WHERE customer_id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, customerId);
            int rows = ps.executeUpdate();
            LoggerUtil.logger.info("Customer deleted successfully!");
            return rows > 0;

        } catch (Exception e) {
            throw new DatabaseException("Error deleting customer!", e);
        }
    }
}
