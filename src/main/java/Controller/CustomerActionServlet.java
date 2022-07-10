package Controller;

import Dao.CustomerActionDao;
import Dao.CustomerDao;
import Dao.SellListDao;
import Dao.SellProductDao;
import Model.Admin;
import Model.Customer;
import Model.SellList;
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

    private SellProductDao sellProductDao = new SellProductDao();

    private SellListDao sellListDao = new SellListDao();

    private CustomerDao customerDao = new CustomerDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "editCustomer":
                    editCustomer(req, resp);
                    break;
                case "delete":
                    editCustomer(req, resp);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

        protected void doGet (HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
            String action = req.getParameter("action");
            if (action == null) {
                action = "";
            }

            try {
                switch (action) {
                    case "smartPhone":
                        showSmartPhone(req, resp);
                        break;
                    case "laptop":
                        showLaptop(req, resp);
                        break;
                    case "tablet":
                        showTablet(req, resp);
                        break;
                    case "computer":
                        showComputer(req, resp);
                        break;
                    case "watch":
                        showWatch(req, resp);
                        break;
                    case "price":
                        showByPrice(req, resp);
                        break;
                    case "findA":
                        find(req, resp);
                        break;
                    case "editCustomer":
                        showEditCustomer(req, resp);
                        break;
                    case "delete":
                        showDelete(req, resp);
                        break;
                    case "notOrderedYet":
                    case "transferred":
                    case "delivered":
                        gioHang(req, resp);
                        break;
                }
            } catch (SQLException ex) {
                throw new ServletException(ex);
            }
        }


//    ----------------------------Hien thi Điện thoại----------------------------
        public void showSmartPhone (HttpServletRequest req, HttpServletResponse resp) throws
        IOException, SQLException, ServletException {
            Admin userAdmin = LoginServlet.userAdmin;
            Customer user = LoginServlet.user;
            req.setAttribute("userAdmin", userAdmin);
            req.setAttribute("user", user);


            List<SellProduct> smartPhones = customerActionDao.selectByProductType("SmartPhone");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
            req.setAttribute("smartPhones", smartPhones);
            requestDispatcher.forward(req, resp);
        }


        //    ----------------------------Hien thi LapTop----------------------------
        public void showLaptop (HttpServletRequest req, HttpServletResponse resp) throws
        IOException, SQLException, ServletException {
            Admin userAdmin = LoginServlet.userAdmin;
            Customer user = LoginServlet.user;
            req.setAttribute("userAdmin", userAdmin);
            req.setAttribute("user", user);

            List<SellProduct> laptops = customerActionDao.selectByProductType("laptop");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
            req.setAttribute("laptops", laptops);
            requestDispatcher.forward(req, resp);
        }

        //    ----------------------------Hien thi may tinh bang----------------------------
        public void showTablet (HttpServletRequest req, HttpServletResponse resp) throws
        IOException, SQLException, ServletException {
            Admin userAdmin = LoginServlet.userAdmin;
            Customer user = LoginServlet.user;
            req.setAttribute("userAdmin", userAdmin);
            req.setAttribute("user", user);


            List<SellProduct> tablets = customerActionDao.selectByProductType("tablet");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
            req.setAttribute("tablets", tablets);
            requestDispatcher.forward(req, resp);
        }

        //    ----------------------------Hien thi may tinh bàn----------------------------
        public void showComputer (HttpServletRequest req, HttpServletResponse resp) throws
        IOException, SQLException, ServletException {
            Admin userAdmin = LoginServlet.userAdmin;
            Customer user = LoginServlet.user;
            req.setAttribute("userAdmin", userAdmin);
            req.setAttribute("user", user);


            List<SellProduct> computers = customerActionDao.selectByProductType("computer");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
            req.setAttribute("computers", computers);
            requestDispatcher.forward(req, resp);
        }

        //    ----------------------------Hien thi Đồng hồ----------------------------
        public void showWatch (HttpServletRequest req, HttpServletResponse resp) throws
        IOException, SQLException, ServletException {
            Admin userAdmin = LoginServlet.userAdmin;
            Customer user = LoginServlet.user;
            req.setAttribute("userAdmin", userAdmin);
            req.setAttribute("user", user);


            List<SellProduct> watchs = customerActionDao.selectByProductType("watch");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
            req.setAttribute("watchs", watchs);
            requestDispatcher.forward(req, resp);
        }


        public void showByPrice (HttpServletRequest req, HttpServletResponse resp) throws
        IOException, SQLException, ServletException {
            Admin userAdmin = LoginServlet.userAdmin;
            Customer user = LoginServlet.user;
            req.setAttribute("userAdmin", userAdmin);
            req.setAttribute("user", user);

            String productType = req.getParameter("productType");
            String maker = req.getParameter("maker");
            int minPrice = Integer.parseInt(req.getParameter("minPrice"));
            int maxPrice = Integer.parseInt(req.getParameter("maxPrice"));

            List<SellProduct> findList = customerActionDao.selectByPrice(productType, maker, minPrice, maxPrice);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
            req.setAttribute("findList", findList);
            requestDispatcher.forward(req, resp);
        }

        //    ----------------------------find---------------------------

        public void find (HttpServletRequest req, HttpServletResponse resp) throws
        IOException, SQLException, ServletException {
            Admin userAdmin = LoginServlet.userAdmin;
            Customer user = LoginServlet.user;
            req.setAttribute("userAdmin", userAdmin);
            req.setAttribute("user", user);

            String find = req.getParameter("find");
            List<SellProduct> findList = sellProductDao.selectName(find);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
            req.setAttribute("findList", findList);
            requestDispatcher.forward(req, resp);
        }

        //    ----------------------------Hien thi gio hang---------------------------
        public void gioHang (HttpServletRequest req, HttpServletResponse resp) throws
        IOException, SQLException, ServletException {
            Admin userAdmin = LoginServlet.userAdmin;
            Customer user = LoginServlet.user;
            req.setAttribute("userAdmin", userAdmin);
            req.setAttribute("user", user);

            String statusAdmin = req.getParameter("action");
            String status;

            if (statusAdmin.equals("notOrderedYet")) {
                status = "Danh sach hang trong gio";
            } else if (statusAdmin.equals("transferred")) {
                status = "Danh sach hang da chuyen khoan";
            } else if (statusAdmin.equals("delivered")) {
                status = "Danh sach hang da mua";
            } else {
                status = null;
            }


            List<SellList> gioHang = customerActionDao.selectByGio(statusAdmin);

            if (gioHang.size() > 0) {
                req.setAttribute("status", status);
                req.setAttribute("gioHang", gioHang);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
                requestDispatcher.forward(req, resp);
            } else {
                SellProductServlet sellProductServlet = new SellProductServlet();
                sellProductServlet.showListWeb(req, resp);
            }


        }


