package cc.openhome;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by yoobright on 2016/4/26.
 */
@WebServlet(name = "PetServlet", value = "/pet")
public class PetServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");

    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>感谢填写</title>");
    out.println("<body>");
    out.println(request.getParameter("user") + "<br>");
    out.println("宠物");
    out.println("<ul>");
    for (String type: request.getParameterValues("type")) {
      out.println("<li>" + type + "</li>");
    }
    out.println("</ul>");
    out.println("</body>");
    out.println("</html>");
    out.close();
  }

//  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//  }
}
