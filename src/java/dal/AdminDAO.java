/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Admin;

/**
 *
 * @author tovie
 */
public class AdminDAO extends DBContext {

    public List<Admin> getAllAdmins() {
        try {
            List<Admin> admins = new ArrayList<>();
            String sql = "select * from admin";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Admin admin = new Admin(
                        rs.getInt("AdminID"),
                        rs.getString("Name"),
                        rs.getString("Email"),
                        rs.getString("Password")
                );
                admins.add(admin);
            }
            return admins;
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    
}
  public Admin getAdminByID(int id) {
        try {
            Admin admin = null;
            String sql = "select * from admin where AdminID=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                admin = new Admin(
                        rs.getInt("AdminID"),
                        rs.getString("Name"),
                        rs.getString("Email"),
                        rs.getString("Password")
                );
            }
            return admin;
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
  
  }
    public static void main(String[] args) {
        AdminDAO dao = new AdminDAO();
        System.out.println(dao.getAdminByID(1));
    }
}
  
