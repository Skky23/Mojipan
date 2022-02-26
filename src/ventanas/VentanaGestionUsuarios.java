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
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;

public class VentanaGestionUsuarios extends JPanel {
	
	public JTextField textFieldIdUsuario;
	public JTextField textFieldNombreUsuario;
	public JTextField textFieldTelefonoUsuario;
	public JTextField textFieldPasswordUsuario;
	public JTextField textFieldBuscarUsuarioPorId;
	public JTable table;
	DefaultTableModel model;
	public JButton btnRegistrar;
	public JButton btnModificarUsuario;
	public JButton btnEliminarUsuario;
	public JButton btnBuscarUsuario;
	public JButton btnLimpiar;
	public JButton btnSeleccionar;
	public JButton btnTraerInfoDB;
	public JComboBox comboBoxCargo;
	public JComboBox comboBoxYear;
	public JComboBox comboBoxMonth;
	public JComboBox comboBoxDay;

	/**
	 * Create the panel.
	 */
	public VentanaGestionUsuarios() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestion de Usarios");
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel.setBounds(30, 30, 260, 26);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Id");
		lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1.setBounds(30, 80, 261, 17);
		add(lblNewLabel_1);
		
		textFieldIdUsuario = new JTextField();
		textFieldIdUsuario.addKeyListener(new KeyAdapter() {
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
				
				
				if(textFieldIdUsuario.getText().length()>= 15) {
					getToolkit().beep();
					e.consume();
					
					JOptionPane.showMessageDialog(null, "Ingresar 15 numeros o menos");
				}
				
			}
		});
		textFieldIdUsuario.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldIdUsuario.setBackground(new Color(255, 255, 255));
		textFieldIdUsuario.setBorder(null);
		textFieldIdUsuario.setBounds(30, 99, 261, 20);
		add(textFieldIdUsuario);
		textFieldIdUsuario.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 153, 255));
		separator.setBounds(30, 123, 261, 2);
		add(separator);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre");
		lblNewLabel_1_1.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(311, 80, 261, 17);
		add(lblNewLabel_1_1);
		
		textFieldNombreUsuario = new JTextField();
		textFieldNombreUsuario.addKeyListener(new KeyAdapter() {
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
				
				
				if(textFieldNombreUsuario.getText().length()> 40) {
					getToolkit().beep();
					e.consume();
					
					JOptionPane.showMessageDialog(null, "Ingresar 40 caracteres o menos");
				}
			}
		});
		textFieldNombreUsuario.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldNombreUsuario.setBackground(new Color(255, 255, 255));
		textFieldNombreUsuario.setBorder(null);
		textFieldNombreUsuario.setColumns(10);
		textFieldNombreUsuario.setBounds(311, 99, 261, 20);
		add(textFieldNombreUsuario);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 153, 255));
		separator_1.setBounds(311, 123, 261, 2);
		add(separator_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Fecha de Nacimiento (YYYY-MM-DD)");
		lblNewLabel_1_2.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(592, 80, 236, 17);
		add(lblNewLabel_1_2);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(0, 153, 255));
		separator_2.setBounds(592, 123, 261, 2);
		add(separator_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Cargo");
		lblNewLabel_1_3.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(30, 143, 261, 17);
		add(lblNewLabel_1_3);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(new Color(0, 153, 255));
		separator_3.setBounds(30, 185, 261, 2);
		add(separator_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Telefono");
		lblNewLabel_1_4.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_4.setBounds(311, 143, 261, 17);
		add(lblNewLabel_1_4);
		
		textFieldTelefonoUsuario = new JTextField();
		textFieldTelefonoUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				char validar=e.getKeyChar();
				
				if(Character.isLetter(validar) || (e.getKeyChar()>32 && e.getKeyChar()<48) || (e.getKeyChar()>57 && e.getKeyChar()<65) || (e.getKeyChar()>90 && e.getKeyChar()<97) || (e.getKeyChar()>122 && e.getKeyChar()<127)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "Ingresar solo numeros");
				}
				
				if(textFieldTelefonoUsuario.getText().length()>= 15) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "Ingresar 15 letras o menos");
				}
				
			}
		});
		textFieldTelefonoUsuario.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldTelefonoUsuario.setBackground(new Color(255, 255, 255));
		textFieldTelefonoUsuario.setBorder(null);
		textFieldTelefonoUsuario.setColumns(10);
		textFieldTelefonoUsuario.setBounds(311, 162, 261, 20);
		add(textFieldTelefonoUsuario);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(new Color(0, 153, 255));
		separator_4.setBounds(311, 185, 261, 2);
		add(separator_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Password");
		lblNewLabel_1_5.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_5.setBounds(592, 143, 261, 17);
		add(lblNewLabel_1_5);
		
		textFieldPasswordUsuario = new JTextField();
		textFieldPasswordUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				if(e.getKeyChar()==61 || e.getKeyChar()==59) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "No se permiten los caracteres = ;");
				}
				
				if(textFieldPasswordUsuario.getText().length()>=10) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "Ingresar 10 caracteres o menos");
				}
				
			}
		});
		textFieldPasswordUsuario.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldPasswordUsuario.setBackground(new Color(255, 255, 255));
		textFieldPasswordUsuario.setBorder(null);
		textFieldPasswordUsuario.setColumns(10);
		textFieldPasswordUsuario.setBounds(592, 162, 261, 20);
		add(textFieldPasswordUsuario);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setForeground(new Color(0, 153, 255));
		separator_5.setBounds(592, 185, 261, 2);
		add(separator_5);
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setFont(new Font("Roboto", Font.BOLD, 12));
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setBorder(null);
		btnRegistrar.setBackground(new Color(0,51,153));
		btnRegistrar.setBounds(30, 209, 113, 25);
		add(btnRegistrar);
		
		btnModificarUsuario = new JButton("MODIFICAR");
		btnModificarUsuario.setForeground(Color.WHITE);
		btnModificarUsuario.setFont(new Font("Roboto", Font.BOLD, 12));
		btnModificarUsuario.setBorder(null);
		btnModificarUsuario.setBackground(new Color(0, 51, 153));
		btnModificarUsuario.setBounds(152, 209, 113, 25);
		add(btnModificarUsuario);
		
		btnEliminarUsuario = new JButton("ELIMINAR");
		btnEliminarUsuario.setForeground(Color.WHITE);
		btnEliminarUsuario.setFont(new Font("Roboto", Font.BOLD, 12));
		btnEliminarUsuario.setBorder(null);
		btnEliminarUsuario.setBackground(new Color(0, 51, 153));
		btnEliminarUsuario.setBounds(275, 209, 113, 25);
		add(btnEliminarUsuario);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(30, 245, 828, 2);
		add(separator_6);
		
		textFieldBuscarUsuarioPorId = new JTextField();
		textFieldBuscarUsuarioPorId.addKeyListener(new KeyAdapter() {
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
				
				
				if(textFieldBuscarUsuarioPorId.getText().length()>= 15) {
					getToolkit().beep();
					e.consume();
					
					JOptionPane.showMessageDialog(null, "Ingresar 15 numeros o menos");
				}
			}
		});
		textFieldBuscarUsuarioPorId.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldBuscarUsuarioPorId.setColumns(10);
		textFieldBuscarUsuarioPorId.setBorder(null);
		textFieldBuscarUsuarioPorId.setBackground(Color.WHITE);
		textFieldBuscarUsuarioPorId.setBounds(30, 260, 700, 20);
		add(textFieldBuscarUsuarioPorId);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setForeground(new Color(0, 153, 255));
		separator_7.setBounds(30, 283, 700, 2);
		add(separator_7);
		
		btnBuscarUsuario = new JButton("BUSCAR");
		btnBuscarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscarUsuario.setForeground(Color.WHITE);
		btnBuscarUsuario.setFont(new Font("Roboto", Font.BOLD, 12));
		btnBuscarUsuario.setBorder(null);
		btnBuscarUsuario.setBackground(new Color(0, 51, 153));
		btnBuscarUsuario.setBounds(740, 260, 113, 25);
		add(btnBuscarUsuario);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(30, 301, 823, 130);
		add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		scrollPane.setBackground(Color.WHITE);
		
		table = new JTable();
		table.setFont(new Font("Roboto", Font.PLAIN, 14));
		table.setBackground(Color.WHITE);
		
		model = new DefaultTableModel();
		
		Object[] column = {"ID","Nombre","Telefono","Cargo","Password","FechaNacimiento"};
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
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLimpiar.setForeground(Color.WHITE);
		btnLimpiar.setFont(new Font("Roboto", Font.BOLD, 12));
		btnLimpiar.setBorder(null);
		btnLimpiar.setBackground(new Color(0, 51, 153));
		btnLimpiar.setBounds(398, 209, 113, 25);
		add(btnLimpiar);
		
		btnTraerInfoDB = new JButton("LISTA DE USUARIOS");
		btnTraerInfoDB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTraerInfoDB.setForeground(Color.WHITE);
		btnTraerInfoDB.setFont(new Font("Roboto", Font.BOLD, 12));
		btnTraerInfoDB.setBorder(null);
		btnTraerInfoDB.setBackground(new Color(0, 51, 153));
		btnTraerInfoDB.setBounds(152, 442, 138, 25);
		add(btnTraerInfoDB);
		
		comboBoxCargo = new JComboBox();
		comboBoxCargo.setBackground(Color.WHITE);
		comboBoxCargo.setFont(new Font("Roboto", Font.PLAIN, 14));
		comboBoxCargo.setModel(new DefaultComboBoxModel(new String[] {"", "administrador", "vendedor"}));
		comboBoxCargo.setBorder(null);
		comboBoxCargo.setBounds(30, 162, 261, 20);
		add(comboBoxCargo);
		
		comboBoxYear = new JComboBox();
		comboBoxYear.setBackground(Color.WHITE);
		comboBoxYear.setFont(new Font("Roboto", Font.PLAIN, 12));
		comboBoxYear.setModel(new DefaultComboBoxModel(new String[] {"", "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022"}));
		comboBoxYear.setBorder(null);
		comboBoxYear.setBounds(592, 99, 56, 20);
		add(comboBoxYear);
		
		JLabel lblNewLabel_2 = new JLabel("-");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(658, 99, 14, 20);
		add(lblNewLabel_2);
		
		comboBoxMonth = new JComboBox();
		comboBoxMonth.setBackground(Color.WHITE);
		comboBoxMonth.setFont(new Font("Roboto", Font.PLAIN, 12));
		comboBoxMonth.setModel(new DefaultComboBoxModel(new String[] {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBoxMonth.setBorder(null);
		comboBoxMonth.setBounds(682, 98, 56, 20);
		add(comboBoxMonth);
		
		JLabel lblNewLabel_2_1 = new JLabel("-");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(748, 99, 14, 20);
		add(lblNewLabel_2_1);
		
		comboBoxDay = new JComboBox();
		comboBoxDay.setBackground(Color.WHITE);
		comboBoxDay.setFont(new Font("Roboto", Font.PLAIN, 12));
		comboBoxDay.setModel(new DefaultComboBoxModel(new String[] {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBoxDay.setBorder(null);
		comboBoxDay.setBounds(772, 98, 56, 20);
		add(comboBoxDay);

	}
	
	
	public boolean validarComboBox(JComboBox comboBox) {
		
		boolean vacio = true;
		
		String valor = comboBox.getSelectedItem().toString();
		
		if(valor != "") {
			
			vacio= false;
		}
			
		return vacio;
	}
	
	
	public void limpiarCasillas() {
		textFieldIdUsuario.setText(null);
		textFieldNombreUsuario.setText(null);
		
		//arregla los jcombobox
		comboBoxYear.setSelectedIndex(0);
		comboBoxMonth.setSelectedIndex(0);
		comboBoxDay.setSelectedIndex(0);
		comboBoxCargo.setSelectedIndex(0);
		
		textFieldTelefonoUsuario.setText(null);
		textFieldPasswordUsuario.setText(null);
		textFieldBuscarUsuarioPorId.setText(null);
	}
	

	
	public boolean validarCamposVacios() {
		boolean camposVacios=false;
		
		if(textFieldIdUsuario.getText().isEmpty() || textFieldNombreUsuario.getText().isEmpty() || validarComboBox(comboBoxYear) || validarComboBox(comboBoxMonth) || validarComboBox(comboBoxDay) || validarComboBox(comboBoxCargo) || textFieldTelefonoUsuario.getText().isEmpty() && textFieldPasswordUsuario.getText().isEmpty()) {
			
			camposVacios=true;
		}else {
			camposVacios=false;
		}
		
		return camposVacios;
	}
	
	public boolean validarCamposLlenos() {
		boolean camposLlenos=false;
		
		if(textFieldIdUsuario.getText().isEmpty()==false && textFieldNombreUsuario.getText().isEmpty()==false && validarComboBox(comboBoxYear)==false && validarComboBox(comboBoxMonth)==false && validarComboBox(comboBoxDay)==false && validarComboBox(comboBoxCargo)==false && validarComboBox(comboBoxCargo)==false && textFieldTelefonoUsuario.getText().isEmpty()==false && textFieldPasswordUsuario.getText().isEmpty()==false) {
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

