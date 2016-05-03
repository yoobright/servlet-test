import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Objects;

/**
 * Created by yoobright on 2016/5/3.
 */
@WebServlet(name = "LoginCKServlet", value = "/loginCK")
public class LoginCKServlet extends HttpServlet {

  private static final Logger LOGGER = LogManager.getLogger(LoginCKServlet.class);

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      //接收用户名和密码
      String username = request.getParameter("username");
      String password = request.getParameter("password");
      LOGGER.info("username: " + username);
      LOGGER.info("password: " + password);

      if (Objects.equals(username, "admin") && Objects.equals(password, "admin"))   //如果用户合法
      {
        String keep = request.getParameter("keep"); //复选框是否被选中
        if (keep != null)  //如果复选框选中则创建Cookie，令用户两周内不必登录
        {
          //cookie
          Cookie name = new Cookie("myname", username);
          Cookie passwd = new Cookie("passwd", password);
          name.setMaxAge(60);
          passwd.setMaxAge(60);
          response.addCookie(name);
          response.addCookie(passwd);
        }

        //为了用户名和密码的安全性，以Session的方式传递这两个值
        HttpSession hs = request.getSession(true);
        hs.setMaxInactiveInterval(30);
        hs.setAttribute("uname", username);
        hs.setAttribute("pass", password);
        response.sendRedirect("Wel");

      } else {
        response.sendRedirect("login");//写需要跳转的servlet的那个url
      }

    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
