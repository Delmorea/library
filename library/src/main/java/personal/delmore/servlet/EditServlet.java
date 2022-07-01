package personal.delmore.servlet;

import net.sf.json.JSONObject;
import personal.delmore.entity.Reader;
import personal.delmore.entity.User;
import personal.delmore.service.ReaderService;
import personal.delmore.service.ReaderServiceImpl;
import personal.delmore.service.UserService;
import personal.delmore.service.UserServiceImpl;
import personal.delmore.utils.GsonUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/editServlet")
public class EditServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String rgString = request.getParameter("reader");
        User user = getUser(rgString);
        Reader reader = getReader(rgString);

        ReaderService readerService=null;
        UserService userService = null;
        try {
            userService = new UserServiceImpl();
            readerService=new ReaderServiceImpl();
            if (readerService.adjustReader(user,reader)){
                userService.updateUser(user);
                readerService.updateInform(reader);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("rdQQ",reader.getRdQQ());
                String sgString=String.valueOf(jsonObject);
                response.getWriter().print("true#"+sgString);
            }
            else response.getWriter().print("false");
            response.getWriter().flush();
            response.getWriter().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Reader getReader(String rgString) {
        Reader reader= null;
        try {
            String rdName=GsonUtils.getParaFromJson(rgString,"rdName");
            String QQ=GsonUtils.getParaFromJson(rgString,"rdQQ");
            String userName=GsonUtils.getParaFromJson(rgString,"userName");
            reader = new Reader(userName,null,rdName,null,QQ,null,false);
            System.out.println(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reader;
    }

    private User getUser(String rgString) {
        User user = null;
        try {
            String userName=GsonUtils.getParaFromJson(rgString,"userName");
            String password=GsonUtils.getParaFromJson(rgString,"password");
            user = new User(userName,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}

