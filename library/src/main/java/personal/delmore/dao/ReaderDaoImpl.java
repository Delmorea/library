package personal.delmore.dao;

import personal.delmore.utils.JDBCUtils;
import personal.delmore.entity.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ReaderDaoImpl implements ReaderDao {
    public void readerAdd(Reader reader){
        try {
            String userName = reader.getUserName();
            String rdType = reader.getRdType();
            String rdName = reader.getRdName();
            String rdDept = reader.getRdDept();
            String rdQQ = reader.getRdQQ();
            Integer rdBorrowQty = reader.getRdBorrowQty();
            boolean power = reader.isPower();
            //获取连接
            Connection conn = null;
            conn = JDBCUtils.getConnection();
            String sql = "insert into reader values (?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userName);
            pstmt.setString(2, rdType);
            pstmt.setString(3, rdName);
            pstmt.setString(4, rdDept);
            pstmt.setString(5, rdQQ);
            pstmt.setInt(6, rdBorrowQty);
            pstmt.setBoolean(7, power);

            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("添加成功!");
            }
            JDBCUtils.close(null, conn, pstmt);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void readerDelete(Reader reader){
        try {
            Connection conn = JDBCUtils.getConnection();
            String userName = reader.getUserName();
            String sql = "delete from reader where userName = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userName);
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

    public void readerUpdate(Reader reader){
        try {
            Connection conn = JDBCUtils.getConnection();
            String userName = reader.getUserName();
            String rdType = reader.getRdType();
            String rdName = reader.getRdName();
            String rdDept = reader.getRdDept();
            String rdQQ = reader.getRdQQ();
            int rdBorrowQty = reader.getRdBorrowQty();
            boolean power = reader.isPower();

            String sql = "update reader set rdName=?,rdType=?,rdDept=?,rdQQ=?,rdBorrowQty=?,power=? where userName=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, rdName);
            pstmt.setString(2, rdType);
            pstmt.setString(3, rdDept);
            pstmt.setString(4, rdQQ);
            pstmt.setInt(5, rdBorrowQty);
            pstmt.setBoolean(6, power);
            pstmt.setString(7, userName);
            pstmt.executeUpdate();
            JDBCUtils.close(null, conn, pstmt);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    //查询所有读者信息
    public List<Reader> readerSelectAll(){
        List<Reader> readers = null;
        try {
            Connection conn = JDBCUtils.getConnection();
            String sql = "select * from reader";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            readers = new ArrayList<>();
            while (rs.next()) {
                String userName = rs.getString(1);
                String rdType = rs.getString(2);
                String rdName = rs.getString(3);
                String rdDept = rs.getString(4);
                String rdQQ = rs.getString(5);
                Integer rdBorrowQty = rs.getInt(6);
                boolean power = rs.getBoolean(7);
                Reader reader = new Reader(userName, rdType, rdName, rdDept, rdQQ, rdBorrowQty, power);
                readers.add(reader);
            }
            JDBCUtils.close(rs, conn, pstmt);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return readers;          //return后的语句不执行
    }
}


