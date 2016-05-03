import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by yoobright on 2016/5/3.
 */
@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=utf-8");
    PrintWriter pw = response.getWriter();
    pw.println("<html>");
    pw.println("<body>");
    pw.println("<hl>Login</hl><br>");
    pw.println("<form action=loginCK method=post>");
    pw.println("User:<input type=text name=username> <br>");
    pw.println("Passwd:<input type=password name=password> <br>");
    pw.println("<input type=checkbox name=keep value=2>remember me <br>");  //增加复选框
    pw.println("<input type=submit value=Login> <br>");
    pw.println("</form>");
    pw.println("</body>");
    pw.println("</html>");
  }
}
