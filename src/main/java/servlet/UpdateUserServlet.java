package servlet;

import base.User;
import dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "UpdateUserServlet",value = "/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String contace = request.getParameter("contace");
        String addressDesc = request.getParameter("addressDesc");
        String postCode = request.getParameter("postCode");
        String tel = request.getParameter("tel");
        UserDaoImpl userDao = new UserDaoImpl();
        User user = new User();
        user.setContace(contace);
        user.setAddressDesc(addressDesc);
        user.setPostCode(postCode);
        user.setTel(tel);
        user.setId(id);
        userDao.updateUser(user);
        request.getRequestDispatcher("/jsp/userlist.jsp").forward(request,response);
    }
}
