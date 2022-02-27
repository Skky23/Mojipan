package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import modelo.ConsultaUsuario;
import modelo.Usuario;
import ventanas.VentanaGestionUsuarios;

public class ControladorGestionUsuarios implements ActionListener{
	
	
	VentanaGestionUsuarios ventanaGestionUsuarios;
	Usuario empleado = new Usuario();
	ConsultaUsuario consultaUsuario = new ConsultaUsuario();
	
	public ControladorGestionUsuarios(VentanaGestionUsuarios ventanaGestionUsuarios) {
		this.ventanaGestionUsuarios=ventanaGestionUsuarios;
		this.ventanaGestionUsuarios.btnBuscarUsuario.addActionListener(this);
		this.ventanaGestionUsuarios.btnEliminarUsuario.addActionListener(this);
		this.ventanaGestionUsuarios.btnModificarUsuario.addActionListener(this);
		this.ventanaGestionUsuarios.btnRegistrar.addActionListener(this);
		this.ventanaGestionUsuarios.btnLimpiar.addActionListener(this);
		this.ventanaGestionUsuarios.btnSeleccionar.addActionListener(this);
		this.ventanaGestionUsuarios.btnTraerInfoDB.addActionListener(this);
		consultaUsuario.poblarTabla(ventanaGestionUsuarios.table);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//Metodo para buscar un usuario en la base de datos y poner su infomracion en la tabla
		if(e.getSource() == ventanaGestionUsuarios.btnBuscarUsuario) {
			
			if(ventanaGestionUsuarios.textFieldBuscarUsuarioPorId.getText().isEmpty()==false) {
			
				int id = Integer.valueOf(ventanaGestionUsuarios.textFieldBuscarUsuarioPorId.getText());
				
				if(consultaUsuario.buscar(empleado, id)) {
					
					ventanaGestionUsuarios.borrarElementosTabla();
					
					//agregar valores a la tabla
					ponerValoresUsuarioEnTabla();
					ventanaGestionUsuarios.textFieldBuscarUsuarioPorId.setText(null);
				
				}else {
					ventanaGestionUsuarios.textFieldBuscarUsuarioPorId.setText(null);
				}
				
			}else {
				JOptionPane.showMessageDialog(null, "Ingrese el ID del empleado");
			}
			
		}
		
		//metodo para eliminar un usuario de la base de datos
		if(e.getSource() == ventanaGestionUsuarios.btnEliminarUsuario) {
				if(ventanaGestionUsuarios.textFieldIdUsuario.getText().isEmpty()==false) {
					int id = Integer.valueOf(ventanaGestionUsuarios.textFieldIdUsuario.getText());
					consultaUsuario.eliminar(id);
					ventanaGestionUsuarios.limpiarCasillas();
					
					ventanaGestionUsuarios.borrarElementosTabla();
					consultaUsuario.poblarTabla(ventanaGestionUsuarios.table);
					
				}else {
					JOptionPane.showMessageDialog(null, "Ingrese el ID del empleado que desea eliminar");
				}
		}
			
		//metodo que modifica informacion de un empleado
		if(e.getSource() == ventanaGestionUsuarios.btnModificarUsuario) {
			
			if(ventanaGestionUsuarios.validarCamposLlenos()) {
				ponerValoresEnModeloUsuario();
				consultaUsuario.modificar(empleado);
				ventanaGestionUsuarios.limpiarCasillas();
				
				ventanaGestionUsuarios.borrarElementosTabla();
				consultaUsuario.poblarTabla(ventanaGestionUsuarios.table);
				
				
			}else {
				JOptionPane.showMessageDialog(null, "Complete todos los campos con el formato correcto");
			}
			
		}
		
		//metodo para registrar un empleado en la base de datos
		if(e.getSource() == ventanaGestionUsuarios.btnRegistrar) {
			
			if(ventanaGestionUsuarios.validarCamposLlenos()) {
				ponerValoresEnModeloUsuario();
				consultaUsuario.registrar(empleado);
				ventanaGestionUsuarios.limpiarCasillas();
				
				ventanaGestionUsuarios.borrarElementosTabla();
				consultaUsuario.poblarTabla(ventanaGestionUsuarios.table);
				
			}else {
			
			JOptionPane.showMessageDialog(null, "Complete todos los campos con el formato correcto");
			}
		}
		
		//metodo para limpiar las casillas
		if(e.getSource() == ventanaGestionUsuarios.btnLimpiar) {
			ventanaGestionUsuarios.limpiarCasillas();
		}
		
		//metodo para seleccionar un registro de la tabla y poner sus valores en las casillas
		if(e.getSource() == ventanaGestionUsuarios.btnSeleccionar) {

			int fila = ventanaGestionUsuarios.table.getSelectedRow();
			
			ponerValoresTablaEnCasillas(fila);
			ventanaGestionUsuarios.borrarElementosTabla();
			
		}
		
		if(e.getSource() == ventanaGestionUsuarios.btnTraerInfoDB) {
			ventanaGestionUsuarios.borrarElementosTabla();
			consultaUsuario.poblarTabla(ventanaGestionUsuarios.table);
		}
	
		
	}
	
	
	public void ponerValoresEnModeloUsuario() {
		empleado.setId(Integer.valueOf(ventanaGestionUsuarios.textFieldIdUsuario.getText()));
		empleado.setNombre(ventanaGestionUsuarios.textFieldNombreUsuario.getText());
		empleado.setTelefono(ventanaGestionUsuarios.textFieldTelefonoUsuario.getText());
		empleado.setPassword(ventanaGestionUsuarios.textFieldPasswordUsuario.getText());
		
		
	}
	
	public void ponerValoresEnArreglo(Object[] arreglo) {
		
		arreglo[0]= empleado.getId();
		arreglo[1]= empleado.getNombre();
		arreglo[2]= empleado.getTelefono();
		arreglo[3]= empleado.getPassword(); 
			
	}
	
	public void ponerValoresUsuarioEnTabla() {
		
		int numCols = ventanaGestionUsuarios.table.getModel().getColumnCount();

		Object [] valores = new Object[numCols]; 
		        
		 //poner valores de los textfields en arreglo
		ponerValoresEnArreglo(valores);
		
		 ((DefaultTableModel) ventanaGestionUsuarios.table.getModel()).addRow(valores);
		 
		///agregue mensaje
		 JOptionPane.showMessageDialog(null, "El empleado ha sido encontrado");
		
	}
	
	public void ponerValoresTablaEnCasillas(int fila) {
		
		
		ventanaGestionUsuarios.textFieldIdUsuario.setText((ventanaGestionUsuarios.table.getValueAt(fila, 0).toString()));
		ventanaGestionUsuarios.textFieldNombreUsuario.setText((String) ventanaGestionUsuarios.table.getValueAt(fila, 1));
		ventanaGestionUsuarios.textFieldTelefonoUsuario.setText((String) ventanaGestionUsuarios.table.getValueAt(fila, 2));
		ventanaGestionUsuarios.textFieldPasswordUsuario.setText((String) ventanaGestionUsuarios.table.getValueAt(fila, 3));
		
	}
	
	

	

	

}
