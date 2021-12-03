package dao.impl;

import base.User;
import dao.BaseDao;
import dao.UserDao;


import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class UserDaoImpl extends BaseDao implements UserDao {
    //添加用户
    @Override
    public boolean addUser(User user) {
        String sql = "insert into smbms_address(id,contact,addressDesc,postCode,tel,password,creationDate,modifyBy,modifyDate,userId) values(?,?,?,?,?,?,?,?,?,?)";
        Object[] params = {user.getId(),user.getContace(),user.getAddressDesc(),user.getPostCode(),
        user.getTel(),user.getPassword(),user.getCreationDate(),user.getModifyBy(),user.getModifyDate(),user.getUserid()};
        int i = executeUpdate(sql, params);
        return true;
    }

    //根据id删除用户
    @Override
    public void deleteUser(User user) {
        String sql = "delete from smbms_address where id=?";
        Object[] params = {user.getId()};
        int i = executeUpdate(sql, params);
    }

    //根据id修改用户信息
    @Override
    public void updateUser(User user) {
        String sql = "update smbms_address set  contact = ?,addressDesc = ?, postCode = ?, tel = ? where id = ?";
        Object[] params = {user.getContace(), user.getAddressDesc(), user.getPostCode(),user.getTel(),user.getId()};
        int i = executeUpdate(sql, params);
    }

    // 查询所有用户信息
    @Override
    public List<User> getUsers(User user) {
        List<User> list = new ArrayList<User>();
        try {
            String sql = "select * from smbms_address";
            Object[] params = {};
            rs = this.executeSQL(sql, params);
            while (rs.next()) {
                User users = new User();
                String id = rs.getString("id");
                String contact = rs.getString("contact");
                String addressDesc = rs.getString("addressDesc");
                String postCode = rs.getString("postCode");
                String tel = rs.getString("tel");
                String password = rs.getString("password");
                Date creationDate = rs.getDate("creationDate");
                int modifyBy = rs.getInt("modifyBy");
                Date modifyDate = rs.getDate("modifyDate");
                int userid = rs.getInt("userid");
                users.setId(id);
                users.setContace(contact);
                users.setAddressDesc(addressDesc);
                users.setPostCode(postCode);
                users.setTel(tel);
                users.setPassword(password);
                users.setCreationDate(creationDate);
                users.setModifyBy(modifyBy);
                users.setModifyDate(modifyDate);
                users.setUserid(userid);
                list.add(users);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeResource();
        }
        return list;
    }


}
