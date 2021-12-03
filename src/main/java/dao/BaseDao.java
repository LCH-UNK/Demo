package dao;

import utils.ConfigManager;

import java.sql.*;


public class BaseDao {
    protected Connection conn;
    protected PreparedStatement ps;
    protected Statement stmt;
    protected ResultSet rs;

    // 获取数据库连接
    public boolean getConnection() {
        // 读出配置信息
        String driver = ConfigManager.getInstance().getString("jdbc.driver_class");
        String url = ConfigManager.getInstance().getString("jdbc.connection.url");
        String username = ConfigManager.getInstance().getString("jdbc.connection.username");
        String password = ConfigManager.getInstance().getString("jdbc.connection.password");
        // 加载JDBC驱动
        try {
            Class.forName(driver);
            // 与数据库建立连接
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //增删改操作
    public int executeUpdate(String sql, Object[] params) {
        int updateRows = 0;
        if (getConnection()) {
            try {
                ps = conn.prepareStatement(sql);
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
                updateRows = ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return updateRows;
    }

    //读操作
    public ResultSet executeSQL(String sql, Object[] params) {
        if (getConnection()) {
            try {
                ps = conn.prepareStatement(sql);
                //填充占位符
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
                rs = ps.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rs;
    }
    // 关闭资源
    public boolean closeResource() {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

}
