package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConsultaProveedor extends Conexion{
	
	  public boolean buscar (Proveedor proveedor, int id){
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        Connection con = getConnection();
	        int cedula = id;
	        String sql = "SELECT * FROM proveedores WHERE id_proveedor='"+cedula+"' ";
	        
	        try{
	           
	           ps = con.prepareStatement(sql);
	           rs = ps.executeQuery();
	           
	           
	           if(rs.next()){
	        	   
	        	   proveedor.setId(rs.getInt("id_proveedor"));
	        	   proveedor.setNombre(rs.getString("nombre_proveedor"));
	        	   proveedor.setDireccion(rs.getString("direccion_proveedor"));
	        	   proveedor.setTelefono(rs.getString("contacto_proveedor"));
	        	  
	        	   
	        	   
	               return true;
	           }else {
	        	   JOptionPane.showMessageDialog(null, "El numero de proveedor no existe");
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
	  
	  
	    public boolean confirmarExistenciaProveedor(int id){
	        
	    	int idUsu = id;
	        Connection con = getConnection();
	        String sql = "SELECT * FROM proveedores WHERE id_proveedor='"+idUsu+"'";
	        
	        try{
	        	Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				System.out.println(rs+"este es el resultado de rs");
	           
	           if(rs.next()){
	        	   System.out.println("si existe el proveedor");
	               return true;
	           }else {
	        	   System.out.println("no existe el proveedor");
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
	  
	  
		public boolean registrar(Proveedor proveedor){
			
			int ident = proveedor.getId();
			
			if(confirmarExistenciaProveedor(ident) == false) {
			
				String nombre = proveedor.getNombre();
				String direccion = proveedor.getDireccion();
				String telefono = proveedor.getTelefono();

				
				Connection con = getConnection();
		        String sql = "INSERT INTO proveedores (id_proveedor, nombre_proveedor, direccion_proveedor, contacto_proveedor)"
		        		+ "values ('"+ident+"', '"+nombre+"','"+direccion+"','"+telefono+"')";
		        
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
				 JOptionPane.showMessageDialog(null, "Registro fallido, el proveedor ya existe");
				 return false;
			}
	        
	    }
		
		
	    public boolean eliminar(int id){
	        
	        Connection con = getConnection();
	        int idUsu = id;
	        String sql = "DELETE from proveedores WHERE id_proveedor='"+idUsu+"'";
	        
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
	    
	    
	    public boolean modificar(Proveedor proveedor){
	    	
	    	int id = proveedor.getId();
			String nombre = proveedor.getNombre();
			String direccion = proveedor.getDireccion();
			String telefono = proveedor.getTelefono();


					
			Connection con = getConnection();
				
			String sql = "UPDATE proveedores SET id_proveedor='"+id+"',nombre_proveedor='"+nombre+"',direccion_proveedor='"+direccion+"',contacto_proveedor='"+telefono+"' WHERE id_proveedor='"+id+"'";
			        	
				
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
	        String sql = "SELECT * FROM proveedores";
	        
	        try{
	        	Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				
	           
	           while(rs.next()){
	        	   
	        	int cedula = rs.getInt("id_proveedor");   
	        	String nombre = rs.getString("nombre_proveedor");
	        	String direccion = rs.getString("direccion_proveedor");
	        	String contacto = rs.getString("contacto_proveedor");
	        	
	        	Object tbData[] = {cedula, nombre, direccion, contacto};
	        	
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

