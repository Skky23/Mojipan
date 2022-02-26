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

public class VentanaGestionProveedores extends JPanel {
	public JTextField textFieldIdProveedores;
	public JTextField textFieldNombreProveedores;
	public JTextField textFieldDireccionProveedores;
	public JTextField textFieldTelefonoProveedores;
	public JTextField textFieldBuscarProveedorPorId;
	public JTable table;
	DefaultTableModel model;
	
	
	public JButton btnRegistrarProveedores;
	public JButton btnModificarProveedores;
	public JButton btnEliminarProveedores;
	public JButton btnBuscarProveedores;
	public JButton btnSeleccionar;
	public JButton btnLimpiar;
	public JButton btnListaDeProveedores;

	/**
	 * Create the panel.
	 */
	public VentanaGestionProveedores() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestion de Proveedores");
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel.setBounds(30, 30, 260, 26);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Id");
		lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1.setBounds(30, 80, 261, 17);
		add(lblNewLabel_1);
		
		textFieldIdProveedores = new JTextField();
		textFieldIdProveedores.addKeyListener(new KeyAdapter() {
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
				
				
				if(textFieldIdProveedores.getText().length()>= 15) {
					getToolkit().beep();
					e.consume();
					
					JOptionPane.showMessageDialog(null, "Ingresar 15 numeros o menos");
				}
				
			}
		});
		textFieldIdProveedores.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldIdProveedores.setBackground(new Color(255, 255, 255));
		textFieldIdProveedores.setBorder(null);
		textFieldIdProveedores.setBounds(30, 99, 261, 20);
		add(textFieldIdProveedores);
		textFieldIdProveedores.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 153, 255));
		separator.setBounds(30, 123, 261, 2);
		add(separator);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre");
		lblNewLabel_1_1.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(311, 80, 261, 17);
		add(lblNewLabel_1_1);
		
		textFieldNombreProveedores = new JTextField();
		textFieldNombreProveedores.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				char validar=e.getKeyChar();
				
				if(Character.isLetter(validar)==false) {
					
					if(e.getKeyChar()!=32 && e.getKeyChar()!=8){
						getToolkit().beep();
						e.consume();
						JOptionPane.showMessageDialog(null, "Ingresar solo letras");
					}
				}
				
				
				if(textFieldNombreProveedores.getText().length()> 40) {
					getToolkit().beep();
					e.consume();
					
					JOptionPane.showMessageDialog(null, "Ingresar 40 letras o menos");
				}
				
			}
		});
		textFieldNombreProveedores.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldNombreProveedores.setBackground(new Color(255, 255, 255));
		textFieldNombreProveedores.setBorder(null);
		textFieldNombreProveedores.setColumns(10);
		textFieldNombreProveedores.setBounds(311, 99, 261, 20);
		add(textFieldNombreProveedores);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 153, 255));
		separator_1.setBounds(311, 123, 261, 2);
		add(separator_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Dirección");
		lblNewLabel_1_2.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(592, 80, 261, 17);
		add(lblNewLabel_1_2);
		
		textFieldDireccionProveedores = new JTextField();
		textFieldDireccionProveedores.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				if(e.getKeyChar()==61 || e.getKeyChar()==59) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "No se permiten los caracteres = ;");
				}
				
				if(textFieldDireccionProveedores.getText().length()>=50) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "Ingresar 10 caracteres o menos");
				}
				
			}
		});
		textFieldDireccionProveedores.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldDireccionProveedores.setBackground(new Color(255, 255, 255));
		textFieldDireccionProveedores.setBorder(null);
		textFieldDireccionProveedores.setColumns(10);
		textFieldDireccionProveedores.setBounds(592, 99, 261, 20);
		add(textFieldDireccionProveedores);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(0, 153, 255));
		separator_2.setBounds(592, 123, 261, 2);
		add(separator_2);
		
		JLabel lblNewLabel_1_4 = new JLabel("Telefono");
		lblNewLabel_1_4.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_4.setBounds(30, 143, 261, 17);
		add(lblNewLabel_1_4);
		
		textFieldTelefonoProveedores = new JTextField();
		textFieldTelefonoProveedores.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				char validar=e.getKeyChar();
				
				if(Character.isLetter(validar) || (e.getKeyChar()>32 && e.getKeyChar()<48) || (e.getKeyChar()>57 && e.getKeyChar()<65) || (e.getKeyChar()>90 && e.getKeyChar()<97) || (e.getKeyChar()>122 && e.getKeyChar()<127)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "Ingresar solo numeros");
				}
				
				if(textFieldTelefonoProveedores.getText().length()>= 15) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "Ingresar 15 letras o menos");
				}
				
			}
		});
		textFieldTelefonoProveedores.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldTelefonoProveedores.setBackground(new Color(255, 255, 255));
		textFieldTelefonoProveedores.setBorder(null);
		textFieldTelefonoProveedores.setColumns(10);
		textFieldTelefonoProveedores.setBounds(30, 162, 261, 20);
		add(textFieldTelefonoProveedores);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(new Color(0, 153, 255));
		separator_4.setBounds(30, 185, 261, 2);
		add(separator_4);
		
		btnRegistrarProveedores = new JButton("REGISTRAR");
		btnRegistrarProveedores.setFont(new Font("Roboto", Font.BOLD, 12));
		btnRegistrarProveedores.setForeground(Color.WHITE);
		btnRegistrarProveedores.setBorder(null);
		btnRegistrarProveedores.setBackground(new Color(0,51,153));
		btnRegistrarProveedores.setBounds(30, 209, 113, 25);
		add(btnRegistrarProveedores);
		
		btnModificarProveedores = new JButton("MODIFICAR");
		btnModificarProveedores.setForeground(Color.WHITE);
		btnModificarProveedores.setFont(new Font("Roboto", Font.BOLD, 12));
		btnModificarProveedores.setBorder(null);
		btnModificarProveedores.setBackground(new Color(0, 51, 153));
		btnModificarProveedores.setBounds(153, 209, 113, 25);
		add(btnModificarProveedores);
		
		btnEliminarProveedores = new JButton("ELIMINAR");
		btnEliminarProveedores.setForeground(Color.WHITE);
		btnEliminarProveedores.setFont(new Font("Roboto", Font.BOLD, 12));
		btnEliminarProveedores.setBorder(null);
		btnEliminarProveedores.setBackground(new Color(0, 51, 153));
		btnEliminarProveedores.setBounds(276, 209, 113, 25);
		add(btnEliminarProveedores);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(30, 245, 828, 2);
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
		textFieldBuscarProveedorPorId.setBounds(30, 260, 700, 20);
		add(textFieldBuscarProveedorPorId);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setForeground(new Color(0, 153, 255));
		separator_7.setBounds(30, 283, 700, 2);
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
		btnBuscarProveedores.setBounds(740, 260, 113, 25);
		add(btnBuscarProveedores);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(30, 301, 823, 130);
		add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		
		model = new DefaultTableModel();
		Object[] column = {"ID","Nombre","Dirección","Telefono"};
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
		
		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.setForeground(Color.WHITE);
		btnLimpiar.setFont(new Font("Roboto", Font.BOLD, 12));
		btnLimpiar.setBorder(null);
		btnLimpiar.setBackground(new Color(0, 51, 153));
		btnLimpiar.setBounds(399, 209, 113, 25);
		add(btnLimpiar);
		
		btnListaDeProveedores = new JButton("LISTA DE PROVEEDORES");
		btnListaDeProveedores.setForeground(Color.WHITE);
		btnListaDeProveedores.setFont(new Font("Roboto", Font.BOLD, 12));
		btnListaDeProveedores.setBorder(null);
		btnListaDeProveedores.setBackground(new Color(0, 51, 153));
		btnListaDeProveedores.setBounds(153, 442, 163, 25);
		add(btnListaDeProveedores);

	}
	
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
	}
	
	public void borrarElementosTabla() {
		 
        int numeroFilasBorrar = model.getRowCount();
        //remove rows from the bottom one by one
        for (int i = numeroFilasBorrar - 1; i >= 0; i--) {
            model.removeRow(i);
        }
	}
}

