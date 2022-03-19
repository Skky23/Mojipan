package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ventanas.VentanaGestionRecetas;

public class ConsultaReceta extends Conexion {

	
	public void traerNombreInsumos(JTable table, String receta) {
		
        Connection con = getConnection();
        String sql = "SELECT nombre_ingrediente FROM " + receta;
        
        try{
        	Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
			
        	
           while(rs.next()){
        	    
        	String nombre = rs.getString("nombre_ingrediente");  
        	tableModel.addRow(new Object[] {nombre, 0.00,0.00,0.00});
   
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
	
	
	public void calcularValoresCostoGramoTablaReceta(JTable table) {
		
		
        Connection con = getConnection();
        String sql = "SELECT * FROM insumos";
        
        try{
        	Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			int i = 0;
			rs.next(); 
			
			while(rs.next()){
				Double costo = rs.getDouble("costo_por_gramo");
				table.setValueAt(costo, i, 2);
				i++;
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
	
	
	public void calcularValoresPesoTabla(VentanaGestionRecetas ventanaGestionRecetas, int numeroUnidades, int pesoUnidad) {
		
		int pesoTotal = numeroUnidades*pesoUnidad;
		
        Connection con = getConnection();
        String sql = "SELECT porcentaje_peso_total FROM panreybarra";
        
        try{
        	Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			int i = 0;
			
			while(rs.next()){
				Double porcentaje = rs.getDouble("porcentaje_peso_total");
				int peso = (int) Math.round(porcentaje*pesoTotal);
				ventanaGestionRecetas.table.setValueAt(peso, i, 1);
				i++;
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
	
	
    public boolean crearProducto(VentanaGestionRecetas ventanaGestionReceta){
    	
    	String nombre = "pan rey barra";
    	int cantidad = Integer.parseInt(ventanaGestionReceta.textFieldCantidadProducto.getText());
    	int precio = Integer.parseInt(ventanaGestionReceta.textFieldPrecioUnidad.getText());
    	int costo = Integer.parseInt(ventanaGestionReceta.textFieldCostoUnidad.getText());
				
		Connection con = getConnection();
			
		String sql = "UPDATE productos SET cantidad_disponible=cantidad_disponible+'"+cantidad+"', precio_unidad='"+precio+"',costo_unidad='"+costo+"' WHERE nombre_producto='"+nombre+"'";
		        	
			
	        try{
	        	
	        	Statement st = con.createStatement();
	            int ejecucion = st.executeUpdate(sql);
	            
	            if(ejecucion != 0) {
	         	   JOptionPane.showMessageDialog(null, "Producto creado con exito");
	         	   return true;
	            }else {
	         	   JOptionPane.showMessageDialog(null, "El producto no se pudo crear fallido");
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
    
    
    public void actualizarCantidadInsumos(VentanaGestionRecetas ventanaGestionReceta){
    	
    	int numeroFilas = ventanaGestionReceta.table.getRowCount();
				
		Connection con = getConnection();
			
	        try{
	        	
	        	for(int i=0;i<numeroFilas-1;i++) {
	        		
	        		String nombre = (String)ventanaGestionReceta.table.getValueAt(i, 0);
	        		int cantidad = (int)ventanaGestionReceta.table.getValueAt(i, 1);
	        		
	        		
	        	
		        	String sql = "UPDATE insumos SET cantidad_gramos_total=cantidad_gramos_total-'"+cantidad+"' WHERE nombre_insumo='"+nombre+"'";
		        	
		        	Statement st = con.createStatement();
		            int ejecucion = st.executeUpdate(sql);
		            
		            if(ejecucion != 0) {
			         	   JOptionPane.showMessageDialog(null, "La cantidad del insumo fue actualizada con exito");
			         	  
			            }else {
			         	   JOptionPane.showMessageDialog(null, "No se pudo actualizar la cantidad del insumo");
			         	  
			            }
		            
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
