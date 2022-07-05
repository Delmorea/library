package personal.delmore.servlet;

import com.google.gson.Gson;
import personal.delmore.dao.BookDaoImpl;
import personal.delmore.entity.Book;
import personal.delmore.entity.Borrow;
import personal.delmore.entity.Reader;
import personal.delmore.entity.User;
import personal.delmore.service.*;
import personal.delmore.utils.GsonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/borrowServlet")
public class BorrowServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //设置编码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //获取数据
        String rgString = request.getParameter("borrow");
        Borrow borrow = GsonUtils.getBean(rgString, Borrow.class);
        String userName = GsonUtils.getParaFromJson(rgString, "userName");
        String bkID = GsonUtils.getParaFromJson(rgString, "bkId");
        Book book = new Book();
        book.setId(bkID);
        User user = new User();
        user.setUserName(userName);
        //调用service，实现业务逻辑
        BookService bookService = new BookServiceImpl();
        ReaderService readerService = new ReaderServiceImpl();
        BorrowService borrowService = new BorrowServiceImpl();
        book = bookService.findBookById(book);
        Reader reader = readerService.findReader(user);
        int lendQty = readerService.getLendQty(reader);
        if (reader.getRdBorrowQty() >= lendQty) {
            response.getWriter().print("0");
        } else if (book.getBkQty() == 0) {
            response.getWriter().print("1");
        } else {
            //借阅成功，readerQty++，bkQty--
            Integer rdBorrowQty = reader.getRdBorrowQty();
            reader.setRdBorrowQty(rdBorrowQty + 1);
            readerService.updateReader(reader);
            Integer bkQty = book.getBkQty();
            book.setBkQty(bkQty - 1);
            bookService.updateBook(book);
            borrowService.addBorrow(borrow);
            response.getWriter().print("true");
        }
    }
}