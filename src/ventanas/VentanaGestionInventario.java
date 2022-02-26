package ventanas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaGestionInventario extends JPanel {
	public JTextField textFieldBuscarProveedorPorId;
	public JTable table;
	DefaultTableModel model;
	public JButton btnBuscarProveedores;
	public JButton btnSeleccionar;

	/**
	 * Create the panel.
	 */
	public VentanaGestionInventario() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inventario");
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel.setBounds(30, 30, 260, 26);
		add(lblNewLabel);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(30, 114, 828, 2);
		add(separator_6);
		
		textFieldBuscarProveedorPorId = new JTextField();
		textFieldBuscarProveedorPorId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				char validar=e.getKeyChar();
	
				
				if(Character.isLetter(validar) || (e.getKeyChar()>32 && e.getKeyChar()<48) || (e.getKeyChar()>57 && e.getKeyChar()<65) || (e.getKeyChar()>90 && e.getKeyChar()<97) || (e.getKeyChar()>122 && e.getKeyChar()<127)) {
					getToolkit().beep();
					e.consume();
					
					JOptionPane.showMessageDialog(null, "Ingresar solo numeros");
				}
				
				if(e.getKeyChar()>32 && e.getKeyChar()<48) {
					getToolkit().beep();
					e.consume();
					
					JOptionPane.showMessageDialog(null, "Ingresar solo numeros");
				}
				
				
				if(textFieldBuscarProveedorPorId.getText().length()>= 15) {
					getToolkit().beep();
					e.consume();
					
					JOptionPane.showMessageDialog(null, "Ingresar 15 numeros o menos");
				}
				
			}
		});
		textFieldBuscarProveedorPorId.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldBuscarProveedorPorId.setColumns(10);
		textFieldBuscarProveedorPorId.setBorder(null);
		textFieldBuscarProveedorPorId.setBackground(Color.WHITE);
		textFieldBuscarProveedorPorId.setBounds(30, 129, 700, 20);
		add(textFieldBuscarProveedorPorId);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setForeground(new Color(0, 153, 255));
		separator_7.setBounds(30, 152, 700, 2);
		add(separator_7);
		
		btnBuscarProveedores = new JButton("BUSCAR");
		btnBuscarProveedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscarProveedores.setForeground(Color.WHITE);
		btnBuscarProveedores.setFont(new Font("Roboto", Font.BOLD, 12));
		btnBuscarProveedores.setBorder(null);
		btnBuscarProveedores.setBackground(new Color(0, 51, 153));
		btnBuscarProveedores.setBounds(740, 129, 113, 25);
		add(btnBuscarProveedores);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(30, 168, 823, 263);
		add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		
		model = new DefaultTableModel();
		Object[] column = {"ID", "Referencia", "Proveedor","Cantidad","Precio","Costo","Tipo","Marca","Talla","Color"};
		Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		btnSeleccionar = new JButton("SELECCIONAR");
		btnSeleccionar.setForeground(Color.WHITE);
		btnSeleccionar.setFont(new Font("Roboto", Font.BOLD, 12));
		btnSeleccionar.setBorder(null);
		btnSeleccionar.setBackground(new Color(0, 51, 153));
		btnSeleccionar.setBounds(30, 442, 113, 25);
		add(btnSeleccionar);
		
		JButton btnBuscarProveedores_1 = new JButton("REGISTRAR NUEVO ITEM");
		btnBuscarProveedores_1.setForeground(Color.WHITE);
		btnBuscarProveedores_1.setFont(new Font("Roboto", Font.BOLD, 12));
		btnBuscarProveedores_1.setBorder(null);
		btnBuscarProveedores_1.setBackground(new Color(0, 51, 153));
		btnBuscarProveedores_1.setBounds(30, 78, 171, 25);
		add(btnBuscarProveedores_1);

	}
	
	/*
	public void limpiarCasillas() {
		textFieldIdProveedores.setText(null);
		textFieldNombreProveedores.setText(null);
		textFieldDireccionProveedores.setText(null);
		textFieldTelefonoProveedores.setText(null);


	}
	

	public boolean validarCamposVacios() {
		boolean camposVacios=false;
		
		if(textFieldIdProveedores.getText().isEmpty() && textFieldNombreProveedores.getText().isEmpty() && textFieldDireccionProveedores.getText().isEmpty() && textFieldTelefonoProveedores.getText().isEmpty()) {
			
			camposVacios=true;
		}else {
			camposVacios=false;
		}
		
		System.out.println("Si entro al metodo validadr camposvacios");
		System.out.println(camposVacios);
		return camposVacios;
	}
	
	public boolean validarCamposLlenos() {
		boolean camposLlenos=false;
		
		if(textFieldIdProveedores.getText().isEmpty()==false && textFieldNombreProveedores.getText().isEmpty()==false && textFieldDireccionProveedores.getText().isEmpty()==false && textFieldTelefonoProveedores.getText().isEmpty()==false) {
			camposLlenos = true;
		}else {
			camposLlenos = false;
		}
			
		return camposLlenos;
	}*/
}

