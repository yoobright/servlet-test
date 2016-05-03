package cc.openhome;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by yoobright on 2016/4/26.
 */
@WebServlet(name = "FileServlet", value = "/file")
public class FileServlet extends HttpServlet {

  private static final Logger LOGGER = LogManager.getLogger(FileServlet.class);
//  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");

    ServletContext context = getServletContext();
    Set<String> fileSet = context.getResourcePaths("/");
//    List<String> fileList = new ArrayList<String>(fileSet);
//    URL myfileURLs = context.getResource("/");
    Set<String> fileURLs = fileSet.stream().map(x -> {
      try {
        return context.getResource(x).toString();
      } catch (MalformedURLException e) {
        e.printStackTrace();
      }
    return null;}).collect(Collectors.toSet());

    Set<String> fileRealPaths =
        fileSet.stream().map(context::getRealPath).collect(Collectors.toSet());

    Set<String> filterPaths = fileSet.stream().
        filter(x -> (x.endsWith(".html") || x.endsWith(".jsp"))).
        collect(Collectors.toSet());

    PrintWriter out = response.getWriter();

    LOGGER.debug("debug message");
    LOGGER.info("information message");
    LOGGER.warn("waring message");

    out.println("<html>");
    out.println("<head>");
    out.println("<title>文件</title>");
    out.println("<body>");
    out.println("文件：");

    out.println("<ul>");
    for (String file: fileSet) {
      out.println("<li>" + file + "</li>");
    }
    out.println("</ul>");

    out.println("<ul>");
    for (String url: fileURLs) {
      out.println("<li>" + url + "</li>");
    }
    out.println("</ul>");

    out.println("</ul>");
    out.println("<ul>");
    for (String fPath: filterPaths) {
      out.println("<li>" + fPath + "</li>");
    }
    out.println("</ul>");

        out.println("</ul>");
    out.println("<ul>");
    for (String real: fileRealPaths) {
      out.println("<li>" + real + "</li>");
    }
    out.println("</ul>");

    out.println("</body>");
    out.println("</html>");
    out.close();
  }
}
