package personal.delmore.dao;


import personal.delmore.entity.User;
import personal.delmore.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: IDEA-workspace
 * @package: personal.delmore.dao
 * @className: UserDaoImpl
 * @author: Delmore
 * @description: 对user表的操作
 * @date: 2022/3/25 12:45
 * @version: 1.0
 */
public class UserDaoImpl implements UserDao {
    public void userAdd(User user) {
        try {
            String userName = user.getUserName();
            String password = user.getPassword();
            //获取连接
            Connection conn = null;
            conn = JDBCUtils.getConnection();
            String sql = "insert into user values (?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userName);
            pstmt.setString(2, password);

            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("添加成功!");
            }
            JDBCUtils.close(null, conn, pstmt);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void userUpdate(User user) {
        try {
            Connection conn = JDBCUtils.getConnection();
            String userName = user.getUserName();
            String password = user.getPassword();
            String sql = "update user set password=? where userName=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, password);
            pstmt.setString(2, userName);
            pstmt.executeUpdate();
            JDBCUtils.close(null, conn, pstmt);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public List<User> userSelectAll() {
        List<User> users = null;
        try {
            Connection conn = JDBCUtils.getConnection();
            String sql = "select * from user";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            users = new ArrayList<>();
            while (rs.next()) {
                String userName = rs.getString(1);
                String password = rs.getString(2);
                User user = new User(userName, password);
                users.add(user);
            }
            JDBCUtils.close(rs, conn, pstmt);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return users;          //return后的语句不执行
    }
}
