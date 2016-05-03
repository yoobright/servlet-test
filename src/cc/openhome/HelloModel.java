package cc.openhome;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yoobright on 2016/4/26.
 */
public class HelloModel {
  private Map<String, String> messages = new HashMap<String, String>();

  public HelloModel() {
    messages.put("caterpillar", "hello");
    messages.put("justin", "welcome");
    messages.put("david", "hi");
  }

  public String doHello(String user){
    String message = messages.get(user);
    return message + ", " + user + "!";
  }

}
