package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	
 	private final String host = "castor.db.elephantsql.com";
 	private final String database = "xkdnfcrd";
 	private final String user = "xkdnfcrd";
 	private final String password = "wYGGfLf_hzzASbKfDsZuFw9-NJA5MvYR";
   
    
    private Connection con = null;
    
    
    // obtiene la conexion la guarda y luego la retorna
    public Connection getConnection(){
        
        try{
            //controlador para realizar la conexion
            //Class.forName("com.postgres.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://"+host+":5432/"+database, user, password);
            
            if(con != null) {
            System.out.println("Conexion a base de datos OK");
            }
            
            
        } catch(Exception e) {
        	System.out.println("Error al conectar a la base de datos");
        	e.printStackTrace();
        }//finally {
        	return con;
       // }
            
         
    }

}

