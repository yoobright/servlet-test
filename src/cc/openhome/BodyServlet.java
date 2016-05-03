package cc.openhome;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created yoobright zx on 2016/4/22.
 */
@WebServlet(value = "/body.view", name = "BodyServlet")
public class BodyServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String body = readBody(request);
    String contentType = request.getContentType();
    String boundaryText = contentType.substring(
        contentType.lastIndexOf("=") + 1, contentType.length());
    PrintWriter out  = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Servlet BodyView</title>");
    out.println("<head>");
    out.println("<body>");
    out.println(body);
    out.println("<br>");
    out.println("----------");
    out.println("<br>");
    out.println("contentType: " + contentType);
    out.println("<br>");
    out.println("boundaryText: " + boundaryText);
    out.println("<br>");
    out.println("</body>");
    out.println("</html>");

    out.close();

  }

  private String readBody(HttpServletRequest request) throws IOException {
    BufferedReader reader = request.getReader();
    String input = null;
    String requestBody = "";
    while ((input = reader.readLine()) != null) {
      requestBody = requestBody + input + "<br>";
    }
    return requestBody;
  }

//  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//  }
}
