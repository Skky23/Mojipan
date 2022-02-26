package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import modelo.ConsultaProveedor;
import modelo.Proveedor;
import ventanas.VentanaGestionProveedores;

public class ControladorGestionProveedores implements ActionListener {
	
	VentanaGestionProveedores ventanaGestionProveedores;
	Proveedor proveedor = new Proveedor();
	ConsultaProveedor consultaProveedor = new ConsultaProveedor();
	
	public ControladorGestionProveedores(VentanaGestionProveedores ventanaGestionProveedores) {
		this.ventanaGestionProveedores=ventanaGestionProveedores;
		this.ventanaGestionProveedores.btnBuscarProveedores.addActionListener(this);
		this.ventanaGestionProveedores.btnEliminarProveedores.addActionListener(this);
		this.ventanaGestionProveedores.btnModificarProveedores.addActionListener(this);
		this.ventanaGestionProveedores.btnRegistrarProveedores.addActionListener(this);
		this.ventanaGestionProveedores.btnSeleccionar.addActionListener(this);
		this.ventanaGestionProveedores.btnLimpiar.addActionListener(this);
		this.ventanaGestionProveedores.btnListaDeProveedores.addActionListener(this);
		consultaProveedor.poblarTabla(ventanaGestionProveedores.table);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == ventanaGestionProveedores.btnBuscarProveedores) {
			if(ventanaGestionProveedores.textFieldBuscarProveedorPorId.getText().isEmpty()==false) {
				
				int id = Integer.valueOf(ventanaGestionProveedores.textFieldBuscarProveedorPorId.getText());
				
				if(consultaProveedor.buscar(proveedor, id)) {
					
					ventanaGestionProveedores.borrarElementosTabla();
					
					//agregar valores a la tabla
					ponerValoresProveedorEnTabla();
					ventanaGestionProveedores.textFieldBuscarProveedorPorId.setText(null);
				
				}else {
					ventanaGestionProveedores.textFieldBuscarProveedorPorId.setText(null);
				}
				
			}else {
				JOptionPane.showMessageDialog(null, "Ingrese el ID del proveedor");
			}
			
		}
		
		
		if(e.getSource() == ventanaGestionProveedores.btnEliminarProveedores) {
			if(ventanaGestionProveedores.textFieldIdProveedores.getText().isEmpty()==false) {
				int id = Integer.valueOf(ventanaGestionProveedores.textFieldIdProveedores.getText());
				consultaProveedor.eliminar(id);
				ventanaGestionProveedores.limpiarCasillas();
			}else {
				JOptionPane.showMessageDialog(null, "Ingrese el ID del proveedor que desea eliminar");
			}
		}
		
		
		if(e.getSource() == ventanaGestionProveedores.btnModificarProveedores) {
			if(ventanaGestionProveedores.validarCamposLlenos()) {
				ponerValoresEnModeloUsuario();
				consultaProveedor.modificar(proveedor);
				ventanaGestionProveedores.limpiarCasillas();
			}else {
				JOptionPane.showMessageDialog(null, "Complete todos los campos con el formato correcto");
			}
		}
		
		
		if(e.getSource() == ventanaGestionProveedores.btnRegistrarProveedores) {
			if(ventanaGestionProveedores.validarCamposLlenos()) {
				ponerValoresEnModeloUsuario();
				consultaProveedor.registrar(proveedor);
				ventanaGestionProveedores.limpiarCasillas();
				
				ventanaGestionProveedores.borrarElementosTabla();
				consultaProveedor.poblarTabla(ventanaGestionProveedores.table);
				
			}else {
			
			JOptionPane.showMessageDialog(null, "Complete todos los campos con el formato correcto");
			}
		}
		
		
		if(e.getSource() == ventanaGestionProveedores.btnLimpiar) {
			ventanaGestionProveedores.limpiarCasillas();
		}
		
		
		if(e.getSource() == ventanaGestionProveedores.btnSeleccionar) {
			
			int fila = ventanaGestionProveedores.table.getSelectedRow();
			ponerValoresTablaEnCasillas(fila);
			ventanaGestionProveedores.borrarElementosTabla();
		}
		
		
		if(e.getSource() == ventanaGestionProveedores.btnListaDeProveedores) {
			ventanaGestionProveedores.borrarElementosTabla();
			consultaProveedor.poblarTabla(ventanaGestionProveedores.table);
		}
	}
	
	
	public void ponerValoresEnModeloUsuario() {
		proveedor.setId(Integer.valueOf(ventanaGestionProveedores.textFieldIdProveedores.getText()));
		proveedor.setNombre(ventanaGestionProveedores.textFieldNombreProveedores.getText());
		proveedor.setDireccion(ventanaGestionProveedores.textFieldDireccionProveedores.getText());
		proveedor.setTelefono(ventanaGestionProveedores.textFieldTelefonoProveedores.getText());
	}
	
	public void ponerValoresEnArreglo(Object[] arreglo) {
		
		arreglo[0]= proveedor.getId();
		arreglo[1]= proveedor.getNombre();
		arreglo[2]= proveedor.getDireccion();
		arreglo[3]= proveedor.getTelefono();	
	}
	
	public void ponerValoresProveedorEnTabla() {
		
		int numCols = ventanaGestionProveedores.table.getModel().getColumnCount();

		Object [] valores = new Object[numCols]; 
		        
		 //poner valores de los textfields en arreglo
		ponerValoresEnArreglo(valores);
		
		 ((DefaultTableModel) ventanaGestionProveedores.table.getModel()).addRow(valores);
		 
		///agregue mensaje
		 JOptionPane.showMessageDialog(null, "El empleado ha sido encontrado");
		
	}
	
	public void ponerValoresTablaEnCasillas(int fila) {
		
		ventanaGestionProveedores.textFieldIdProveedores.setText((ventanaGestionProveedores.table.getValueAt(fila, 0).toString()));
		ventanaGestionProveedores.textFieldNombreProveedores.setText((String) ventanaGestionProveedores.table.getValueAt(fila, 1));
		ventanaGestionProveedores.textFieldDireccionProveedores.setText((String) ventanaGestionProveedores.table.getValueAt(fila, 2));
		ventanaGestionProveedores.textFieldTelefonoProveedores.setText((String) ventanaGestionProveedores.table.getValueAt(fila, 3));

	}

}
