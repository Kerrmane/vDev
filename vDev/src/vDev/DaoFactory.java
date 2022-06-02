package vDev;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {
    private String url;
    private String username;
    private String password;

  

    public static Connection getConnection() throws SQLException {
    	try {
    		return DriverManager.getConnection("jdbc:mysql://localhost:3306/cashcash", "root", "");
    		
    	}
    	catch(Exception e) {
    		return (Connection) e ;
    	}
        
    }

    
    
}
