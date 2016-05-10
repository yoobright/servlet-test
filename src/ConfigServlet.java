import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yoobright on 2016/5/10.
 */
@WebServlet(
    name = "ConfigServlet",
    urlPatterns = {"/login.do"},
    initParams = {
        @WebInitParam(name = "SUCCESS", value = "success.vew"),
        @WebInitParam(name = "ERROR", value = "error.view")
    }
)
public class ConfigServlet extends HttpServlet {
  private String SUCCESS_VIEW;
  private String ERROR_VIEW;

  @Override
  public void init() throws ServletException {
    SUCCESS_VIEW = getInitParameter("SUCCESS");
    ERROR_VIEW = getInitParameter("ERROR");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    String name = request.getParameter("name");
    String passwd = request.getParameter("passwd");
    System.out.println(name);
    System.out.println(passwd);
    System.out.println(SUCCESS_VIEW);
    System.out.println(ERROR_VIEW);
    if ("admin".equals(name) && "123456".equals(passwd)) {
      request.getRequestDispatcher("success.html").forward(request, response);
    } else {
      request.getRequestDispatcher("error.html").forward(request,response);
    }
  }

//  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//  }
}
