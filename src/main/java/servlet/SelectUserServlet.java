package servlet;

import base.User;
import dao.impl.UserDaoImpl;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "SelectUserServlet",value = "/SelectUserServlet")
public class SelectUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        UserDaoImpl userDao = new UserDaoImpl();
        List<User> users = userDao.getUsers(user);
        request.setAttribute("users" , users);
        request.getRequestDispatcher("/jsp/userlist.jsp").forward(request,response);
    }
}
