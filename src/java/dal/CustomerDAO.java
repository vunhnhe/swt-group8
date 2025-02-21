package dal;

import java.util.ArrayList;
import java.util.List;
import model.Customer;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerDAO extends DBContext {

    private static final Logger LOGGER = Logger.getLogger(CustomerDAO.class.getName());
    private static final String COLUMN_PASSWORD = "Password"; // Constant for "Password" column

    public List<Customer> getAllCustomers() {
        try {
            List<Customer> customers = new ArrayList<>();
            String sql = "SELECT * FROM customer";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer(
                        rs.getInt("CustomerID"),
                        rs.getString("Phone"),
                        rs.getString("CustomerName"),
                        rs.getString(COLUMN_PASSWORD), // Using the constant
                        rs.getString("Email"),
                        rs.getString("Address")
                );
                customers.add(customer);
            }
            return customers;
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error fetching all customers", ex);
        }
        return null;
    }

    public Customer getCustomerByID(int id) {
        try {
            String sql = "SELECT * FROM customer WHERE CustomerID=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Customer(
                        rs.getInt("CustomerID"),
                        rs.getString("Phone"),
                        rs.getString("CustomerName"),
                        rs.getString(COLUMN_PASSWORD),
                        rs.getString("Email"),
                        rs.getString("Address")
                );
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error fetching customer by ID", ex);
        }
        return null;
    }

    public Customer getCustomerByEmail(String email) {
        try {
            String sql = "SELECT * FROM customer WHERE Email=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Customer(
                        rs.getInt("CustomerID"),
                        rs.getString("Phone"),
                        rs.getString("CustomerName"),
                        rs.getString(COLUMN_PASSWORD),
                        rs.getString("Email"),
                        rs.getString("Address")
                );
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error fetching customer by email", ex);
        }
        return null;
    }

    public Customer getCustomerByName(String name) {
        try {
            String sql = "SELECT * FROM customer WHERE CustomerName=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Customer(
                        rs.getInt("CustomerID"),
                        rs.getString("Phone"),
                        rs.getString("CustomerName"),
                        rs.getString(COLUMN_PASSWORD),
                        rs.getString("Email"),
                        rs.getString("Address")
                );
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error fetching customer by name", ex);
        }
        return null;
    }

    public Customer getCustomerByPassword(String password) {
        try {
            String sql = "SELECT * FROM customer WHERE " + COLUMN_PASSWORD + "=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Customer(
                        rs.getInt("CustomerID"),
                        rs.getString("Phone"),
                        rs.getString("CustomerName"),
                        rs.getString(COLUMN_PASSWORD),
                        rs.getString("Email"),
                        rs.getString("Address")
                );
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error fetching customer by password", ex);
        }
        return null;
    }

    public boolean updateCustomer(Customer customer) {
        try {
            String sql = "UPDATE customer SET Phone=?, CustomerName=?, " + COLUMN_PASSWORD + "=?, Email=?, Address=? WHERE CustomerID=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, customer.getPhone());
            ps.setString(2, customer.getName());
            ps.setString(3, customer.getPassword());
            ps.setString(4, customer.getEmail());
            ps.setString(5, customer.getAddress());
            ps.setInt(6, customer.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error updating customer", ex);
        }
        return false;
    }

    public boolean deleteCustomer(int id) {
        try {
            String sql = "DELETE FROM customer WHERE CustomerID=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error deleting customer", ex);
        }
        return false;
    }

    public static void main(String[] args) {
        CustomerDAO dao = new CustomerDAO();
        LOGGER.log(Level.INFO, "Customer: {0}", dao.getCustomerByID(2));
    }
}
