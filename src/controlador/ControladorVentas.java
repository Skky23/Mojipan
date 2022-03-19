package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import modelo.Cliente;
import modelo.ConsultaCliente;
import modelo.ConsultaInventario;
import modelo.ConsultaVentas;
import modelo.Item;
import modelo.Usuario;
import ventanas.VentanaGestionClientes;
import ventanas.VentanaPrincipal;
import ventanas.VentanaVentas;

public class ControladorVentas implements ActionListener, MouseListener, KeyListener{
	
	int numeroConsecutivoVenta;
	Usuario empleado;
	VentanaPrincipal ventanaPrincipal;
	VentanaGestionClientes ventanaGestionClientes;
	ControladorGestionClientes controladorGestionClientes;
	VentanaVentas ventanaVentas;
	ConsultaVentas consultaVentas = new ConsultaVentas();
	ConsultaInventario consultaInventario = new ConsultaInventario();
	Cliente cliente;
	ConsultaCliente consultaCliente = new ConsultaCliente();
	Item item;	
	
	public ControladorVentas (VentanaVentas ventanaVentas, VentanaPrincipal ventanaPrincipal, Usuario empleado) {
		this.ventanaPrincipal = ventanaPrincipal;
		this.ventanaVentas = ventanaVentas;
		this.empleado = empleado;
		this.ventanaVentas.btnAgregarItem.addActionListener(this);
		this.ventanaVentas.btnEliminarRegistroTabla.addActionListener(this);
		this.ventanaVentas.btnVenta.addActionListener(this);
		this.ventanaVentas.btnLimpiarRegistrosTabla.addActionListener(this);
		this.ventanaVentas.table_1.addMouseListener(this);
		consultaVentas.poblarTablaProductos(ventanaVentas.table_1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == ventanaVentas.btnAgregarItem) {
			if(ventanaVentas.textFieldIdItem.getText().isEmpty()==false && ventanaVentas.comboCantidad.getSelectedIndex()!=0 ){
				
				String idItem = ventanaVentas.textFieldIdItem.getText();
				int cantidad = Integer.valueOf((ventanaVentas.comboCantidad.getSelectedItem()).toString());
				item = new Item();
				consultaInventario.poblarItem(idItem, item);
				
				if(cantidad <= item.getCantidad()) {
					consultaInventario.buscarArticulosTablaVentas(ventanaVentas.textFieldIdItem, ventanaVentas.table, cantidad);
					ventanaVentas.textFieldIdItem.setText(null);
					ventanaVentas.comboCantidad.setSelectedIndex(0);
					calcularSubtotal();
				}else {
					JOptionPane.showMessageDialog(null, "La cantidad ingresada es mayor a la cantidad disponible");
				}
			}else {
				JOptionPane.showMessageDialog(null, "Indique el ID del Item y la cantidad");
			}
		}
			
		if(e.getSource() == ventanaVentas.btnEliminarRegistroTabla) {
			
			if(ventanaVentas.table.getSelectionModel().isSelectionEmpty()==false) {
				int fila = ventanaVentas.table.getSelectedRow();
				ventanaVentas.model.removeRow(fila);
			}else {
				JOptionPane.showMessageDialog(null, "No se selecciono ningun registro");
			}
		}
		
		if(e.getSource() == ventanaVentas.btnVenta) {
			
			if(ventanaVentas.table.getRowCount()>0) {
				if(ventanaVentas.textFieldIDEmpleado.getText().isEmpty() || ventanaVentas.comboPago.getSelectedItem()=="") {
					JOptionPane.showMessageDialog(null, "Agregue el ID del empleado");			
				}else {
					consultaVentas.registrarVenta(ventanaVentas);
					consultaVentas.actualizarCantidades(ventanaVentas);
					ventanaVentas.borrarElementosTabla(ventanaVentas.model_1);
					consultaInventario.poblarTablaItemVentas(ventanaVentas.table_1);
				}
				
				
					
			}else {
					JOptionPane.showMessageDialog(null, "Agregue un item");
			}	
		}
		
		if(e.getSource() == ventanaVentas.btnLimpiarRegistrosTabla) {
			ventanaVentas.borrarElementosTabla(ventanaVentas.model);
			ventanaVentas.textFieldTotal.setText(null);
		}
		
	}
	
	public int buscarIDItemEnTabla(int numeroID, JTable table) {
		
		int opcion = 0;
		int numeroFilas= table.getRowCount();
		
		
		for(int i=0; i<numeroFilas; i++) {
			
			int valor = (int) table.getValueAt(i, 0);
			
			if (numeroID == valor) {
				
				int cantidad = Integer.parseInt(ventanaVentas.comboCantidad.getSelectedItem().toString());
				
				if(cantidad <= item.getCantidad()) {
					
					table.setValueAt(cantidad, i, 2);
					JOptionPane.showMessageDialog(null, "Cantidad Actualizada");
					opcion= 1;
					i=numeroFilas;
				}else {
					JOptionPane.showMessageDialog(null, "La cantidad ingresada es mayor a la cantidad disponible");
					opcion= 2;
					i=numeroFilas;
				}
				
				
			}
		}
		
		System.out.println(opcion);
		return opcion;
	}
	
	public void calcularSubtotal() {
		
		int sumaSubtotales = 0;
    	
    	if(ventanaVentas.table.getRowCount()>0) {
    		
    		int numeroFilas = ventanaVentas.table.getRowCount();
    		
    		for(int i=0; i<numeroFilas; i++) {

    			sumaSubtotales = (int)ventanaVentas.table.getValueAt(i, 4) + sumaSubtotales;
    		}
    		
    		ventanaVentas.textFieldTotal.setText(Integer.toString(sumaSubtotales));
    		
    	}else {
    		ventanaVentas.textFieldTotal.setText(Integer.toString(sumaSubtotales));
    	}
    	
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == ventanaVentas.table_1) {
			
			int numerofila = ventanaVentas.table_1.getSelectedRow();
			
			TableModel model = ventanaVentas.table_1.getModel();
			
			ventanaVentas.textFieldIdItem.setText((ventanaVentas.table_1.getValueAt(numerofila, 0)).toString());
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	
	

}
