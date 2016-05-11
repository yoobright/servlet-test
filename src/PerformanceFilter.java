import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by yoobright on 2016/5/11.
 */
@WebFilter(filterName = "PerformanceFilter", urlPatterns = {"/*"})
public class PerformanceFilter implements Filter {
  private FilterConfig config;

  @Override
  public void destroy() {
  }

  @Override
  public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
    long begin = System.currentTimeMillis();
    chain.doFilter(req, resp);
    config.getServletContext().log("Request process in " +
        (System.currentTimeMillis() - begin) + " milliseconds");
  }

  @Override
  public void init(FilterConfig config) throws ServletException {
    this.config = config;
  }

}
