package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConsultaUsuario extends Conexion{
	
	  public boolean buscar (Usuario usuario, int id){
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        Connection con = getConnection();
	        int cedula = id;
	        String sql = "SELECT * FROM usuarios WHERE id_usuario='"+cedula+"' ";
	        
	        try{
	           
	           ps = con.prepareStatement(sql);
	           rs = ps.executeQuery();
	           
	           
	           if(rs.next()){
	        	   
	        	   usuario.setId(rs.getInt("id_usuario"));
	        	   usuario.setPassword(rs.getString("contraseña"));
	        	   usuario.setNombre(rs.getString("nombre_usuario"));
	        	   usuario.setTelefono(rs.getString("contacto_usuario"));
	        	   
	               return true;
	           }else {
	        	   JOptionPane.showMessageDialog(null, "El numero de usuario no existe");
	        	   return false;
	           }
	           
	           
	        }catch(SQLException e) {
	            System.err.println(e);
	            return false;
	            
	        } finally{
	            try{
	                con.close();
	            }catch (SQLException e){
	                System.err.println(e);
	            }
	        }
	    }
	  
	  
	    public boolean confirmarExistenciaUsuario(int id){
	        
	    	int idUsu = id;
	        Connection con = getConnection();
	        String sql = "SELECT * FROM usuarios WHERE id_usuario='"+idUsu+"'";
	        
	        try{
	        	Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				System.out.println(rs+"este es el resultado de rs");
	           
	           if(rs.next()){
	        	   System.out.println("si existe el usuario");
	               return true;
	           }else {
	        	   System.out.println("no existe el usuario");
	               return false;
	           }
	           
	        }catch(SQLException e) {
	            System.err.println(e);
	            return false;
	        } finally{
	            try{
	                con.close();
	            }catch (SQLException e){
	                System.err.println(e);
	            }
	        }
	    }
	  
	  
		public boolean registrar(Usuario usuario){
			
			int ident = usuario.getId();
			
			if(confirmarExistenciaUsuario(ident) == false) {
			
				String nombre = usuario.getNombre();
				String telefono = usuario.getTelefono();
				String password = usuario.getPassword();
							
				Connection con = getConnection();
		        String sql = "INSERT INTO usuarios (id_usuario, contraseña, nombre_usuario, contacto_usuario)"
		        		+ "values ('"+ident+"', '"+password+"','"+nombre+"','"+telefono+"')";
		        
		        try{
		           
		        	 Statement st = con.createStatement();
		             int ejecucion = st.executeUpdate(sql);
		             
		            if(ejecucion != 0) {
		         	   JOptionPane.showMessageDialog(null, "Registro exitoso");
		         	   return true;
		            }else {
		         	   JOptionPane.showMessageDialog(null, "Registro fallido");
		         	   return false;
		            }
		           
		           
		        }catch(SQLException e) {
		            System.err.println(e);
		            return false;
		        } finally{
		            try{
		                con.close();
		            }catch (SQLException e){
		                System.err.println(e);
		            }
		        }
	        
			}else {
				 JOptionPane.showMessageDialog(null, "Registro fallido, el usuario ya existe");
				 return false;
			}
	        
	    }
		
		
	    public boolean eliminar(int id){
	        
	        Connection con = getConnection();
	        int idUsu = id;
	        String sql = "DELETE from usuarios WHERE id_usuario='"+idUsu+"'";
	        
	        try{
	        	Statement st = con.createStatement();
	            int ejecucion = st.executeUpdate(sql);
	            if(ejecucion != 0) {
	         	   JOptionPane.showMessageDialog(null, "Registro eliminado");
	         	   return true;
	            }else {
	         	   JOptionPane.showMessageDialog(null, "Error, no se elimino el registro");
	         	   return false;
	            }
	           
	        }catch(SQLException e) {
	            System.err.println(e);
	            return false;
	        } finally{
	            try{
	                con.close();
	            }catch (SQLException e){
	                System.err.println(e);
	            }
	        }
	    }
	    
	    
	    public boolean modificar(Usuario usuario){
	    	
	    	int id = usuario.getId();
	    	String password = usuario.getPassword();
			String nombre = usuario.getNombre();
			String telefono = usuario.getTelefono();
			
					
			Connection con = getConnection();
				
			String sql = "UPDATE usuarios SET id_usuario='"+id+"',contraseña='"+password+"',nombre_empleado='"+nombre+"',contacto_empleado='"+telefono+"' WHERE id_usuario='"+id+"'";
			        	
				
		        try{
		        	
		        	Statement st = con.createStatement();
		            int ejecucion = st.executeUpdate(sql);
		            
		            if(ejecucion != 0) {
		         	   JOptionPane.showMessageDialog(null, "Cambio exitoso");
		         	   return true;
		            }else {
		         	   JOptionPane.showMessageDialog(null, "Cambio fallido");
		         	   return false;
		            }
		           
		           
		        }catch(SQLException e) {
		            System.err.println(e);
		            return false;
		        } finally{
		            try{
		                con.close();
		            }catch (SQLException e){
		                System.err.println(e);
		            }
		        }
	        
	    	
	    }
	    
	    
	    public void poblarTabla(JTable table) {
	    	
	    	
	        Connection con = getConnection();
	        String sql = "SELECT * FROM usuarios";
	        
	        try{
	        	Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				
	           
	           while(rs.next()){
	        	   
	        	int cedula = rs.getInt("id_usuario");   
	        	String password = rs.getString("contraseña");
	        	String nombre = rs.getString("nombre_usuario");
	        	String contacto = rs.getString("contacto_usuario");
	        	
	        	Object tbData[] = {cedula, nombre, contacto, password};
	        	
	        	DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
	        	
	        	tblModel.addRow(tbData);
	           }
	        	
	           
	        }catch(SQLException e) {
	            System.err.println(e);

	        } finally{
	            try{
	                con.close();
	            }catch (SQLException e){
	                System.err.println(e);
	            }
	        }
	    	
	    }
							  

}
