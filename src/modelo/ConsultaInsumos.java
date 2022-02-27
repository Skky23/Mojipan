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

import ventanas.VentanaGestionInsumos;

public class ConsultaInsumos extends Conexion {
	
	
	  public void buscar (String parametroBusqueda, JTextField casilla, JTable table){
		  	
		  
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        Connection con = getConnection();
	      
	        String sql = "SELECT * FROM insumos WHERE "+ parametroBusqueda + "='"+casilla.getText()+"' ";
	        
	        try{
	           
	           ps = con.prepareStatement(sql);
	           rs = ps.executeQuery();
	           

		           while(rs.next()){
		        	   
			        	int id = rs.getInt("id_insumo");
			        	String nombre = rs.getString("nombre_insumo");
			        	int cantidad = rs.getInt("cantidad");
			        	int costoUnidad = rs.getInt("costo_por_unidad");

			        	
			        	
			        	Object tbData[] = {id, nombre, cantidad, costoUnidad, };
			        	
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
	  
	  
		public boolean registrar(VentanaGestionInsumos ventanaGestionInsumos){
			
			String nombre = (ventanaGestionInsumos.textFieldNombreProducto.getText()).toString();
			int cantidad = Integer.parseInt(ventanaGestionInsumos.textFieldCantidad.getText());
			int costoUnidad = Integer.parseInt(ventanaGestionInsumos.textFieldCostoUnidad.getText());

			
				
				
				
				Connection con = getConnection();
		        String sql = "INSERT INTO insumos (nombre_insumo, cantidad, costo_por_unidad)"
		        		+ "values ('"+nombre+"', '"+cantidad+"','"+costoUnidad+"')";
		        
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
	        String sql = "DELETE from insumos WHERE id_insumo='"+idItem+"'";
	        
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
	    
	    
	    public boolean modificar(VentanaGestionInsumos ventanaGestionInsumos){
	    	
	    	int fila = ventanaGestionInsumos.table.getSelectedRow();
	    	
	    	int id = Integer.parseInt(ventanaGestionInsumos.textFieldIdItem.getText());
	    	String nombre = ventanaGestionInsumos.textFieldNombreProducto.getText();
	    	int cantidad = Integer.parseInt(ventanaGestionInsumos.textFieldCantidad.getText());
			int costoUnidad = Integer.parseInt(ventanaGestionInsumos.textFieldCostoUnidad.getText());
		
			
			
			Connection con = getConnection();
				
			String sql = "UPDATE insumos SET nombre_insumo='"+nombre+"', cantidad='"+cantidad+"', costo_por_unidad='"+costoUnidad+"' WHERE id_insumo='"+id+"'";
			        	
				
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
	        String sql = "SELECT * FROM insumos ORDER BY id_insumo";
	        
	        try{
	        	Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				
	           
	           while(rs.next()){
	        	   
	        	
	        	
	        	int id = rs.getInt("id_insumo");
	        	String nombre = rs.getString("nombre_insumo");
	        	int cantidad = rs.getInt("cantidad");
	        	int costoUnidad = rs.getInt("costo_por_unidad");

	        	
	        	
	        	Object tbData[] = {id, nombre, cantidad, costoUnidad};
	        	
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
