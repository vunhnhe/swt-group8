/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.List;
import model.Customer;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tovie
 */
public class CustomerDAO extends DBContext {

    public List<Customer> getAllCustomers() {
        try {
            List<Customer> customers = new ArrayList<>();
            String sql = "select * from customer";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer(
                        rs.getInt("CustomerID"),
                        rs.getString("Phone"),
                        rs.getString("CustomerName"),
                        rs.getString("Password"),
                        rs.getString("Email"),
                        rs.getString("Address")
                );
                customers.add(customer);
            }
            return customers;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Customer getCustomerByID(int id) {
        try {
            Customer customer = null;
            String sql = "select * from customer where CustomerID=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                customer = new Customer(
                        rs.getInt("CustomerID"),
                        rs.getString("Phone"),
                        rs.getString("CustomerName"),
                        rs.getString("Password"),
                        rs.getString("Email"),
                        rs.getString("Address")
                );
            }
            return customer;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        CustomerDAO dao = new CustomerDAO();
        System.out.println(dao.getCustomerByID(1));
    }
}
