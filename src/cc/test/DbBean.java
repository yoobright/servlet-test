package cc.test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;


public class DbBean implements Serializable {
  private DataSource dataSource;

  public DbBean() {
    try {
      Context initContext = new InitialContext();
      Context envContext = (Context) initContext.lookup("java:/comp/env");
      dataSource = (DataSource) envContext.lookup("jdbc/demo");
    } catch (NamingException e) {
      throw new RuntimeException(e);
    }
  }

  public boolean isConnectionOK(){
    boolean ok = false;
    Connection conn = null;
    SQLException ex = null;
    try{
      conn = dataSource.getConnection();
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

  public DataSource getDataSource() {
    return dataSource;
  }

  public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;
  }
}
