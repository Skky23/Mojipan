package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import ventanas.VentanaVentas;

public class ConsultaVentas extends Conexion{

	 public void poblarTablaItemVentas(JTable table) {
		 Connection con = getConnection();
		 String sql = "SELECT * FROM productos ORDER BY id_producto";
		 
		 try{
			 Statement st = con.createStatement();
			 ResultSet rs = st.executeQuery(sql);
			 
			 while(rs.next()){
				 int idProducto = rs.getInt("id_producto");
				 String nombreProducto = rs.getString("nombre_producto");
				 int cantidad = rs.getInt("cantidad_disponible");
				 int precio = rs.getInt("precio_unidad");
				 int subtotal = cantidad*precio;
				 
				 Object tbData[] = {idProducto, nombreProducto, cantidad, precio, subtotal};
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
	
	public void traerNumeroConsecutivoVentas(int numeroVentas) {
		
        Connection con = getConnection();
        String sql = "SELECT * FROM contador_ventas";
        
        try{
        	Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
           while(rs.next()){
        	numeroVentas = rs.getInt("numero_venta");
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
	
	public void registrarVenta(VentanaVentas ventanaVentas){
		
		
		
		int cantidad;
		int numeroFilas = ventanaVentas.table.getRowCount();
		int idProducto;
		int idUsuario;
		int cedulaEmpleado = Integer.parseInt(ventanaVentas.textFieldIDEmpleado.getText());
		String pago = (String)ventanaVentas.comboPago.getSelectedItem();
		int totalVenta;
		LocalDate date = LocalDate.now();
		Date fechaVenta = Date.valueOf(date);
	    
	    for(int i=0;i<numeroFilas;i++) {
	    	Connection con = getConnection();	    	
	    	cantidad = (int)ventanaVentas.table.getValueAt(i,2);
	    	idProducto = (int)ventanaVentas.table.getValueAt(i,0);
	    	idUsuario = (int) Math.round(Math.random()*100);
	    	totalVenta = (int)ventanaVentas.table.getValueAt(i, 4);
	    	String sql = "INSERT INTO ventas (id_producto, id_cliente, id_usuario, cantidad, tipo_pago, total, fecha_venta)"
	    			 +"values ('"+idProducto+"','"+cedulaEmpleado+"','"+idUsuario+"','"+cantidad+"','"+pago+"','"+totalVenta+"','"+fechaVenta+"')";
	    
	    try{
	    	Statement st = con.createStatement();
	    	int ejecucion = st.executeUpdate(sql);
	    	if(ejecucion != 0) {
	    		JOptionPane.showMessageDialog(null, "Registro exitoso");
	    	}else {
	    		JOptionPane.showMessageDialog(null, "Registro fallido");
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
	
    public void actualizarCantidades(VentanaVentas ventanaVentas){
    	int numeroFilas = ventanaVentas.table.getRowCount();
    	for(int i=0; i<numeroFilas;i++) {
    		Connection con = getConnection();
			int idItem = (int) ventanaVentas.table.getValueAt(i, 0);
			int cantidad = (int) ventanaVentas.table.getValueAt(i, 2);
			String sql = "UPDATE productos SET cantidad_disponible=cantidad_disponible-'"+cantidad+"' WHERE id_producto='"+idItem+"'";
			
			try{
				Statement st = con.createStatement();
				int ejecucion = st.executeUpdate(sql);
				if(ejecucion != 0) {
					JOptionPane.showMessageDialog(null, "Cantidad de producto actualizada");
				}else {
					JOptionPane.showMessageDialog(null, "Cambio fallido, no se pudo actualizar la cantidad");
		        }
		        
			}catch(SQLException e) {
				System.err.println(e);
			}finally{
				try{
					con.close();
				}catch (SQLException e){
					System.err.println(e);
		        }
		    }
    	}
    }    
    
	public int obtenerIdReserva() {
		int idReserva=0;
		
        Connection con = getConnection();
        String sql = "SELECT max(id_reserva) as maximo FROM reservas";
        
        try{
        	Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
				idReserva = rs.getInt("maximo");
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
		return idReserva;	
	}
	
	
	public void registrarDetalleReserva(VentanaVentas ventanaVentas){
		
		int numeroFilas = ventanaVentas.table.getRowCount();
		int idReserva = obtenerIdReserva();
		
		for(int i=0; i<numeroFilas;i++) {
			
			int idProducto = (int) (ventanaVentas.table.getValueAt(i,0));
			int cantidad = (int) (ventanaVentas.table.getValueAt(i,2));
					
			Connection con = getConnection();
			
	        String sql = "INSERT INTO detalle_reservas (id_reserva, id_producto, cantidad)"
	        		+ "values ('"+idReserva+"', '"+idProducto+"','"+cantidad+"')";
	        
	        try{
	           
	        	 Statement st = con.createStatement();
	             int ejecucion = st.executeUpdate(sql);
	             
	            if(ejecucion != 0) {
	         	   JOptionPane.showMessageDialog(null, "Registro detalle de reserva exitoso");
	         	   
	            }else {
	         	   JOptionPane.showMessageDialog(null, "Registro detalle de reserva fallido");
	         	  
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
	
	 public void poblarTablaProductos(JTable table) {
		 Connection con = getConnection();
		 String sql = "SELECT * FROM productos ORDER BY id_producto";
		 
		 try{
			 Statement st = con.createStatement();
			 ResultSet rs = st.executeQuery(sql);
			 
			 while(rs.next()){
				 int idProducto = rs.getInt("id_producto");
				 String nombreProducto = rs.getString("nombre_producto");
				 int cantidad = rs.getInt("cantidad_disponible");
				 int precio = rs.getInt("precio_unidad");
				 
				 Object tbData[] = {idProducto, nombreProducto, cantidad, precio};
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
