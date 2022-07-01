package personal.delmore.servlet;

import com.google.gson.Gson;
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

@WebServlet("/returnServlet")
public class ReturnServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //获取数据
        String rgString = request.getParameter("borrow");
        String userName = GsonUtils.getParaFromJson(rgString, "userName");
        String bkName = GsonUtils.getParaFromJson(rgString, "bkName");
        String dateBorrow = GsonUtils.getParaFromJson(rgString, "dateBorrow");
        String dateLendPlan = GsonUtils.getParaFromJson(rgString, "dateLendPlan");
        String dateLendAct = GsonUtils.getParaFromJson(rgString, "dateLendAct");
        User user = new User();
        user.setUserName(userName);
        Book bk = new Book();
        bk.setBkName(bkName);
        //业务逻辑,rdQty--,bkQty++,删除borrow记录
        BookService bookService = new BookServiceImpl();
        BorrowService borrowService = new BorrowServiceImpl();
        ReaderService readerService = new ReaderServiceImpl();
        Book book = bookService.findBookByName(bk);
        String bkId = book.getId();
        Reader reader = readerService.findReader(user);
        Borrow borrow = new Borrow(userName, bkId, dateBorrow, dateLendPlan, dateLendAct);
        Integer rdBorrowQty = reader.getRdBorrowQty();
        reader.setRdBorrowQty(rdBorrowQty - 1);
        readerService.updateReader(reader);
        Integer bkQty = book.getBkQty();
        book.setBkQty(bkQty + 1);
        bookService.updateBook(book);
        borrowService.updateLendAct(borrow);
        response.getWriter().print("true");
    }
}