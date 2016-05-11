import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yoobright on 2016/5/11.
 */
@WebServlet(name = "AsyncServlet", urlPatterns = {"/async.do"},
    asyncSupported = true
)
public class AsyncServlet extends HttpServlet {
  private ExecutorService executorService = Executors.newFixedThreadPool(10);
//  @Override
//  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html; charset=UTF-8");
    AsyncContext ctx = request.startAsync();
    executorService.submit(new AsyncRequest(ctx));
  }

  @Override
  public void destroy() {

  }
}
