package cc.test;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by yoobright on 2016/5/14.
 */
public class DbBean implements Serializable {
  private String jdbcUrl="jdbc:sqlite:test.sqlite";

  public DbBean() {
    try {
      Class.forName("org.sqlite.JDBC");
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  public boolean isConnectionOK(){
    boolean ok = false;
    Connection conn = null;
    SQLException ex = null;
    try{
      conn = DriverManager.getConnection(jdbcUrl);
      if (!conn.isClosed()){
        ok = true;
      }
    } catch (SQLException e) {
      ex = e;
    } finally {
      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException e) {
          if (ex == null){
            ex = e;
          }
        }
      }
      if (ex != null) {
        throw new RuntimeException(ex);
      }
    }
    return ok;
  }

  public String getJdbcUrl() {
    return jdbcUrl;
  }

  public void setJdbcUrl(String jdbcUrl) {
    this.jdbcUrl = jdbcUrl;
  }
}
