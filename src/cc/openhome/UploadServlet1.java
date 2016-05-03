package cc.openhome;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by yoobright on 2016/4/25.
 */
@MultipartConfig
@WebServlet(value ="/upload1.do",name = "UploadServlet1")
public class UploadServlet1 extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Part part = request.getPart("uploadfile");
    String filename = getFileName(part);
    writeTo(filename, part);

  }

  private void writeTo(String filename, Part part) throws IOException {
    InputStream in = part.getInputStream();
    OutputStream out = new FileOutputStream("D:/" + filename);
    byte[] buffer = new byte[1024];
    int length = -1;
    while ((length = in.read(buffer)) != -1) {
      out.write(buffer, 0, length);
    }
    in.close();
    out.close();
  }

  private String getFileName(Part part) {
    String header = part.getHeader("Content-Disposition");
    String filename = header.substring(header.indexOf("filename=\"") +10,
        header.lastIndexOf("\""));
    return filename;
  }

//  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//  }
}
