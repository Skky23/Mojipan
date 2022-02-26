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
import java.sql.Date;
import javax.swing.JComboBox;

public class VentanaAdicionarItem extends JPanel {
	
	public JTextField textFieldIdProveedor;
	DefaultTableModel model;
	public JButton btnRegistrar;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public VentanaAdicionarItem() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nuevo Item");
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel.setBounds(30, 30, 260, 26);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Id Proveedor");
		lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1.setBounds(31, 124, 261, 17);
		add(lblNewLabel_1);
		
		textFieldIdProveedor = new JTextField();
		textFieldIdProveedor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//adicionar validacion de casilla
				
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
				
				
				if(textFieldIdProveedor.getText().length()>= 15) {
					getToolkit().beep();
					e.consume();
					
					JOptionPane.showMessageDialog(null, "Ingresar 15 numeros o menos");
				}
				
			}
		});
		textFieldIdProveedor.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldIdProveedor.setBackground(new Color(255, 255, 255));
		textFieldIdProveedor.setBorder(new LineBorder(new Color(0, 0, 0)));
		textFieldIdProveedor.setBounds(30, 200, 261, 20);
		add(textFieldIdProveedor);
		textFieldIdProveedor.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 153, 255));
		separator.setBounds(31, 167, 261, 2);
		add(separator);
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setFont(new Font("Roboto", Font.BOLD, 12));
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setBorder(null);
		btnRegistrar.setBackground(new Color(0,51,153));
		btnRegistrar.setBounds(30, 419, 113, 25);
		add(btnRegistrar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(31, 143, 260, 20);
		add(comboBox);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cantidad");
		lblNewLabel_1_1.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(31, 180, 261, 17);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Color");
		lblNewLabel_1_1_1.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(32, 231, 261, 17);
		add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Tipo");
		lblNewLabel_1_1_2.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_1_2.setBounds(32, 282, 261, 17);
		add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Marca");
		lblNewLabel_1_1_3.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_1_3.setBounds(32, 333, 261, 17);
		add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_3_1 = new JLabel("Talla");
		lblNewLabel_1_1_3_1.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_1_3_1.setBounds(349, 73, 261, 17);
		add(lblNewLabel_1_1_3_1);
		
		JLabel lblNewLabel_1_1_3_2 = new JLabel("Precio Unidad");
		lblNewLabel_1_1_3_2.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_1_3_2.setBounds(350, 124, 261, 17);
		add(lblNewLabel_1_1_3_2);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Roboto", Font.PLAIN, 14));
		textField_4.setColumns(10);
		textField_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		textField_4.setBackground(Color.WHITE);
		textField_4.setBounds(349, 144, 261, 20);
		add(textField_4);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Costo Unidad");
		lblNewLabel_1_1_1_1.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setBounds(351, 180, 261, 17);
		add(lblNewLabel_1_1_1_1);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Roboto", Font.PLAIN, 14));
		textField_5.setColumns(10);
		textField_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		textField_5.setBackground(Color.WHITE);
		textField_5.setBounds(350, 200, 261, 20);
		add(textField_5);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(31, 251, 260, 20);
		add(comboBox_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setBounds(31, 299, 260, 20);
		add(comboBox_1_1);
		
		JComboBox comboBox_1_1_1 = new JComboBox();
		comboBox_1_1_1.setBounds(31, 353, 260, 20);
		add(comboBox_1_1_1);
		
		JComboBox comboBox_1_1_2 = new JComboBox();
		comboBox_1_1_2.setBounds(348, 91, 260, 20);
		add(comboBox_1_1_2);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Descripción");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1.setBounds(31, 73, 261, 17);
		add(lblNewLabel_1_1_1_1_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Roboto", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBorder(new LineBorder(new Color(0, 0, 0)));
		textField.setBackground(Color.WHITE);
		textField.setBounds(30, 93, 261, 20);
		add(textField);
		
		model = new DefaultTableModel();
		Object[] column = {"ID","Nombre","Telefono","Cargo","Password","FechaNacimiento"};
		Object[] row = new Object[0];
		model.setColumnIdentifiers(column);

	}
	

	

	

}

