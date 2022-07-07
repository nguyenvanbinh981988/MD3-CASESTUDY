package Controller;

import Account.Account;
import dao.AccountDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/signup")
public class SignUpControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user");
        String pass = req.getParameter("pass");
        String repass = req.getParameter("repass");
        if(!pass.equals(repass)){
            resp.sendRedirect("Loginn.jsp");
        }else {
            AccountDao accountDao = new AccountDao();
            try {
                Account a = accountDao.CheckAccount(user);
                if(a==null){
                    accountDao.Singup(user,pass);
                    resp.sendRedirect("abc.jsp");

                }else {
                    resp.sendRedirect("Loginn.jsp");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

