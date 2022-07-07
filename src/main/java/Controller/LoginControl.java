package Controller;

import Account.Account;
import dao.AccountDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (urlPatterns = "/login")
public class LoginControl extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("user");
        String password = req.getParameter("pass");

        AccountDao accountDao =new AccountDao();
        Account a = accountDao.getAccount(username,password);
        if (a == null){
            req.setAttribute("mess","Nhập Sai Tên Hoặc Mật Khẩu");
            req.getRequestDispatcher("Loginn.jsp").forward(req,resp);
        }else {
            resp.sendRedirect("/abc.jsp");
        }
    }
}
