package personal.delmore.dao;

import personal.delmore.entity.Borrow;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface BorrowDao {
    void borrowAdd(Borrow borrow);         //增加借阅记录

    List<Borrow> borrowSelectAll();        //查询所有借阅记录，并返回一个List集合(对象数组)

    void borrowUpdate(Borrow borrow);     //更新借阅记录

    void borrowDelete(Borrow borrow);   //删除借阅记录
}
