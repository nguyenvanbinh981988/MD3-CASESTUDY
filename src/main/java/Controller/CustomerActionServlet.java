package Controller;

import Dao.CustomerActionDao;
import Model.SellProduct;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerActionServlet", urlPatterns = "/CustomerAction")
public class CustomerActionServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private CustomerActionDao customerActionDao = new CustomerActionDao();



    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "laptop":
                    showByProductType(req, resp);
                    break;
                case "Price":
                    showByPrice(req, resp);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }


//    ----------------------------Hien thi LapTop----------------------------
public void showByProductType(HttpServletRequest req,HttpServletResponse resp) throws IOException,SQLException,ServletException{
    String productType = req.getParameter("action");
    List<SellProduct> sellProducts = customerActionDao.selectByProductType(productType);
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
    req.setAttribute("sellProducts", sellProducts);
    requestDispatcher.forward(req, resp);
}

    public void showByPrice(HttpServletRequest req,HttpServletResponse resp) throws IOException,SQLException,ServletException{
        String productType = req.getParameter("action");
        String maker = req.getParameter("maker");
        int minPrice = Integer.parseInt(req.getParameter("minPrice"));
        int maxPrice = Integer.parseInt(req.getParameter("maxPrice"));

        List<SellProduct> sellProducts = customerActionDao.selectByPrice(productType,maker,minPrice,maxPrice);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
        req.setAttribute("sellProducts", sellProducts);
        requestDispatcher.forward(req, resp);
    }



}