//-------------------Edit thong tin SellList----------------------------

        public void showEditCustomer (HttpServletRequest req, HttpServletResponse resp) throws
        IOException, SQLException, ServletException {
            Admin userAdmin = LoginServlet.userAdmin;
            Customer user = LoginServlet.user;
            req.setAttribute("userAdmin", userAdmin);
            req.setAttribute("user", user);

            int id = Integer.parseInt(req.getParameter("id"));
            SellList sellList = sellListDao.select(id);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("SellList/editCustomer.jsp");
            req.setAttribute("sellList", sellList);
            requestDispatcher.forward(req, resp);
        }

        private void editCustomer (HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {
            Admin userAdmin = LoginServlet.userAdmin;
            Customer user = LoginServlet.user;
            req.setAttribute("userAdmin", userAdmin);
            req.setAttribute("user", user);

            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            int exportAmount = Integer.parseInt(req.getParameter("exportAmount"));
            int customerId = Integer.parseInt(req.getParameter("customerId"));
            Customer customer = customerDao.select(customerId);
            int sellProductId = Integer.parseInt(req.getParameter("sellProductId"));
            SellProduct sellProduct = sellProductDao.select(sellProductId);
            Admin admin = LoginServlet.userAdmin;
            String statusCustomer = req.getParameter("statusCustomer");
            String statusAdmin = req.getParameter("statusAdmin");

            SellList book = new SellList(id, exportAmount, customer, sellProduct, admin, statusCustomer, statusAdmin);
            sellListDao.edit(book);
            SellProductServlet sellProductServlet =new SellProductServlet();
            sellProductServlet.showListWeb(req, resp);
        }

    public void showDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException,SQLException,ServletException{
        Admin userAdmin = LoginServlet.userAdmin;
        Customer user = LoginServlet.user;
        req.setAttribute("userAdmin", userAdmin);
        req.setAttribute("user", user);

        int id = Integer.parseInt(req.getParameter("id"));
        sellListDao.delete(id);

        SellProductServlet sellProductServlet =new SellProductServlet();
        sellProductServlet.showListWeb(req, resp);

    }

    }