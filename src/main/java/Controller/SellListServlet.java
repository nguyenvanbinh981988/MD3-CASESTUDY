package Controller;

import Dao.AdminDao;
import Dao.CustomerDao;
import Dao.SellListDao;
import Dao.SellProductDao;
import Model.Admin;
import Model.Customer;
import Model.SellList;
import Model.SellProduct;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "SellListServlet", urlPatterns = "/SellList")
public class SellListServlet extends HttpServlet {



    private static final long serialVersionUID = 1L;
    private SellListDao sellListDao = new SellListDao();
    private AdminDao adminDao = new AdminDao();
    private CustomerDao customerDao = new CustomerDao();
    private SellProductDao sellProductDao = new SellProductDao();
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    create(req, resp);
                    break;
                case "editAdmin":
                    editAdmin(req, resp);
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
                case "create":
                    showCreate(req, resp);
                    break;
                case "editAdmin":
                    showEditAdmin(req, resp);
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

    //-------------------Hien thi toan bo list SellProduct----------------------------
    private void showList(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {
        List<SellList> sellLists = sellListDao.selectAll();
        req.setAttribute("sellLists", sellLists);
        RequestDispatcher dispatcher = req.getRequestDispatcher("SellList/SellList.jsp");
        dispatcher.forward(req, resp);
    }


    //-------------------add SellProduct----------------------------

    private void showCreate(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("sellLists",sellListDao.selectAll());
        RequestDispatcher dispatcher = req.getRequestDispatcher("SellList/create.jsp");
        dispatcher.forward(req, resp);
    }


    private void create(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {
        int exportAmount = Integer.parseInt(req.getParameter("exportAmount"));
        int customerId = Integer.parseInt(req.getParameter("customerId"));
        Customer customer = customerDao.select(customerId);
        int sellProductId = Integer.parseInt(req.getParameter("sellProductId"));
        SellProduct sellProduct = sellProductDao.select(sellProductId);
        int adminId = Integer.parseInt(req.getParameter("adminId"));
        Admin admin = adminDao.select(adminId);
        String statusCustomer = req.getParameter("statusCustomer");
        String statusAdmin = req.getParameter("statusAdmin");

        SellList newSellList = new SellList(exportAmount,customer,sellProduct,admin,statusCustomer,statusAdmin);
        sellListDao.creat(newSellList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("SellList/create.jsp");
        req.setAttribute("message", "New SellList was created");
        dispatcher.forward(req, resp);
    }


    //-------------------Edit thong tin SellProduct----------------------------

    public void showEditAdmin(HttpServletRequest req,HttpServletResponse resp) throws IOException,SQLException,ServletException{
        int id = Integer.parseInt(req.getParameter("id"));
        SellList sellList = sellListDao.select(id);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("SellList/editAdmin.jsp");
        req.setAttribute("sellList", sellList);
        requestDispatcher.forward(req, resp);
    }

    private void editAdmin(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int exportAmount = Integer.parseInt(req.getParameter("exportAmount"));
        int customerId = Integer.parseInt(req.getParameter("customerId"));
        Customer customer = customerDao.select(customerId);
        int sellProductId = Integer.parseInt(req.getParameter("sellProductId"));
        SellProduct sellProduct = sellProductDao.select(sellProductId);
        int adminId = Integer.parseInt(req.getParameter("adminId"));
        Admin admin = adminDao.select(adminId);
        String statusCustomer = req.getParameter("statusCustomer");
        String statusAdmin = req.getParameter("statusAdmin");

        SellList book = new SellList(id,exportAmount,customer,sellProduct,admin,statusCustomer,statusAdmin);
        sellListDao.edit(book);
        resp.sendRedirect("/SellList");
    }


    //-------------------Delete thong tin SellProduct----------------------------

    public void showDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException,SQLException,ServletException{
        int id = Integer.parseInt(req.getParameter("id"));
        sellListDao.delete(id);

        List<SellList> sellLists =  sellListDao.selectAll();
        req.setAttribute("sellProducts", sellLists);
        RequestDispatcher dispatcher = req.getRequestDispatcher("SellList/SellListList.jsp");
        dispatcher.forward(req, resp);
    }


    //-------------------find by Name----------------------------

    public void showFind(HttpServletRequest req, HttpServletResponse resp) throws IOException,SQLException,ServletException{
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("SellList/find.jsp");
        requestDispatcher.forward(req,resp);
    }

    public void find(HttpServletRequest req,HttpServletResponse resp) throws IOException,SQLException,ServletException{
        String name = req.getParameter("name");
        List<SellList> sellLists = sellListDao.selectName(name);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("SellList/find.jsp");
        req.setAttribute("sellLists", sellLists);
        requestDispatcher.forward(req, resp);
    }
}
