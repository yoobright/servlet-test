import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by yoobright on 2016/5/3.
 */
@WebServlet(name = "QuestionnaireServlet", value = "/qu")
public class QuestionnaireServlet extends HttpServlet {
  protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Questionnaire</title>");
    out.println("</head>");
    out.println("</html>");
    out.println("<body>");
    String page = request.getParameter("page");
    out.println("<form action='qu' method='post'>");
    if (page == null) {
      out.println("问题1： <input type='text' name='p1q1'><br>");
      out.println("问题2： <input type='text' name='p1q2'><br>");
      out.println("<input type='submit' name='page' value='下一页'>");
    } else if ("下一页".equals(page)) {
      String p1q1 = request.getParameter("p1q1");
      String p1q2 = request.getParameter("p1q2");
      HttpSession session = request.getSession();
      session.setAttribute("p1q1", p1q1);
      session.setAttribute("p1q2", p1q2);
      out.println("问题3： <input type='text' name='p2q1'><br>");
      out.println("<input type='submit' name='page' value='完成'>");
    } else if ("完成".equals(page)) {
      HttpSession session = request.getSession();
      out.println(session.getAttribute("p1q1") + "<br>");
      out.println(session.getAttribute("p1q2") + "<br>");
      out.println(request.getParameter("p2q1") + "<br>");
    }
    out.println("</form>");
    out.println("</body>");

  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    processRequest(request,response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    processRequest(request,response);
  }
}
