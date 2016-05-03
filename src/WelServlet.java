import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by yoobright on 2016/5/3.
 */
@WebServlet(name = "WelServlet", value = "/Wel")
public class WelServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {

      PrintWriter pw = response.getWriter();
      //获取Session中信息
      HttpSession hs = request.getSession(true);
      String name = (String) hs.getAttribute("uname");
      String pass = (String) hs.getAttribute("passwd");
      if (name == null) {   //判断直接访问欢迎界面的用户是否合法（session没有用户名，不是从登录界面进入的）
        String cname = "";
        String cpasswd = "";
        Cookie[] allCookies = request.getCookies();  //获取Cookie
        if (allCookies != null) {
          for (Cookie temp : allCookies) {
            if (temp.getName().equals("myname")) {
              cname = temp.getValue();  //获得cookie中的用户名和密码
            } else if (temp.getName().equals("passwd")) {
              cpasswd = temp.getValue();
            }
          }
          if (!cname.equals("") && !cpasswd.equals(""))   //获取用户名和密码之后将其送至用户验证部分，验证其合法性
          {
            response.sendRedirect("loginCK?username=" + cname + "&password=" + cpasswd);
            return;
          }
        }
        response.sendRedirect("login");   //直接登录欢迎界面且cookie中无值，跳转登录界面
      }

      pw.println("Welcome!" + name);

    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
