package doa;

import java.awt.AWTException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vDev.Famille;

public class FamilleDao {
	  public static Famille getFamilleByCodeFamille(String codeFamille) throws ClassNotFoundException, SQLException {
		  Famille mat = new Famille();


		  Connection connexion = null;
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  connexion = DriverManager.getConnection("jdbc:mysql:///cashcash", "root", "");

		  PreparedStatement stt = connexion.prepareStatement("select * from famille where codeFamille  = ?");
		  stt.setString(1, codeFamille);


		  ResultSet resultSet = stt.executeQuery();

		  while (resultSet.next()) {


		      mat.setCodeFamille(resultSet.getString("codeFamille"));
		      mat.setLibelleFamille(resultSet.getString("libelle"));
		      //mat.setCodeFamille(resultSet.getString("code_famille"));
		      
		      

		  
  } 
		  return mat;
          



          

          
      }
      public static void main(String[]args) throws SQLException, ClassNotFoundException {




          System.out.println(FamilleDao.getFamilleByCodeFamille("SE").toString());
      }

}
