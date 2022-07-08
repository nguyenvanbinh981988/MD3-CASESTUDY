package Controller;

import Dao.AdminDao;
import Model.Admin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdminServlet", urlPatterns = "/Admin")
public class AdminServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private AdminDao adminDao = new AdminDao();
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
                case "create":
                    showCreate(req, resp);
                    break;
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

    //-------------------Hien thi toan bo list SellProduct----------------------------
    private void showList(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {
        List<Admin> admins = adminDao.selectAll();
        req.setAttribute("admins", admins);
        RequestDispatcher dispatcher = req.getRequestDispatcher("Admin/AdminList.jsp");
        dispatcher.forward(req, resp);
    }


    //-------------------add SellProduct----------------------------

    private void showCreate(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("admins",adminDao.selectAll());
        RequestDispatcher dispatcher = req.getRequestDispatcher("Admin/create.jsp");
        dispatcher.forward(req, resp);
    }


    private void create(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {
        String name = req.getParameter("name");
        String position = req.getParameter("position");
        String passWord = req.getParameter("passWord");

        Admin newAdmin = new Admin(name,position,passWord);
        adminDao.creat(newAdmin);
        RequestDispatcher dispatcher = req.getRequestDispatcher("Admin/create.jsp");
        req.setAttribute("message", "New sellProduct was created");
        dispatcher.forward(req, resp);
    }


    //-------------------Edit thong tin SellProduct----------------------------

    public void showEdit(HttpServletRequest req,HttpServletResponse resp) throws IOException,SQLException,ServletException{
        int id = Integer.parseInt(req.getParameter("id"));
        Admin admin = adminDao.select(id);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Admin/edit.jsp");
        req.setAttribute("admin", admin);
        requestDispatcher.forward(req, resp);
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String position = req.getParameter("position");
        String passWork = req.getParameter("passWork");

        Admin book = new Admin(id,name,position,passWork);
        adminDao.edit(book);
        resp.sendRedirect("/Admin");
    }


    //-------------------Delete thong tin SellProduct----------------------------

    public void showDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException,SQLException,ServletException{
        int id = Integer.parseInt(req.getParameter("id"));
        adminDao.delete(id);

        List<Admin> admins =  adminDao.selectAll();
        req.setAttribute("admins", admins);
        RequestDispatcher dispatcher = req.getRequestDispatcher("Admin/AdminList.jsp");
        dispatcher.forward(req, resp);
    }


    //-------------------find by Name----------------------------

    public void showFind(HttpServletRequest req, HttpServletResponse resp) throws IOException,SQLException,ServletException{
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("SellProduct/find.jsp");
        requestDispatcher.forward(req,resp);
    }

    public void find(HttpServletRequest req,HttpServletResponse resp) throws IOException,SQLException,ServletException{
        String find = req.getParameter("find");
        List<Admin> admins = adminDao.selectName(find);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Admin/find.jsp");
        req.setAttribute("admins", admins);
        requestDispatcher.forward(req, resp);
    }
}
