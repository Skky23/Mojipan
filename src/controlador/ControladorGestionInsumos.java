package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import modelo.ConsultaInsumos;
import modelo.Insumo;
import ventanas.VentanaGestionInsumos;


public class ControladorGestionInsumos implements ActionListener, MouseListener {

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
		consultaInsumos.poblarTabla(ventanaGestionInsumos.table);
		this.ventanaGestionInsumos.table.addMouseListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == ventanaGestionInsumos.btnBuscarItem) {
						
			if(ventanaGestionInsumos.textFieldBuscarItem.getText().isEmpty() || ventanaGestionInsumos.comboBoxArgumentoBusqueda.getItemAt(0) == "") {
				JOptionPane.showMessageDialog(null, "Indique el ID del producto o el nombre");
			}else {
				ventanaGestionInsumos.borrarElementosTabla();
				
				String parametroBusqueda = ventanaGestionInsumos.parametroBusquedaItem((ventanaGestionInsumos.comboBoxArgumentoBusqueda));
				
				consultaInsumos.buscar(parametroBusqueda, ventanaGestionInsumos.textFieldBuscarItem, ventanaGestionInsumos.table);
				
				ventanaGestionInsumos.textFieldBuscarItem.setText(null);
				ventanaGestionInsumos.comboBoxArgumentoBusqueda.setSelectedIndex(0);
			}
			
		}
		
		if(e.getSource() == ventanaGestionInsumos.btnRegistrarItem) {
			
			String nombre = (ventanaGestionInsumos.textFieldNombreProducto.getText().toLowerCase());
			boolean existe =consultaInsumos.confirmarExistenciaInsumo(nombre);
			
			if(ventanaGestionInsumos.validarCamposVacios()==true) {
				JOptionPane.showMessageDialog(null, "Complete los campos vacíos");				
			}else {
				int reply = JOptionPane.showConfirmDialog(null, "Está seguro que desea agregar el producto \n "+ " ' " + nombre + " ' ", "Advertencia", JOptionPane.YES_NO_OPTION);
				if((reply == JOptionPane.YES_OPTION) && existe==true) {
					JOptionPane.showMessageDialog(null, "El producto ya existe, modifíquelo");
				}else {
					if(reply == JOptionPane.YES_OPTION && existe==false){
						consultaInsumos.registrar(ventanaGestionInsumos);
						ventanaGestionInsumos.limpiarCasillas();
						ventanaGestionInsumos.borrarElementosTabla();
						consultaInsumos.poblarTabla(ventanaGestionInsumos.table);
						JOptionPane.showMessageDialog(null, "Acaba de agregar el insumo: \n - " + nombre);
					}
				}
			}
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
				JOptionPane.showMessageDialog(null, "Ingrese el ID del insumo que desea eliminar");
			}
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

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==ventanaGestionInsumos.table) {
			int fila = ventanaGestionInsumos.table.getSelectedRow();
			ponerValoresTablaEnCasillas(fila);
			ventanaGestionInsumos.borrarElementosTabla();
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

}
