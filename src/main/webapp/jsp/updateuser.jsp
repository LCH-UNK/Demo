<%@ page import="base.User" %>
<%@ page import="dao.impl.UserDaoImpl" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/head.jsp" %>
<%
    String id = null;
    String contace = null;
    String addressDesc = null;
    String postCode = null;
    String tel = null;
%>
<%
    User user = new User();
    UserDaoImpl userDao = new UserDaoImpl();
    List<User> userList = userDao.getUsers(user);
    for (User users : userList) {
        id = users.getId();
        contace = users.getContace();
        addressDesc = users.getAddressDesc();
        postCode = users.getPostCode();
        tel = users.getTel();
    }
%>

<div class="right">
    <div class="providerAdd">
        <h1 style="text-align: center;font-size: 30px">请输入修改后的信息</h1>
        <form action="/UpdateUserServlet?id=<%=id%>" id="userForm" name="userForm" method="post">
            <input type="hidden" name="method" value="add">
            <div>
                <label for="contace">用户名称：</label>
                <input type="text" name="contace" id="contace" value="<%=contace%>">
                <font color="red"></font>
            </div>
            <div>
                <label for="addressDesc">用户地址：</label>
                <input name="addressDesc" id="addressDesc" value="<%=addressDesc%>">
            </div>
            <div>
                <label for="postCode">邮箱：</label>
                <input type="text" name="postCode" id="postCode" value="<%=postCode%>">
                <font color="red"></font>
            </div>
            <div>
                <label for="tel">用户电话：</label>
                <input type="text" name="tel" id="tel" value="<%=tel%>">
                <font color="red"></font>
            </div>
            <div class="providerAddBtn">
                <input type="submit" name="add" id="add" value="修改" onclick="window.open('userlist.jsp')">
                <input type="button" id="back" name="back" value="返回" onclick="window.open('userlist.jsp')">
            </div>
        </form>
    </div>
</div>
</section>
<%@include file="/common/foot.jsp" %>