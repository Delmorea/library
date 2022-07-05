package personal.delmore.servlet;

import com.google.gson.Gson;
import personal.delmore.entity.Book;
import personal.delmore.entity.Borrow;
import personal.delmore.entity.Reader;
import personal.delmore.entity.User;
import personal.delmore.service.*;
import personal.delmore.utils.GsonUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //设置编码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //获取数据
        String rgString = request.getParameter("user");
        User user = new Gson().fromJson(rgString, User.class);
        //调用service，实现业务逻辑
        BorrowService borrowService = new BorrowServiceImpl();
        UserService userService = new UserServiceImpl();
        ReaderService readerService = new ReaderServiceImpl();
        BookService bookService = new BookServiceImpl();
        List<Borrow> record = borrowService.getRecord(user);
        String recordList = GsonUtils.listToJson(record);
        Reader reader = readerService.findReader(user);
        int lendDay = readerService.getLendDay(reader);
        List<Book> books = bookService.selectAllBook();
        String bks = GsonUtils.listToJson(books);
        //判断用户是否存在
        if (userService.adjustUser(user)) {
            System.out.println("yes");
//            response.getWriter().println("欢迎【" + reader.getRdName() + "】用户登录成功！！！");
            response.getWriter().print("true#" + reader.isPower() + "#" + lendDay + "#" + bks + "#" + recordList);
        } else {
            System.out.println("no");
/*                request.setAttribute("errorMsg","用户名或密码错误");
                request.getRequestDispatcher("/index.jsp").forward(request,response);*/
            response.getWriter().print("false");
        }
        response.getWriter().flush();
        response.getWriter().close();
    }
}