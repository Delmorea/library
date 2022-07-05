package personal.delmore.servlet;

import personal.delmore.entity.Reader;
import personal.delmore.entity.User;
import personal.delmore.service.ReaderService;
import personal.delmore.service.ReaderServiceImpl;
import personal.delmore.utils.GsonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/moreServlet")
public class MoreServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //获取user,找到对应的reader
        String rgString = request.getParameter("user");
        String userName = GsonUtils.getParaFromJson(rgString, "userName");
        User user = new User(userName, null);
        ReaderService readerService = new ReaderServiceImpl();
        Reader reader = readerService.findReader(user);
        String sgString = GsonUtils.beanToJson(reader);
        //数据回显
        response.getWriter().print(sgString);
    }
}

