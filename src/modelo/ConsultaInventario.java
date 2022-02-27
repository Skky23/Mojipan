package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import ventanas.VentanaGestionInventario;

public class ConsultaInventario extends Conexion {
	
	
	  public void buscar (String parametroBusqueda, JTextField casilla, JTable table){
		  	
		  
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        Connection con = getConnection();
	      
	        String sql = "SELECT * FROM productos WHERE "+ parametroBusqueda + "='"+casilla.getText()+"' ";
	        
	        try{
	           
	           ps = con.prepareStatement(sql);
	           rs = ps.executeQuery();
	           

		           while(rs.next()){
		        	   
			        	int id = rs.getInt("id_producto");
			        	String nombre = rs.getString("nombre_producto");
			        	int cantidad = rs.getInt("cantidad_disponible");
			        	int precioUnidad = rs.getInt("precio_unidad");
			        	int costoUnidad = rs.getInt("costo_unidad");

			        	
			        	
			        	Object tbData[] = {id, nombre, cantidad, precioUnidad, costoUnidad};
			        	
			        	DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
			        	
			        	tblModel.addRow(tbData);;
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
	  
	  
		public boolean registrar(VentanaGestionInventario ventanaGestionInventario){
			
			String nombre = (ventanaGestionInventario.textFieldNombreProducto.getText()).toString();
			int cantidad = Integer.parseInt(ventanaGestionInventario.textFieldCantidad.getText());
			int precioUnidad = Integer.parseInt(ventanaGestionInventario.textFieldPrecioUnidad.getText());
			int costoUnidad = Integer.parseInt(ventanaGestionInventario.textFieldCostoUnidad.getText());

			
				
				
				
				Connection con = getConnection();
		        String sql = "INSERT INTO productos (nombre_producto, cantidad_disponible, precio_unidad, costo_unidad)"
		        		+ "values ('"+nombre+"', '"+cantidad+"','"+precioUnidad+"','"+costoUnidad+"')";
		        
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
	        
	    }
		
		
	    public boolean eliminar(int id){
	        
	        Connection con = getConnection();
	        int idItem = id;
	        String sql = "DELETE from productos WHERE id_producto='"+idItem+"'";
	        
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
	    
	    
	    public boolean modificar(VentanaGestionInventario ventanaGestionInventario){
	    	
	    	int fila = ventanaGestionInventario.table.getSelectedRow();
	    	
	    	int id = Integer.parseInt(ventanaGestionInventario.textFieldIdItem.getText());
	    	String nombre = ventanaGestionInventario.textFieldNombreProducto.getText();
	    	int cantidad = Integer.parseInt(ventanaGestionInventario.textFieldCantidad.getText());
			int precioUnidad = Integer.parseInt(ventanaGestionInventario.textFieldPrecioUnidad.getText());
			int costoUnidad = Integer.parseInt(ventanaGestionInventario.textFieldCostoUnidad.getText());
		
			
			
			Connection con = getConnection();
				
			String sql = "UPDATE productos SET nombre_producto='"+nombre+"', cantidad_disponible='"+cantidad+"', precio_unidad='"+precioUnidad+"', costo_unidad='"+costoUnidad+"' WHERE id_producto='"+id+"'";
			        	
				
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
	        String sql = "SELECT * FROM productos ORDER BY id_producto";
	        
	        try{
	        	Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				
	           
	           while(rs.next()){
	        	   
	        	
	        	
	        	int id = rs.getInt("id_producto");
	        	String nombre = rs.getString("nombre_producto");
	        	int cantidad = rs.getInt("cantidad_producto");
	        	int precioUnidad = rs.getInt("precio_unidad_producto");
	        	int costoUnidad = rs.getInt("costo_unidad_producto");

	        	
	        	
	        	Object tbData[] = {id, nombre, cantidad, precioUnidad, costoUnidad};
	        	
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
