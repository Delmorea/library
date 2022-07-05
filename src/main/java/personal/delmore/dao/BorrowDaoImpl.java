package personal.delmore.dao;

import personal.delmore.utils.JDBCUtils;
import personal.delmore.entity.Borrow;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class BorrowDaoImpl implements BorrowDao {
    //增加图书
    public void borrowAdd(Borrow borrow) {
        try {
            String userName = borrow.getUserName();
            String bkId = borrow.getBkId();
            String dateBorrow = borrow.getDateBorrow();
            String dateLendPlan = borrow.getDateLendPlan();
            String dateLendAct = borrow.getDateLendAct();

            //获取连接
            Connection conn = JDBCUtils.getConnection();
            String sql = "insert into borrow values (?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userName);
            pstmt.setString(2, bkId);
            pstmt.setString(3, dateBorrow);
            pstmt.setString(4, dateLendPlan);
            pstmt.setString(5, dateLendAct);

            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("添加成功!");
            }
            JDBCUtils.close(null, conn, pstmt);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    //删除图书
    public void borrowDelete(Borrow borrow) {
        try {
            Connection conn = JDBCUtils.getConnection();
            String userName = borrow.getUserName();
            String bkId = borrow.getBkId();
            String sql = "delete from borrow where userName = ? and bkID=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userName);
            pstmt.setString(2, bkId);
            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("删除成功!");
            } else {
                System.out.println("删除失败!");
            }
            JDBCUtils.close(null, conn, pstmt);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    //更新数据
    public void borrowUpdate(Borrow borrow) {
        try {
            Connection conn = JDBCUtils.getConnection();
            String userName = borrow.getUserName();
            String bkId = borrow.getBkId();
            String dateBorrow = borrow.getDateBorrow();
            String dateLendPlan = borrow.getDateLendPlan();
            String dateLendAct = borrow.getDateLendAct();

            String sql = "update borrow set DateBorrow=?,DateLendPlan=?,DateLendAct=? where userName=? and bkID=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dateBorrow);
            pstmt.setString(2, dateLendPlan);
            pstmt.setString(3, dateLendAct);
            pstmt.setString(4, userName);
            pstmt.setString(5, bkId);
            pstmt.executeUpdate();
            JDBCUtils.close(null, conn, pstmt);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    //查询所有借阅数据
    public List<Borrow> borrowSelectAll() {
        List<Borrow> borrows = null;
        try {
            Connection conn = JDBCUtils.getConnection();
            String sql = "select * from borrow";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            borrows = new ArrayList<>();
            while (rs.next()) {
                String userName = rs.getString(1);
                String bkId = rs.getString(2);
                String dateBorrow = rs.getString(3);
                String dateLendPlan = rs.getString(4);
                String dateLendAct = rs.getString(5);
                Borrow borrow = new Borrow(userName, bkId, dateBorrow, dateLendPlan, dateLendAct);
                borrows.add(borrow);
            }
            JDBCUtils.close(rs, conn, pstmt);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return borrows;          //return后的语句不执行
    }
}