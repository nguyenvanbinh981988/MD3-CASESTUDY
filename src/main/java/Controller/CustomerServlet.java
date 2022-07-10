package Controller;

import Dao.CustomerDao;
import Dao.RankGuestDao;
import Dao.SellProductDao;
import Model.Customer;
import Model.RankGuest;
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

@WebServlet(name = "CustomerServlet", urlPatterns = "/Customer")
public class CustomerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private CustomerDao customerDao = new CustomerDao();
    private RankGuestDao rankGuestDao = new RankGuestDao();
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
//                case "create":
//                    create(req, resp);
//                    break;
                case "edit":
                    edit(req, resp);
                    break;
                case "find":
                    find(req, resp);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
//                case "create":
//                    showCreate(req, resp);
//                    break;
                case "edit":
                    showEdit(req, resp);
                    break;
                case "delete":
                    showDelete(req, resp);
                    break;
                case "find":
                    showFind(req, resp);
                    break;
                default:
                    showList(req, resp);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    //-------------------Hien thi toan bo list Customer----------------------------
    private void showList(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {
        List<Customer> customers = customerDao.selectAll();
        req.setAttribute("customers", customers);
        RequestDispatcher dispatcher = req.getRequestDispatcher("Customer/CustomerList.jsp");
        dispatcher.forward(req, resp);
    }


    //-------------------add Customer----------------------------

//    private void showCreate(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//        req.setAttribute("customers",customerDao.selectAll());
//        RequestDispatcher dispatcher = req.getRequestDispatcher("Customer/create.jsp");
//        dispatcher.forward(req, resp);
//    }
//
//
//    private void create(HttpServletRequest req, HttpServletResponse resp)
//            throws SQLException, IOException, ServletException {
//        String name = req.getParameter("name");
//        String bankCard = req.getParameter("bankCard");
//        int rankGuestId =Integer.parseInt(req.getParameter("rankGuestId"));
//        RankGuest rankGuest = rankGuestDao.select(rankGuestId);
//        String address = req.getParameter("address");
//        String passWork = req.getParameter("passWork");
//
//        Customer newCustomer = new Customer(name,bankCard,rankGuest,address,passWork);
//        customerDao.creat(newCustomer);
//        RequestDispatcher dispatcher = req.getRequestDispatcher("Customer/create.jsp");
//        req.setAttribute("message", "New Customer was created");
//        dispatcher.forward(req, resp);
//    }


    //-------------------Edit thong tin SellProduct----------------------------

    public void showEdit(HttpServletRequest req,HttpServletResponse resp) throws IOException,SQLException,ServletException{
        int id = Integer.parseInt(req.getParameter("id"));
        Customer customer = customerDao.select(id);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Customer/edit.jsp");
        req.setAttribute("customer", customer);
        requestDispatcher.forward(req, resp);
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String bankCard = req.getParameter("bankCard");
        String rankG =req.getParameter("rankG");
        RankGuest rankGuest = rankGuestDao.selectRankName(rankG);
        String address = req.getParameter("address");
        String passWork = req.getParameter("passWork");

        Customer book = new Customer(id,name,bankCard,rankGuest,address,passWork);
        customerDao.edit(book);
        resp.sendRedirect("/Customer");
    }


    //-------------------Delete thong tin SellProduct----------------------------

    public void showDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException,SQLException,ServletException{
        int id = Integer.parseInt(req.getParameter("id"));
        customerDao.delete(id);

        List<Customer> customers =  customerDao.selectAll();
        req.setAttribute("customers", customers);
        RequestDispatcher dispatcher = req.getRequestDispatcher("Customer/CustomerList.jsp");
        dispatcher.forward(req, resp);
    }


    //-------------------find by Name----------------------------

    public void showFind(HttpServletRequest req, HttpServletResponse resp) throws IOException,SQLException,ServletException{
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Customer/find.jsp");
        requestDispatcher.forward(req,resp);
    }

    public void find(HttpServletRequest req,HttpServletResponse resp) throws IOException,SQLException,ServletException{
        String find = req.getParameter("find");
        List<Customer> customers = customerDao.selectName(find);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Customer/find.jsp");
        req.setAttribute("customers", customers);
        requestDispatcher.forward(req, resp);
    }
}
