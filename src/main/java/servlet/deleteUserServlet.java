package servlet;
import base.User;
import dao.impl.UserDaoImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "deleteUserServlet", value = "/jsp/deleteuser")
public class deleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        UserDaoImpl userDao = new UserDaoImpl();
        User user = new User();
        user.setId(id);
        userDao.deleteUser(user);
        request.getRequestDispatcher("/jsp/userlist.jsp").forward(request,response);
    }
}
