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

public class ConsultaCliente extends Conexion {
	
	  public boolean buscar (Cliente cliente, int id){
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        Connection con = getConnection();
	        int cedula = id;
	        String sql = "SELECT * FROM cliente WHERE cedula_cliente='"+cedula+"' ";
	        
	        try{
	           
	           ps = con.prepareStatement(sql);
	           rs = ps.executeQuery();
	           
	           
	           if(rs.next()){
	        	   
	        	   cliente.setId(rs.getInt("cedula_cliente"));	  
	        	   cliente.setNombre(rs.getString("nombre_cliente"));
	        	   cliente.setTelefono(rs.getString("contacto_cliente"));
	        	   cliente.setFechaNacimiento(rs.getDate("fecha_nacimiento_cliente"));
	        	   
	        	   
	               return true;
	           }else {
	        	   JOptionPane.showMessageDialog(null, "El numero de cliente no existe");
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
	  
	  
	    public boolean confirmarExistenciaCliente(int id){
	        
	    	int idUsu = id;
	        Connection con = getConnection();
	        String sql = "SELECT * FROM cliente WHERE cedula_cliente='"+idUsu+"'";
	        
	        try{
	        	Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				System.out.println(rs+"este es el resultado de rs");
	           
	           if(rs.next()){
	        	   System.out.println("si existe el cliente");
	               return true;
	           }else {
	        	   System.out.println("no existe el cliente");
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
	  
	  
		public boolean registrar(Cliente cliente){
			
			int ident = cliente.getId();
			
			if(confirmarExistenciaCliente(ident) == false) {
			
				String nombre = cliente.getNombre();
				String telefono = cliente.getTelefono();
				Date fechaNacimiento = cliente.getFechaNacimiento();
			
				
				
				
				Connection con = getConnection();
		        String sql = "INSERT INTO cliente (cedula_cliente, nombre_cliente, contacto_cliente, fecha_nacimiento_cliente)"
		        		+ "values ('"+ident+"','"+nombre+"','"+telefono+"','"+fechaNacimiento+"')";
		        
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
				 JOptionPane.showMessageDialog(null, "Registro fallido, el cliente ya existe");
				 return false;
			}
	        
	    }
		
		
	    public boolean eliminar(int id){
	        
	        Connection con = getConnection();
	        int idUsu = id;
	        String sql = "DELETE from cliente WHERE cedula_cliente='"+idUsu+"'";
	        
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
	    
	    
	    public boolean modificar(Cliente cliente){
	    	
	    	int id = cliente.getId();
			String nombre = cliente.getNombre();
			String telefono = cliente.getTelefono();
			Date fechaNacimiento = cliente.getFechaNacimiento();
					
			Connection con = getConnection();
				
			String sql = "UPDATE cliente SET cedula_cliente='"+id+"',nombre_cliente='"+nombre+"',contacto_cliente='"+telefono+"',fecha_nacimiento_cliente='"+fechaNacimiento+"' WHERE cedula_cliente='"+id+"'";
			        	
				
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
	        String sql = "SELECT * FROM cliente";
	        
	        try{
	        	Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				
	           
	           while(rs.next()){
	        	   
	        	int cedula = rs.getInt("cedula_cliente");   
	        	String nombre = rs.getString("nombre_cliente");
	        	String contacto = rs.getString("contacto_cliente");
	        	Date dateObject = rs.getDate("fecha_nacimiento_cliente");
	        	
	        	Object tbData[] = {cedula, nombre, contacto, dateObject};
	        	
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

