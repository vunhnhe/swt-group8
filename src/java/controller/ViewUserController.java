package controller;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Customer;
import dal.CustomerDAO;

@WebServlet(name = "ViewUserController", urlPatterns = {"/user"})
public class ViewUserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        CustomerDAO dao = new CustomerDAO();
        List<Customer> customers = dao.getAllCustomers();
        
        request.setAttribute("customers", customers);
        request.getRequestDispatcher("viewUsers.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet hiển thị danh sách người dùng";
    }
}
