package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import ventanas.VentanaGestionInsumos;

public class ConsultaInsumos extends Conexion {
	
	  public void buscar (String parametroBusqueda, JTextField casilla, JTable table){
		  	  
		  String termino = casilla.getText().toLowerCase();
		  PreparedStatement ps = null;
		  ResultSet rs = null;
	      Connection con = getConnection();
	      String sql = "SELECT * FROM insumos WHERE " + parametroBusqueda + "=" + "'"+termino+"'";
	      
	             
	        try{
	           ps = con.prepareStatement(sql);
	           rs = ps.executeQuery();
		           while(rs.next()){
		        	   
			        	int id = rs.getInt("id_insumo");
			        	String nombre = rs.getString("nombre_insumo");
			        	int cantidad = rs.getInt("cantidad");
			        	int costoUnidad = rs.getInt("costo_por_unidad");
			        	int costoTotal = rs.getInt("costo_total");        	
			        	
			        	Object tbData[] = {id, nombre, cantidad, costoUnidad, costoTotal};
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
	  
	    public boolean confirmarExistenciaInsumo(String nombre){
	        
	    	String nombreInsumo = nombre;
	        Connection con = getConnection();
	        String sql = "SELECT * FROM insumos WHERE nombre_insumo='"+nombreInsumo+"'";
	        
	        try{
	        	Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
	           
	           if(rs.next()){
	               return true;
	           }else {  
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
	  
	  
		public boolean registrar(VentanaGestionInsumos ventanaGestionInsumos){
			
			String nombre = ((ventanaGestionInsumos.textFieldNombreProducto.getText()).toString()).toLowerCase();
			int cantidad = Integer.parseInt(ventanaGestionInsumos.textFieldCantidad.getText());
			int costoUnidad = Integer.parseInt(ventanaGestionInsumos.textFieldCostoUnidad.getText());
			int costoTotal = cantidad*costoUnidad;
			int costoGramo = costoTotal/cantidad;

				Connection con = getConnection();
		        String sql = "INSERT INTO insumos (nombre_insumo, cantidad, costo_por_unidad, costo_total)"
		        		+ "values ('"+nombre+"', '"+cantidad+"','"+costoUnidad+"','"+costoTotal+"')";
		        
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
	    
	    
	    public boolean modificar(VentanaGestionInsumos ventanaGestionInsumos, ArrayList costos){
	    	
	    	String nombre = ventanaGestionInsumos.textFieldNombreProducto.getText().toLowerCase();
	    	int cantidad = Integer.parseInt(ventanaGestionInsumos.textFieldCantidad.getText());
			int costoUnidad = Integer.parseInt(ventanaGestionInsumos.textFieldCostoUnidad.getText());
			int costoUnidadPromedio = promedioCostos((int)costos.get(1),costoUnidad, (int)costos.get(0), cantidad);
			int cantidadNueva = cantidad+(int)costos.get(0);
			int costoTotalPromedio = costoUnidadPromedio*cantidadNueva;
			
			Connection con = getConnection();		
			String sql = "UPDATE insumos SET cantidad='"+cantidadNueva+"', costo_por_unidad='"+costoUnidadPromedio+"', costo_total='"+costoTotalPromedio+"' WHERE nombre_insumo='"+nombre+"'";
			        	
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
					int costoTotal = cantidad*costoUnidad;
					
	        	Object tbData[] = {id, nombre, cantidad, costoUnidad, costoTotal};
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
	    
	    public ArrayList costosAntiguos(JTextField casilla) {
	    	
	    	String termino = casilla.getText().toLowerCase();
	    	ArrayList costoCantidadAnt = new ArrayList(); 
	    	PreparedStatement ps = null;
			ResultSet rs = null;
		    Connection con = getConnection();
		    String sql = "SELECT * FROM insumos WHERE nombre_insumo = " + "'"+termino+"'";
		    
		    try{
		    	ps = con.prepareStatement(sql);
		    	rs = ps.executeQuery();
		    	while(rs.next()){		    		
				    int cantidad = rs.getInt("cantidad");
				    costoCantidadAnt.add(cantidad);				
				    int costoUnidad = rs.getInt("costo_por_unidad");
				    costoCantidadAnt.add(costoUnidad);
				    int costoTotal = rs.getInt("costo_total");
				    costoCantidadAnt.add(costoTotal);
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
		    return costoCantidadAnt;
	    }
	    
	    public int promedioCostos(int costoUnidadAnt, int costoUnidadNuevo, int cantidadAnt, int cantidadNueva) {
	
	    	int multi = (costoUnidadAnt*cantidadAnt)+(costoUnidadNuevo*cantidadNueva);
	    	int promedio = multi/(cantidadAnt+cantidadNueva);
	    	return promedio;
	    }
	    
	    public ArrayList costosNuevos (VentanaGestionInsumos ventanaGestionInsumos){
	    	
	    	ArrayList costoCantidadNuevo = new ArrayList();
	    	int cantidad = Integer.parseInt(ventanaGestionInsumos.textFieldCantidad.getText());
			int costoUnidad = Integer.parseInt(ventanaGestionInsumos.textFieldCostoUnidad.getText());
			int costoTotal = cantidad*costoUnidad;
		
		    costoCantidadNuevo.add(cantidad);
		    costoCantidadNuevo.add(costoUnidad);
		    costoCantidadNuevo.add(costoTotal);

			return costoCantidadNuevo;
	    }
	    
  public boolean modificarSinCosto(VentanaGestionInsumos ventanaGestionInsumos, ArrayList costos){
	    	
	    	String nombre = ventanaGestionInsumos.textFieldNombreProducto.getText().toLowerCase();
	    	int cantidad = Integer.parseInt(ventanaGestionInsumos.textFieldCantidad.getText());
			int costoUnidad = Integer.parseInt(ventanaGestionInsumos.textFieldCostoUnidad.getText());
			int cantidadNueva = cantidad+(int)costos.get(0);
			int costoTotal = costoUnidad*cantidadNueva;
			
			Connection con = getConnection();		
			String sql = "UPDATE insumos SET cantidad='"+cantidadNueva+"', costo_por_unidad='"+costoUnidad+"', costo_total='"+costoTotal+"' WHERE nombre_insumo='"+nombre+"'";
			        	
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
}
