import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

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
  private static final Logger LOGGER = LogManager.getLogger(ConfigServlet.class);

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
    LOGGER.info("name: " + name);
    LOGGER.info("passwd: " + passwd);
    LOGGER.info("SUCCESS_VIEW: " + SUCCESS_VIEW);
    LOGGER.info("ERROR_VIEW: " + ERROR_VIEW);

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
