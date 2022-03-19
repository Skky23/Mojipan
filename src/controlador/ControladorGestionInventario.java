package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import modelo.ConsultaInventario;
import modelo.Producto;
import ventanas.VentanaGestionInventario;

public class ControladorGestionInventario implements ActionListener, MouseListener {

	VentanaGestionInventario ventanaGestionInventario;
	Producto producto = new Producto();
	ConsultaInventario consultaInventario = new ConsultaInventario();
	
	public ControladorGestionInventario(VentanaGestionInventario ventanaGestionInventario){
		this.ventanaGestionInventario = ventanaGestionInventario;
		this.ventanaGestionInventario.btnBuscarItem.addActionListener(this);
		this.ventanaGestionInventario.btnLimpiar.addActionListener(this);
		this.ventanaGestionInventario.btnListaInventario.addActionListener(this);
		this.ventanaGestionInventario.btnModificarItem.addActionListener(this);
		this.ventanaGestionInventario.table.addMouseListener(this);
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

	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == ventanaGestionInventario.table) {
			
			int fila = ventanaGestionInventario.table.getSelectedRow();
			ponerValoresTablaEnCasillas(fila);
			ventanaGestionInventario.borrarElementosTabla();
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
