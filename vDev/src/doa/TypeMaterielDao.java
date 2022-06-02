package doa;


import vDev.Materiel;
import vDev.TypeMateriel;

import java.lang.reflect.Type;
import java.sql.*;






public class TypeMaterielDao {

    public static  TypeMateriel getTypeByRefInterne(String referenceInterne) throws ClassNotFoundException, SQLException{
        TypeMateriel mat = new TypeMateriel();


        Connection connexion = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        connexion = DriverManager.getConnection("jdbc:mysql:///cashcash", "root", "");

        PreparedStatement stt = connexion.prepareStatement("select * from type_materiel where Reference_Interne  = ?");
        stt.setString(1, referenceInterne);


        ResultSet resultSet = stt.executeQuery();

        while (resultSet.next()) {


            mat.setReferenceInterne(resultSet.getString("Reference_Interne"));
            mat.setLibelleTypeMateriel(resultSet.getString("Libelle_Type_Materiel"));
            //mat.setLaFamille(resultSet.getString("code_famille")); 




        }

        return mat;
    }
    public static void main(String[]args) throws SQLException, ClassNotFoundException {


    	

        System.out.println(getTypeByRefInterne("23455"));
        }
    }
