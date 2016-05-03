package cc.openhome;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yoobright on 2016/4/26.
 */
@WebServlet(name = "HelloController", value = "/hello.do")
public class Servlet extends HttpServlet {
  private HelloModel model = new HelloModel();
//  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String name = request.getParameter("user");
    String message = model.doHello(name);
    System.out.println(message);
    request.setAttribute("message", message);
    request.getRequestDispatcher("hello.view").forward(request, response);
  }
}
