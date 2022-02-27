package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.ConsultaInsumos;
import modelo.Insumo;
import ventanas.VentanaGestionInsumos;


public class ControladorGestionInsumos implements ActionListener {

	VentanaGestionInsumos ventanaGestionInsumos;
	Insumo insumo = new Insumo();
	ConsultaInsumos consultaInsumos = new ConsultaInsumos();
	
	public ControladorGestionInsumos(VentanaGestionInsumos ventanaGestionInsumos){
		this.ventanaGestionInsumos = ventanaGestionInsumos;
		this.ventanaGestionInsumos.btnBuscarItem.addActionListener(this);
		this.ventanaGestionInsumos.btnEliminarItem.addActionListener(this);
		this.ventanaGestionInsumos.btnLimpiar.addActionListener(this);
		this.ventanaGestionInsumos.btnListaInventario.addActionListener(this);
		this.ventanaGestionInsumos.btnModificarItem.addActionListener(this);
		this.ventanaGestionInsumos.btnRegistrarItem.addActionListener(this);
		this.ventanaGestionInsumos.btnSeleccionar.addActionListener(this);
		consultaInsumos.poblarTabla(ventanaGestionInsumos.table);
	}
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == ventanaGestionInsumos.btnBuscarItem) {
			
			ventanaGestionInsumos.borrarElementosTabla();
			
			String parametroBusqueda = ventanaGestionInsumos.parametroBusquedaItem((ventanaGestionInsumos.comboBoxArgumentoBusqueda));
			
			consultaInsumos.buscar(parametroBusqueda, ventanaGestionInsumos.textFieldBuscarItem, ventanaGestionInsumos.table);
			
			ventanaGestionInsumos.textFieldBuscarItem.setText(null);
			ventanaGestionInsumos.comboBoxArgumentoBusqueda.setSelectedIndex(0);
			
		}
		
		if(e.getSource() == ventanaGestionInsumos.btnRegistrarItem) {
			consultaInsumos.registrar(ventanaGestionInsumos);
			ventanaGestionInsumos.limpiarCasillas();
			
			ventanaGestionInsumos.borrarElementosTabla();
			consultaInsumos.poblarTabla(ventanaGestionInsumos.table);
		}
		
		if(e.getSource() == ventanaGestionInsumos.btnModificarItem) {
			consultaInsumos.modificar(ventanaGestionInsumos);
			
			ventanaGestionInsumos.limpiarCasillas();
			
			ventanaGestionInsumos.borrarElementosTabla();
			consultaInsumos.poblarTabla(ventanaGestionInsumos.table);
		}
		
		if(e.getSource() == ventanaGestionInsumos.btnEliminarItem) {
			if(ventanaGestionInsumos.textFieldIdItem.getText().isEmpty()==false) {
				int id = Integer.valueOf(ventanaGestionInsumos.textFieldIdItem.getText());
				consultaInsumos.eliminar(id);
				ventanaGestionInsumos.limpiarCasillas();
				
				ventanaGestionInsumos.borrarElementosTabla();
				consultaInsumos.poblarTabla(ventanaGestionInsumos.table);
				
			}else {
				JOptionPane.showMessageDialog(null, "Ingrese el ID del empleado que desea eliminar");
			}
		}
		
		if(e.getSource() == ventanaGestionInsumos.btnSeleccionar) {
			
			int fila = ventanaGestionInsumos.table.getSelectedRow();
			
			ponerValoresTablaEnCasillas(fila);
			ventanaGestionInsumos.borrarElementosTabla();
			
		}
		
		if(e.getSource() == ventanaGestionInsumos.btnListaInventario) {
			
			ventanaGestionInsumos.borrarElementosTabla();
			consultaInsumos.poblarTabla(ventanaGestionInsumos.table);
		}
		
		if(e.getSource() == ventanaGestionInsumos.btnLimpiar) {
			ventanaGestionInsumos.limpiarCasillas();
		}
		
		
	}
	
	
	public void ponerValoresTablaEnCasillas(int fila) {
		
		
		ventanaGestionInsumos.textFieldIdItem.setText((ventanaGestionInsumos.table.getValueAt(fila, 0)).toString());
		ventanaGestionInsumos.textFieldNombreProducto.setText((ventanaGestionInsumos.table.getValueAt(fila, 1)).toString());
		ventanaGestionInsumos.textFieldCantidad.setText((ventanaGestionInsumos.table.getValueAt(fila, 2)).toString());
		ventanaGestionInsumos.textFieldCostoUnidad.setText((ventanaGestionInsumos.table.getValueAt(fila, 3)).toString());

		
		
		
	}

}
