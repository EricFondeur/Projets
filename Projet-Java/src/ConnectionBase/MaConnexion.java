package ConnectionBase;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class MaConnexion {
	  Connection conn=null;

	    public static Connection dbConnector() {
	        try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/projet_java", "root", "");
	        return conn;
	        } catch(Exception e) {
	            JOptionPane.showMessageDialog(null, e);
	            return null;
	        }
	    }
}
