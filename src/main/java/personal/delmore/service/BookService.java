package personal.delmore.service;

import personal.delmore.entity.Book;

import java.util.List;

public interface BookService {
    /**
     * @return void
     * @param: book
     * @author 86176
     * @description 对图书的增删改查
     * @date 2022/3/26 15:39
     */
    void addBook(Book book);

    void deleteBook(Book book);

    void updateBook(Book book);

    List<Book> selectAllBook();

    /**
     * @param :
     * @return Book
     * @author 86176
     * @description 通过书名或Id查找书
     * @date 2022/5/6 8:18
     */
    Book findBookByName(Book book);

    Book findBookById(Book book);
}
