package vDev;

import java.sql.Connection;
import java.sql.DriverManager;

public class PersistanceSQL {
	
	static Connection con=null;
	public static Connection persistanceSQL(String ipBase , int port ,String nomBasedonee , String user , String mdp)  {
	    	
	    	con =null;
	    	
	    	try {
	    		String p= Integer.toString(port);
	    		String url=ipBase+p+nomBasedonee;
	    		con = DriverManager.getConnection(url,user, mdp);
	    				
	    		if(con!=null) {
	    			//System.out.println("true");
	    			
		            	
	    		}
	    	
	    		} catch (Exception e ) {
	    			System.out.println("false");
	    			e.printStackTrace();
	    			
	    			
	    		}
			return con ;
	      
	        
	        }
	    

}
