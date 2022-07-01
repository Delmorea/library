package personal.delmore.servlet;

import personal.delmore.entity.Borrow;
import personal.delmore.entity.User;
import personal.delmore.service.BorrowService;
import personal.delmore.service.BorrowServiceImpl;
import personal.delmore.utils.GsonUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/recordServlet")
public class RecordServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //设置编码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String rgString = request.getParameter("user");
        String userName = GsonUtils.getParaFromJson(rgString, "userName");
        User user = new User(userName, null);
        //获取借阅记录
        BorrowService borrowService = new BorrowServiceImpl();
        List<Borrow> records = borrowService.getRecord(user);
        String recordList = GsonUtils.listToJson(records);
        //数据回显
        response.getWriter().print(recordList);
    }
}

