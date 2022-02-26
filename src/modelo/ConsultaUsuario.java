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
	        String sql = "SELECT * FROM empleados WHERE cedula_empleado='"+cedula+"' ";
	        
	        try{
	           
	           ps = con.prepareStatement(sql);
	           rs = ps.executeQuery();
	           
	           
	           if(rs.next()){
	        	   
	        	   usuario.setId(rs.getInt("cedula_empleado"));
	        	   usuario.setPassword(rs.getString("password_empleado"));
	        	   usuario.setCargo(rs.getString("cargo_empleado"));
	        	   usuario.setNombre(rs.getString("nombre_empleado"));
	        	   usuario.setTelefono(rs.getString("contacto_empleado"));
	        	   usuario.setFechaNacimiento(rs.getDate("fecha_nacimiento_empleado"));
	        	   
	        	   
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
	        String sql = "SELECT * FROM empleados WHERE cedula_empleado='"+idUsu+"'";
	        
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
				String cargo = usuario.getCargo();
				String password = usuario.getPassword();
				Date fechaNacimiento = usuario.getFechaNacimiento();
			
				
				
				
				Connection con = getConnection();
		        String sql = "INSERT INTO empleados (cedula_empleado, password_empleado, cargo_empleado, nombre_empleado, contacto_empleado, fecha_nacimiento_empleado)"
		        		+ "values ('"+ident+"', '"+password+"','"+cargo+"','"+nombre+"','"+telefono+"','"+fechaNacimiento+"')";
		        
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
	        String sql = "DELETE from empleados WHERE cedula_empleado='"+idUsu+"'";
	        
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
			String nombre = usuario.getNombre();
			String telefono = usuario.getTelefono();
			String cargo = usuario.getCargo();
			String password = usuario.getPassword();
			Date fechaNacimiento = usuario.getFechaNacimiento();
					
			Connection con = getConnection();
				
			String sql = "UPDATE empleados SET cedula_empleado='"+id+"',password_empleado='"+password+"',cargo_empleado='"+cargo+"',nombre_empleado='"+nombre+"',contacto_empleado='"+telefono+"',fecha_nacimiento_empleado='"+fechaNacimiento+"' WHERE cedula_empleado='"+id+"'";
			        	
				
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
	        String sql = "SELECT * FROM empleados";
	        
	        try{
	        	Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				
	           
	           while(rs.next()){
	        	   
	        	int cedula = rs.getInt("cedula_empleado");   
	        	String password = rs.getString("password_empleado");
	        	String cargo = rs.getString("cargo_empleado");
	        	String nombre = rs.getString("nombre_empleado");
	        	String contacto = rs.getString("contacto_empleado");
	        	Date dateObject = rs.getDate("fecha_nacimiento_empleado");
	        	
	        	Object tbData[] = {cedula, nombre, contacto, cargo, password, dateObject};
	        	
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
