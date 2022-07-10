package Controller;

import Dao.CustomerActionDao;
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

@WebServlet(name = "SellProductServlet", urlPatterns = "/SellProduct")
public class SellProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private SellProductDao sellProductDao = new SellProductDao();
    private CustomerActionDao customerActionDao = new CustomerActionDao();
    private SellListDao sellListDao = new SellListDao();
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
                case "findA":
                    findA(req, resp);
                    break;
                case "sellProduct":
                    showList(req, resp);
                    break;
                default:
                    showListWeb(req, resp);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    //-------------------Hien thi toan bo list lên Web----------------------------
    public void showListWeb(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {

        Admin userAdmin = LoginServlet.userAdmin;
        Customer user = LoginServlet.user;
        req.setAttribute("userAdmin", userAdmin);
        req.setAttribute("user", user);



        List<SellProduct> laptops = sellProductDao.selectByProductType("laptop");
        List<SellProduct>  tablets = sellProductDao.selectByProductType("tablet");
        List<SellProduct> smartPhones = sellProductDao.selectByProductType("smartPhone");
        List<SellProduct> computers = sellProductDao.selectByProductType("computer");
        List<SellProduct>  watchs = sellProductDao.selectByProductType("watch");


        req.setAttribute("laptops", laptops);
        req.setAttribute("tablets", tablets);
        req.setAttribute("smartPhones", smartPhones);
        req.setAttribute("computers", computers);
        req.setAttribute("watchs", watchs);
        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req, resp);
    }

    //-------------------Hien thi toan bo list SellProduct----------------------------
    private void showList(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {
        List<SellProduct> sellProducts = sellProductDao.selectAll();
        List<SellList> sellLists = sellListDao.selectAll();
        for (int i = 0; i < sellProducts.size(); i++) {
            for (int j = 0; j < sellLists.size(); j++) {
                if (sellProducts.get(i).getId()==sellLists.get(j).getSellProduct().getId()){
                    sellProducts.get(i).setExportAmount(sellProducts.get(i).getExportAmount()+sellLists.get(j).getExportAmount());
                }
            }

        }

        req.setAttribute("sellProducts", sellProducts);
        RequestDispatcher dispatcher = req.getRequestDispatcher("SellProduct/SellProductList.jsp");
        dispatcher.forward(req, resp);
    }


    //-------------------add SellProduct----------------------------

    private void showCreate(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("sellProducts",sellProductDao.selectAll());
        RequestDispatcher dispatcher = req.getRequestDispatcher("SellProduct/create.jsp");
        dispatcher.forward(req, resp);
    }


    private void create(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {
        String name = req.getParameter("name");
        int price = Integer.parseInt(req.getParameter("price"));
        float discount = Float.parseFloat(req.getParameter("discount"));
        int importAmount = Integer.parseInt(req.getParameter("importAmount"));
        int exportAmount = Integer.parseInt(req.getParameter("exportAmount"));
        String picture = req.getParameter("picture");
        String properties = req.getParameter("properties");
        String productType = req.getParameter("productType");
        String maker = req.getParameter("maker");

        SellProduct newSellProduct = new SellProduct(name,price,discount,importAmount,exportAmount,picture,properties,productType,maker);
        sellProductDao.creat(newSellProduct);
        RequestDispatcher dispatcher = req.getRequestDispatcher("SellProduct/create.jsp");
        req.setAttribute("message", "New sellProduct was created");
        dispatcher.forward(req, resp);
    }


    //-------------------Edit thong tin SellProduct----------------------------

    public void showEdit(HttpServletRequest req,HttpServletResponse resp) throws IOException,SQLException,ServletException{
        int id = Integer.parseInt(req.getParameter("id"));
        SellProduct sellProduct = sellProductDao.select(id);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("SellProduct/edit.jsp");
        req.setAttribute("sellProduct", sellProduct);
        requestDispatcher.forward(req, resp);
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int price = Integer.parseInt(req.getParameter("price"));
        float discount = Float.parseFloat(req.getParameter("discount"));
        int importAmount = Integer.parseInt(req.getParameter("importAmount"));
        int exportAmount = Integer.parseInt(req.getParameter("exportAmount"));
        String picture = req.getParameter("picture");
        String properties = req.getParameter("properties");
        String productType = req.getParameter("productType");
        String maker = req.getParameter("maker");

        SellProduct book = new SellProduct(id,name,price,discount,importAmount,exportAmount,picture,properties,productType,maker);
        sellProductDao.edit(book);
        showList(req,resp);
    }


    //-------------------Delete thong tin SellProduct----------------------------

    public void showDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException,SQLException,ServletException{
        int id = Integer.parseInt(req.getParameter("id"));
        sellProductDao.delete(id);

        List<SellProduct> sellProducts =  sellProductDao.selectAll();
        req.setAttribute("sellProducts", sellProducts);
        RequestDispatcher dispatcher = req.getRequestDispatcher("SellProduct/SellProductList.jsp");
        dispatcher.forward(req, resp);
    }


    //-------------------find by Name----------------------------

    public void showFind(HttpServletRequest req, HttpServletResponse resp) throws IOException,SQLException,ServletException{
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("SellProduct/find.jsp");
        requestDispatcher.forward(req,resp);
    }

    public void find(HttpServletRequest req,HttpServletResponse resp) throws IOException,SQLException,ServletException{
        String find = req.getParameter("find");
        List<SellProduct> sellProducts = sellProductDao.selectName(find);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("SellProduct/find.jsp");
        req.setAttribute("sellProducts", sellProducts);
        requestDispatcher.forward(req, resp);
    }

    public void findA(HttpServletRequest req,HttpServletResponse resp) throws IOException,SQLException,ServletException{
        CustomerActionServlet customerActionServlet = new CustomerActionServlet();
        customerActionServlet.find(req,resp);
    }
}
