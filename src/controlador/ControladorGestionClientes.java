package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import modelo.Cliente;
import modelo.ConsultaCliente;
import ventanas.VentanaGestionClientes;

public class ControladorGestionClientes implements ActionListener, MouseListener {
	
	VentanaGestionClientes ventanaGestionClientes;
	Cliente cliente = new Cliente();
	ConsultaCliente consultaCliente = new ConsultaCliente();
	
	
	public ControladorGestionClientes(VentanaGestionClientes ventanaGestionClientes) {
		this.ventanaGestionClientes=ventanaGestionClientes;
		this.ventanaGestionClientes.btnBuscarCliente.addActionListener(this);
		this.ventanaGestionClientes.btnEliminarCliente.addActionListener(this);
		this.ventanaGestionClientes.btnModificarCliente.addActionListener(this);
		this.ventanaGestionClientes.btnRegistrarCliente.addActionListener(this);
		this.ventanaGestionClientes.btnLimpiar.addActionListener(this);
		this.ventanaGestionClientes.btnListaDeClientes.addActionListener(this);
		this.ventanaGestionClientes.table.addMouseListener(this);
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
				
				int cedulaCliente = Integer.parseInt(ventanaGestionClientes.textFieldIdCliente.getText());
				
				if(consultaCliente.confirmarExistenciaCliente(cedulaCliente) == true) {
					
					int reply = JOptionPane.showConfirmDialog(null, "Está seguro que desea eliminar el cliente del sistema \n", "Advertencia", JOptionPane.YES_NO_OPTION);
					
					if((reply == JOptionPane.YES_OPTION)) {
						
						int id = Integer.valueOf(ventanaGestionClientes.textFieldIdCliente.getText());
						consultaCliente.eliminar(id);
						ventanaGestionClientes.limpiarCasillas();
						
						ventanaGestionClientes.borrarElementosTabla();
						consultaCliente.poblarTabla(ventanaGestionClientes.table);
					}else {
						
						ventanaGestionClientes.limpiarCasillas();
						ventanaGestionClientes.borrarElementosTabla();
						consultaCliente.poblarTabla(ventanaGestionClientes.table);
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "El ID ingresado no se encuentra registrado en el sistema");
				}
				
				
			}else {
				JOptionPane.showMessageDialog(null, "Ingrese el ID del cliente que desea eliminar");
			}
		}
			
		
		if(e.getSource() == ventanaGestionClientes.btnModificarCliente) {
			if(ventanaGestionClientes.validarCamposLlenos()) {
				
				int cedulaCliente = Integer.parseInt(ventanaGestionClientes.textFieldIdCliente.getText());
				
				if(consultaCliente.confirmarExistenciaCliente(cedulaCliente) == true) {
				
					int reply = JOptionPane.showConfirmDialog(null, "Está seguro que desea modificar la informacion del cliente \n", "Advertencia", JOptionPane.YES_NO_OPTION);
					if((reply == JOptionPane.YES_OPTION)) {
						
						ponerValoresEnModeloUsuario();
						consultaCliente.modificar(cliente);
						
						ventanaGestionClientes.limpiarCasillas();
						ventanaGestionClientes.borrarElementosTabla();
						consultaCliente.poblarTabla(ventanaGestionClientes.table);
					}else {
						
						ventanaGestionClientes.limpiarCasillas();
						ventanaGestionClientes.borrarElementosTabla();
						consultaCliente.poblarTabla(ventanaGestionClientes.table);
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "El cliente no se encuentra registrado en el sistema");
				}
				
			}else {
				JOptionPane.showMessageDialog(null, "Complete todos los campos con el formato correcto");
			}
		}
		
		
		if(e.getSource() == ventanaGestionClientes.btnRegistrarCliente) {
			if(ventanaGestionClientes.validarCamposLlenos()) {
				
				int cedulaCliente = Integer.parseInt(ventanaGestionClientes.textFieldIdCliente.getText());
				
				if(consultaCliente.confirmarExistenciaCliente(cedulaCliente)==false) {
					
					String nombre = (ventanaGestionClientes.textFieldNombreCliente.getText().toLowerCase());
					int reply = JOptionPane.showConfirmDialog(null, "Está seguro que desea agregar el cliente \n "+ "'"+nombre+"'", "Advertencia", JOptionPane.YES_NO_OPTION);
					
					if((reply == JOptionPane.YES_OPTION )) {
						
						ponerValoresEnModeloUsuario();
						consultaCliente.registrar(cliente);
						ventanaGestionClientes.limpiarCasillas();
						
						ventanaGestionClientes.borrarElementosTabla();
						consultaCliente.poblarTabla(ventanaGestionClientes.table);
					}else {
						ventanaGestionClientes.limpiarCasillas();
						consultaCliente.poblarTabla(ventanaGestionClientes.table);
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "El cliente ya se encuentra registrado en el sistema");
				}
				
			}else {
			
			JOptionPane.showMessageDialog(null, "Complete todos los campos con el formato correcto");
			}
			
		}
				
		
		if(e.getSource() == ventanaGestionClientes.btnLimpiar) {
			ventanaGestionClientes.limpiarCasillas();
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
	}
	
	public void ponerValoresEnArreglo(Object[] arreglo) {
		
		arreglo[0]= cliente.getId();
		arreglo[1]= cliente.getNombre();
		arreglo[2]= cliente.getTelefono();

			
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
	
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == ventanaGestionClientes.table) {
			int fila = ventanaGestionClientes.table.getSelectedRow();
			ponerValoresTablaEnCasillas(fila);
			ventanaGestionClientes.borrarElementosTabla();
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
