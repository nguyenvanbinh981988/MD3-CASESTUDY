package Controller;

import Dao.AdminDao;
import Dao.CustomerDao;
import Dao.LoginDao;
import Dao.RankGuestDao;
import Model.Admin;
import Model.Customer;
import Model.RankGuest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", urlPatterns = "/Login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private LoginDao loginDao = new LoginDao();
    private CustomerDao customerDao = new CustomerDao();
    private RankGuestDao rankGuestDao = new RankGuestDao();

    public static Customer user = null;
    public static Admin userAdmin = null;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "LoginCustomer":
                    CustomerLogin(req, resp);
                    break;
                case "LoginAdmin":
                    AdminLogin(req, resp);
                    break;
                case "forgetCustomer":
                    ForgetPassCustomer(req, resp);
                    break;
                case "forgetAdmin":
                    ForgetPassAdmin(req, resp);
                    break;
                case "signUp":
                    signUp(req, resp);
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

        switch (action) {
            case "LoginCustomer":
                showCustomerLogin(req, resp);
                break;
            case "LoginAdmin":
                showAdminLogin(req, resp);
                break;
            case "forgetCustomer":
                showForgetPassCustomer(req, resp);
                break;
            case "forgetAdmin":
                showForgetPassAdmin(req, resp);
                break;
            case "signUp":
                showSignUp(req, resp);
                break;
            case "findA":
                try {
                    findA(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "outCustomer":
                try {
                    outCustomer(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "outAdmin":
                try {
                    outAdmin(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

//-------------------LoginCustomer----------------------------

    private void showCustomerLogin(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("Login/CustomerLogin.jsp");
        dispatcher.forward(req, resp);
    }

    private void CustomerLogin(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {
        String name = req.getParameter("name");
        String passWord = req.getParameter("passWord");

        if (loginDao.selectByPassWord(name, passWord) != null) {
            user = loginDao.selectByPassWord(name, passWord);
        }
        req.setAttribute("user", user);

        if (user != null) {
            SellProductServlet sellProductServlet = new SellProductServlet();
            sellProductServlet.showListWeb(req, resp);
        } else {
            outCustomer(req,resp);
        }
    }


    private void outCustomer(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {

        user = null;

        req.setAttribute("user", user);

        SellProductServlet sellProductServlet = new SellProductServlet();
        sellProductServlet.showListWeb(req, resp);
    }

    //-------------------LoginAdmin----------------------------

    private void showAdminLogin(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("Login/AdminLogin.jsp");
        dispatcher.forward(req, resp);
    }

    private void AdminLogin(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {
        String name = req.getParameter("name");
        String passWord = req.getParameter("passWord");


        userAdmin = loginDao.selectByPassWordAdmin(name, passWord);

        req.setAttribute("userAdmin", userAdmin);

        if (userAdmin != null) {
            SellProductServlet sellProductServlet = new SellProductServlet();
            sellProductServlet.showListWeb(req, resp);
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("Login/AdminLogin.jsp");
            dispatcher.forward(req, resp);
        }
    }

    private void outAdmin(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {


        userAdmin = null;

        req.setAttribute("userAdmin", userAdmin);

        SellProductServlet sellProductServlet = new SellProductServlet();
        sellProductServlet.showListWeb(req, resp);

    }


    //-------------------forget passWord Customer----------------------------

    private void showForgetPassCustomer(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("Login/ForgetPassCustomer.jsp");
        dispatcher.forward(req, resp);
    }

    private void ForgetPassCustomer(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {
        String name = req.getParameter("name");
        String bankCard = req.getParameter("bankCard");

        user = loginDao.selectByBankCard(name, bankCard);
        if (user != null) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("Login/ForgetCustomerAfter.jsp");
            req.setAttribute("user", user);
            dispatcher.forward(req, resp);
        } else {
            showForgetPassCustomer(req, resp);
        }
    }


    //-------------------forget passWord Admin----------------------------

    private void showForgetPassAdmin(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("Login/ForgetPassAdmin.jsp");
        dispatcher.forward(req, resp);
    }

    private void ForgetPassAdmin(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {
        String name = req.getParameter("name");
        int id = Integer.parseInt(req.getParameter("id"));

        userAdmin = loginDao.selectById(id, name);
        if (userAdmin != null) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("Login/ForgetAdminAfter.jsp");
            req.setAttribute("userAdmin", userAdmin);
            dispatcher.forward(req, resp);
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("Login/ForgetPassAdmin.jsp");
            dispatcher.forward(req, resp);
        }
    }


    //-------------------Dang ky tai khoan CusTomer----------------------------

    private void showSignUp(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("Customer/create.jsp");
        dispatcher.forward(req, resp);
    }


    private void signUp(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {
        String name = req.getParameter("name");
        String bankCard = req.getParameter("bankCard");
        int rankGuestId = Integer.parseInt(req.getParameter("rankGuestId"));
        RankGuest rankGuest = rankGuestDao.select(rankGuestId);
        String address = req.getParameter("address");
        String passWork = req.getParameter("passWork");

        Customer newCustomer = new Customer(name, bankCard, rankGuest, address, passWork);
        customerDao.creat(newCustomer);
        RequestDispatcher dispatcher = req.getRequestDispatcher("Customer/create.jsp");
        req.setAttribute("message", "New Customer was created");
        dispatcher.forward(req, resp);
    }

    public void findA(HttpServletRequest req,HttpServletResponse resp) throws IOException,SQLException,ServletException{
        CustomerActionServlet customerActionServlet = new CustomerActionServlet();
        customerActionServlet.find(req,resp);
    }

}