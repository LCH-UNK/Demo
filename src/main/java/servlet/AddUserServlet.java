package servlet;

import base.User;
import dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String postCode = request.getParameter("postCode");//用户邮编
        String contace = request.getParameter("contace");//用户姓名
//        String password = request.getParameter("userPassword");//用户密码
        String tel = request.getParameter("tel");//用户电话
        String addressDesc = request.getParameter("addressDesc");//用户地址
        User user = new User();
        UserDaoImpl userDao = new UserDaoImpl();
        user.setPostCode(postCode);
        user.setContace(contace);
//        user.setPassword(password);
        user.setTel(tel);
        user.setAddressDesc(addressDesc);
        userDao.addUser(user);
    }
}
