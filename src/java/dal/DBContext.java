package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBContext {

    protected Connection connection;

    public DBContext() {
        try {
            String user = "hoangtv";
            String pass = "vh692004";
            String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=MovieTicketBooking;TrustServerCertificate=true;";
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
