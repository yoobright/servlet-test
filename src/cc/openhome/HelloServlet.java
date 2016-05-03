package cc.openhome;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/hello.view",name = "HelloServlet")
public class HelloServlet extends HttpServlet{
  private String htmlTemplate =
      "<html>"
          + "<head>"
          + "<meta http-equiv=\"Content-Type\" content=\"text/html; harset=UTF-8\">"
          + "<title>%s</title>"
          + "</head>"
          + "<body>"
          + "<h1>%s</h1>"
          + "</body>"
          + "</html>";

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String user = req.getParameter("user");
    String message = (String) req.getAttribute("message");
    String html = String.format(htmlTemplate, user, message);
    resp.getWriter().print(html);
  }
}

