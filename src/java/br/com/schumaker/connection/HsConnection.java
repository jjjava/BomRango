package br.com.schumaker.connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hudson schumaker HStudio - @BomRango 07/01/2015
 * @version 1.0.0
 * @since 1.0.0
 */
public class HsConnection {

    public static synchronized Connection getConnection() {
        Connection conn = null;
        try {
            
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
        } catch (SQLException ex) {
            System.err.println(ex);
        } catch (InstantiationException ex) {
            System.err.println(ex);
        } catch (IllegalAccessException ex) {
            System.err.println(ex);
        }
        return conn;
    }
}
