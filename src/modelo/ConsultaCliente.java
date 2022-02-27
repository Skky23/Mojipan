package modelo;

import java.sql.Connection;
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
	        String sql = "SELECT * FROM clientes WHERE id_cliente='"+cedula+"' ";
	        
	        try{
	           
	           ps = con.prepareStatement(sql);
	           rs = ps.executeQuery();
	           
	           
	           if(rs.next()){
	        	   
	        	   cliente.setId(rs.getInt("id_cliente"));	  
	        	   cliente.setNombre(rs.getString("nombre_cliente"));
	        	   cliente.setTelefono(rs.getString("contacto_cliente"));
	        	   
	        	   
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
	        String sql = "SELECT * FROM clientes WHERE id_cliente='"+idUsu+"'";
	        
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
											
				
				Connection con = getConnection();
		        String sql = "INSERT INTO clientes (id_cliente, nombre_cliente, contacto_cliente)"
		        		+ "values ('"+ident+"','"+nombre+"','"+telefono+"')";
		        
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
	        String sql = "DELETE from clientes WHERE id_cliente='"+idUsu+"'";
	        
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
					
			Connection con = getConnection();
				
			String sql = "UPDATE clientes SET id_cliente='"+id+"',nombre_cliente='"+nombre+"',contacto_cliente='"+telefono+"' WHERE id_cliente='"+id+"'";
			        	
				
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
	        String sql = "SELECT * FROM clientes";
	        
	        try{
	        	Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				
	           
	           while(rs.next()){
	        	   
	        	int cedula = rs.getInt("id_cliente");   
	        	String nombre = rs.getString("nombre_cliente");
	        	String contacto = rs.getString("contacto_cliente");
	        	
	        	Object tbData[] = {cedula, nombre, contacto};
	        	
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
