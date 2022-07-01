package personal.delmore.servlet;

import personal.delmore.entity.User;
import personal.delmore.service.ReaderService;
import personal.delmore.service.ReaderServiceImpl;
import personal.delmore.service.UserService;
import personal.delmore.service.UserServiceImpl;
import personal.delmore.utils.GsonUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //设置UTF-8编码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //从安卓获取数据
        String gString = request.getParameter("user");
        String psword = GsonUtils.getParaFromJson(gString, "psword");
        User user = GsonUtils.getBean(gString, User.class);

        ReaderService readerService = new ReaderServiceImpl();
        UserService userService = new UserServiceImpl();
        if ((readerService.adjustUsername(user)) && (!userService.adjustId(user)) && (user.getPassword().equals(psword))) {
            userService.addUser(user);
            response.getWriter().print("true");
        } else {
            response.getWriter().print("false");
         /*       request.setAttribute("errorMst","用户名存在或密码输入错误");
                request.getRequestDispatcher("/index.jsp").forward(request,response);*/
        }
    }
}