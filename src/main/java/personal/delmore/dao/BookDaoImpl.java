package personal.delmore.dao;

import personal.delmore.utils.JDBCUtils;
import personal.delmore.entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    public void bookAdd(Book book) {
        try {
            String Id=book.getId();
            String bkName= book.getBkName();
            String bkAuthor= book.getBkAuthor();
            String bkPress=book.getBkPress();
            double bkPrice=book.getBkPrice();
            Integer bkQty=book.getBkQty();
            String bkURL=book.getBkURL();
            String bkIntro = book.getBkIntro();

            //获取连接
            Connection conn= JDBCUtils.getConnection();
            String sql = "insert into book values (?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Id);
            pstmt.setString(2,bkName);
            pstmt.setString(3,bkAuthor);
            pstmt.setString(4,bkPress);
            pstmt.setDouble(5,bkPrice);
            pstmt.setInt(6,bkQty);
            pstmt.setString(7,bkURL);
            pstmt.setString(8,bkIntro);

            int result = pstmt.executeUpdate();
            if(result > 0) {
                System.out.println("添加成功!");
            }
            JDBCUtils.close(null,conn,pstmt);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void bookDelete(Book book) {
        try {
            Connection conn = JDBCUtils.getConnection();
            String bkName = book.getBkName();
            String sql = "delete from book where bkName = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,bkName);
            int result = pstmt.executeUpdate();
            if(result > 0) {
                System.out.println("删除成功!");
            } else {
                System.out.println("删除失败!");
            }
            JDBCUtils.close(null,conn,pstmt);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void bookUpdate(Book book) {
        try {
            Connection conn = JDBCUtils.getConnection();
            String Id=book.getId();
            String bkName= book.getBkName();
            String bkAuthor= book.getBkAuthor();
            String bkPress=book.getBkPress();
            double bkPrice=book.getBkPrice();
            Integer bkQty=book.getBkQty();
            String bkURL=book.getBkURL();
            String bkIntro = book.getBkIntro();


            String sql = "update book set bkID=?,bkAuthor=?,bkPress=?,bkPrice=?,bkQty=?,bkURL=?,bkIntro=? where bkName=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Id);
            pstmt.setString(2,bkAuthor);
            pstmt.setString(3,bkPress);
            pstmt.setDouble(4,bkPrice);
            pstmt.setInt(5,bkQty);
            pstmt.setString(6,bkURL);
            pstmt.setString(7,bkIntro);
            pstmt.setString(8,bkName);

            pstmt.executeUpdate();
            JDBCUtils.close(null,conn,pstmt);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

//查询所有
    public List<Book> bookSelectAll() {
        List<Book> books= null;
        try {
            Connection conn = JDBCUtils.getConnection();
            String sql = "select * from book";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            books = new ArrayList<Book>();
            while (rs.next()) {
                String id = rs.getString(1);
                String bkName = rs.getString(2);
                String bkAuthor = rs.getString(3);
                String bkPress = rs.getString(4);
                double bkPrice = rs.getDouble(5);
                Integer bkQty=rs.getInt(6);
                String bkURL=rs.getString(7);
                String bkIntro = rs.getString(8);
                Book book = new Book(id,bkName,bkAuthor,bkPress,bkPrice,bkQty,bkURL,bkIntro);
                books.add(book);
            }
            JDBCUtils.close(rs,conn,pstmt);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return books;          //return后的语句不执行
    }
}
