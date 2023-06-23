package cn.gamechanger.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.gamechanger.model.User;
import cn.gamechanger.model.dao.UserDao;

import cn.gamechanger.connection.DbCon;

@WebServlet("/user-login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.sendRedirect("login.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String username = request.getParameter("login-username");
            String password = request.getParameter("login-password");

            try {
                UserDao udao = new UserDao(DbCon.getConnection());
                User user = udao.userLogin(username, password);

                if (user != null) {
                    // Creazione della sessione per l'utente
                    HttpSession session = request.getSession();
                    session.setAttribute("userSession", user.getUsername());

                    out.print("user login");
                } else {
                    out.print("user login failed");
                }

                // Recupero dei dati dalla sessione
                HttpSession session = request.getSession(false);
                if (session != null) {
                    String sessionValue = (String) session.getAttribute("userSession");
                    System.out.println("Session Value: " + sessionValue);
                }
            } catch (ClassNotFoundException cnfe) {
                cnfe.printStackTrace();
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }

            out.print(username + password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
