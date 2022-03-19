package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.ConsultaInventario;
import modelo.Producto;
import ventanas.VentanaGestionInventario;

public class ControladorGestionInventario implements ActionListener {

	VentanaGestionInventario ventanaGestionInventario;
	Producto producto = new Producto();
	ConsultaInventario consultaInventario = new ConsultaInventario();
	
	public ControladorGestionInventario(VentanaGestionInventario ventanaGestionInventario){
		this.ventanaGestionInventario = ventanaGestionInventario;
		this.ventanaGestionInventario.btnBuscarItem.addActionListener(this);
		this.ventanaGestionInventario.btnEliminarItem.addActionListener(this);
		this.ventanaGestionInventario.btnLimpiar.addActionListener(this);
		this.ventanaGestionInventario.btnListaInventario.addActionListener(this);
		this.ventanaGestionInventario.btnModificarItem.addActionListener(this);
		this.ventanaGestionInventario.btnRegistrarItem.addActionListener(this);
		this.ventanaGestionInventario.btnSeleccionar.addActionListener(this);
		consultaInventario.poblarTabla(ventanaGestionInventario.table);
	}
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == ventanaGestionInventario.btnBuscarItem) {
			
			ventanaGestionInventario.borrarElementosTabla();
			
			String parametroBusqueda = ventanaGestionInventario.parametroBusquedaItem((ventanaGestionInventario.comboBoxArgumentoBusqueda));
			
			consultaInventario.buscar(parametroBusqueda, ventanaGestionInventario.textFieldBuscarItem, ventanaGestionInventario.table);
			
			ventanaGestionInventario.textFieldBuscarItem.setText(null);
			ventanaGestionInventario.comboBoxArgumentoBusqueda.setSelectedIndex(0);
			
		}
		
		if(e.getSource() == ventanaGestionInventario.btnModificarItem) {
			consultaInventario.modificar(ventanaGestionInventario);
			
			ventanaGestionInventario.limpiarCasillas();
			
			ventanaGestionInventario.borrarElementosTabla();
			consultaInventario.poblarTabla(ventanaGestionInventario.table);
		}
		
		if(e.getSource() == ventanaGestionInventario.btnSeleccionar) {
			
			int fila = ventanaGestionInventario.table.getSelectedRow();
			
			ponerValoresTablaEnCasillas(fila);
			ventanaGestionInventario.borrarElementosTabla();
			
		}
		
		if(e.getSource() == ventanaGestionInventario.btnListaInventario) {
			
			ventanaGestionInventario.borrarElementosTabla();
			consultaInventario.poblarTabla(ventanaGestionInventario.table);
		}
		
		if(e.getSource() == ventanaGestionInventario.btnLimpiar) {
			ventanaGestionInventario.limpiarCasillas();
		}
		
		
	}
	
	
	public void ponerValoresTablaEnCasillas(int fila) {
		
		
		ventanaGestionInventario.textFieldIdItem.setText((ventanaGestionInventario.table.getValueAt(fila, 0)).toString());
		ventanaGestionInventario.textFieldNombreProducto.setText((ventanaGestionInventario.table.getValueAt(fila, 1)).toString());
		ventanaGestionInventario.textFieldCantidad.setText((ventanaGestionInventario.table.getValueAt(fila, 2)).toString());
		ventanaGestionInventario.textFieldPrecioUnidad.setText((ventanaGestionInventario.table.getValueAt(fila, 3)).toString());
		ventanaGestionInventario.textFieldCostoUnidad.setText((ventanaGestionInventario.table.getValueAt(fila, 4)).toString());

		
		
		
	}

}
