package personal.delmore.dao;

import personal.delmore.entity.Reader;
import personal.delmore.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @projectName: IDEA-workspace
 * @package: personal.delmore.dao
 * @className: RdTypeDaoImpl
 * @author: Delmore
 * @description: TODO
 * @date: 2022/3/26 17:34
 * @version: 1.0
 */
public class RdTypeDaoImpl implements RdTypeDao {
    //获取可借数量
    public int getLendQty(Reader reader) {
        Integer canLendQty = null;
        try {
            Connection conn = JDBCUtils.getConnection();
            String rdType = reader.getRdType();
            String sql = "select * from readerType where rdType=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, rdType);
            canLendQty = 0;
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                canLendQty = rs.getInt(2);
            }
            JDBCUtils.close(rs, conn, pstmt);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return canLendQty;          //return后的语句不执行
    }

    //获取可接天数
    public int getLendDay(Reader reader) {
        Integer canLendDay = 0;
        try {
            Connection conn = JDBCUtils.getConnection();
            String rdType = reader.getRdType();
            String sql = "select * from readerType where rdType=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, rdType);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                canLendDay = rs.getInt(3);
            }
            JDBCUtils.close(rs, conn, pstmt);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return canLendDay;          //return后的语句不执行
    }
}
