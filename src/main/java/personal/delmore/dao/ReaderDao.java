package personal.delmore.dao;

import personal.delmore.entity.Reader;

import java.sql.SQLException;
import java.util.List;

public interface ReaderDao {
    void readerAdd(Reader reader); //增加用户

    void readerDelete(Reader reader);        //删除用户

    void readerUpdate(Reader reader);          //更新用户

    List<Reader> readerSelectAll();         //查询所有用户信息，并返回List集合
}
