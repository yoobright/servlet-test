import javax.servlet.AsyncContext;
import java.io.PrintWriter;

/**
 * Created by yoobright on 2016/5/11.
 */
public class AsyncRequest implements Runnable {
  private AsyncContext ctx;

  public AsyncRequest(AsyncContext ctx) {
    this.ctx = ctx;
  }

  @Override
  public void run() {
    try {
      Thread.sleep(10000);
      PrintWriter out = ctx.getResponse().getWriter();
      out.println("done......");
      ctx.complete();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }
}
