package personal.delmore.dao;

import personal.delmore.entity.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {
    void bookAdd(Book book);                   //增加图书

    void bookDelete(Book book);           //删除图书

    void bookUpdate(Book book);             //更新图书

    List<Book> bookSelectAll();                //查询所有用户信息，并返回List集合
}
