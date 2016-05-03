package cc.openhome;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

/**
 * Created by yoobright on 2016/4/25.
 */
@MultipartConfig(location = "D:/")
@WebServlet(value ="/upload2.do", name = "UploadServlet2")
public class UploadServlet2 extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    Part part = request.getPart("uploadfile");
    String filename = getFilename(part);
    part.write(filename);
  }

  private String getFilename(Part part) {
    String header = part.getHeader("Content-Disposition");
    String filename = header.substring(header.indexOf("filename=\"") + 10,
        header.lastIndexOf("\""));
    return filename;
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
