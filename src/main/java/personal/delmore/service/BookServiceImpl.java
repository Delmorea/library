package personal.delmore.service;

import personal.delmore.dao.BookDao;
import personal.delmore.dao.BookDaoImpl;
import personal.delmore.entity.Book;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @projectName: IDEA-workspace
 * @package: personal.delmore.service
 * @className: BookService
 * @author: Delmore
 * @description: 对图书的操作
 * @date: 2022/3/24 19:38
 * @version: 1.0
 */

public class BookServiceImpl implements BookService {
    private final BookDao bookDao = new BookDaoImpl();
    List<Book> list = selectAllBook();

    public BookServiceImpl() {
    }

    /**
     * @param :
     * @return void
     * @author 86176
     * @description 增删改查
     * @date 2022/4/29 8:29
     */
    public void addBook(Book book) {
        bookDao.bookAdd(book);
    }

    public void deleteBook(Book book) {
        bookDao.bookDelete(book);
    }

    public void updateBook(Book book) {
        bookDao.bookUpdate(book);
    }

    public List<Book> selectAllBook() {
        return bookDao.bookSelectAll();
    }

    //通过书名查找书
    public Book findBookByName(Book book) {
        List<String> bkName = list.stream().map(Book::getBkName).collect(Collectors.toList());
        for (int i = 0; i < list.size(); i++) {
            if (bkName.get(i).equals(book.getBkName())) {
                return list.get(i);
            }
        }
        return null;
    }

    //通过Id查找书
    public Book findBookById(Book book) {
        List<String> bkId = list.stream().map(Book::getId).collect(Collectors.toList());
        for (int i = 0; i < list.size(); i++) {
            if (bkId.get(i).equals(book.getId())) {
                return list.get(i);
            }
        }
        return null;
    }
}
