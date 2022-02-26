package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import modelo.Cliente;
import modelo.ConsultaCliente;
import ventanas.VentanaGestionClientes;

public class ControladorGestionClientes implements ActionListener {
	
	VentanaGestionClientes ventanaGestionClientes;
	Cliente cliente = new Cliente();
	ConsultaCliente consultaCliente = new ConsultaCliente();
	
	
	public ControladorGestionClientes(VentanaGestionClientes ventanaGestionClientes) {
		this.ventanaGestionClientes=ventanaGestionClientes;
		this.ventanaGestionClientes.btnBuscarCliente.addActionListener(this);
		this.ventanaGestionClientes.btnEliminarCliente.addActionListener(this);
		this.ventanaGestionClientes.btnModificarCliente.addActionListener(this);
		this.ventanaGestionClientes.btnRegistrarCliente.addActionListener(this);
		this.ventanaGestionClientes.btnSeleccionar.addActionListener(this);
		this.ventanaGestionClientes.btnLimpiar.addActionListener(this);
		this.ventanaGestionClientes.btnListaDeClientes.addActionListener(this);
		consultaCliente.poblarTabla(ventanaGestionClientes.table);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == ventanaGestionClientes.btnBuscarCliente) {
			if(ventanaGestionClientes.textFieldBuscarClientePorId.getText().isEmpty()==false) {
				
				int id = Integer.valueOf(ventanaGestionClientes.textFieldBuscarClientePorId.getText());
				
				if(consultaCliente.buscar(cliente, id)) {
					
					ventanaGestionClientes.borrarElementosTabla();
					
					//agregar valores a la tabla
					ponerValoresUsuarioEnTabla();
					ventanaGestionClientes.textFieldBuscarClientePorId.setText(null);
				}else {
					ventanaGestionClientes.textFieldBuscarClientePorId.setText(null);
				}
					
			}else {
				JOptionPane.showMessageDialog(null, "Ingrese el ID del cliente");
			}
			
		}
		
		
		if(e.getSource() == ventanaGestionClientes.btnEliminarCliente) {
			if(ventanaGestionClientes.textFieldIdCliente.getText().isEmpty()==false) {
				int id = Integer.valueOf(ventanaGestionClientes.textFieldIdCliente.getText());
				consultaCliente.eliminar(id);
				ventanaGestionClientes.limpiarCasillas();
			}else {
				JOptionPane.showMessageDialog(null, "Ingrese el ID del cliente que desea eliminar");
			}
		}
			
		
		if(e.getSource() == ventanaGestionClientes.btnModificarCliente) {
			if(ventanaGestionClientes.validarCamposLlenos()) {
				ponerValoresEnModeloUsuario();
				consultaCliente.modificar(cliente);
				ventanaGestionClientes.limpiarCasillas();
			}else {
				JOptionPane.showMessageDialog(null, "Complete todos los campos con el formato correcto");
			}
		}
		
		
		if(e.getSource() == ventanaGestionClientes.btnRegistrarCliente) {
			if(ventanaGestionClientes.validarCamposLlenos()) {
				ponerValoresEnModeloUsuario();
				consultaCliente.registrar(cliente);
				ventanaGestionClientes.limpiarCasillas();
				
				ventanaGestionClientes.borrarElementosTabla();
				consultaCliente.poblarTabla(ventanaGestionClientes.table);
				
			}else {
			
			JOptionPane.showMessageDialog(null, "Complete todos los campos con el formato correcto");
			}
			
		}
				
		
		if(e.getSource() == ventanaGestionClientes.btnLimpiar) {
			ventanaGestionClientes.limpiarCasillas();
		}
		
		
		if(e.getSource() == ventanaGestionClientes.btnSeleccionar) {
			int fila = ventanaGestionClientes.table.getSelectedRow();
			ponerValoresTablaEnCasillas(fila);
			
			ventanaGestionClientes.borrarElementosTabla();
			
		}
		
		
		if(e.getSource() == ventanaGestionClientes.btnListaDeClientes) {
			ventanaGestionClientes.borrarElementosTabla();
			consultaCliente.poblarTabla(ventanaGestionClientes.table);
			
		}
		
	}
	
	
	public void ponerValoresEnModeloUsuario() {
		cliente.setId(Integer.valueOf(ventanaGestionClientes.textFieldIdCliente.getText()));
		cliente.setNombre(ventanaGestionClientes.textFieldNombreCliente.getText());
		cliente.setTelefono(ventanaGestionClientes.textFieldTelefonoCliente.getText());
		cliente.setFechaNacimiento(Date.valueOf(fechaNacimiento()));
	}
	
	public void ponerValoresEnArreglo(Object[] arreglo) {
		
		arreglo[0]= cliente.getId();
		arreglo[1]= cliente.getNombre();
		arreglo[2]= cliente.getTelefono();
		arreglo[3]= cliente.getFechaNacimiento();

			
	}
	
	public void ponerValoresUsuarioEnTabla() {
		
		int numCols = ventanaGestionClientes.table.getModel().getColumnCount();

		Object [] valores = new Object[numCols]; 
		        
		 //poner valores de los textfields en arreglo
		ponerValoresEnArreglo(valores);
		
		 ((DefaultTableModel) ventanaGestionClientes.table.getModel()).addRow(valores);
		 
		///agregue mensaje
		 JOptionPane.showMessageDialog(null, "El cliente ha sido encontrado");
		
	}
	
	public void ponerValoresTablaEnCasillas(int fila) {
		
		ventanaGestionClientes.textFieldIdCliente.setText((ventanaGestionClientes.table.getValueAt(fila, 0).toString()));
		ventanaGestionClientes.textFieldNombreCliente.setText((String) ventanaGestionClientes.table.getValueAt(fila, 1));
		ventanaGestionClientes.textFieldTelefonoCliente.setText((String) ventanaGestionClientes.table.getValueAt(fila, 2));
		ponerFechaTablaEnCasillas(fila);

		
	}
	
	public void ponerFechaTablaEnCasillas(int fila) {
		
		Date date =  (Date) ventanaGestionClientes.table.getValueAt(fila, 3);
		
		LocalDate  localDate = date.toLocalDate();
		
		int day = localDate.getDayOfMonth();
		int month = localDate.getMonthValue();
		int year = localDate.getYear();
		
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
		
		ventanaGestionClientes.comboBoxYear.setSelectedIndex(year-1920);
		ventanaGestionClientes.comboBoxMonth.setSelectedIndex(month);
		ventanaGestionClientes.comboBoxDay.setSelectedIndex(day);
		
	}
	
	public String fechaNacimiento() {
		
		String fecha ="";
		
		fecha = ventanaGestionClientes.comboBoxYear.getSelectedItem().toString() + "-" + ventanaGestionClientes.comboBoxMonth.getSelectedItem().toString() + "-" + ventanaGestionClientes.comboBoxDay.getSelectedItem().toString();
		
		
		return fecha;
		
	}

}
