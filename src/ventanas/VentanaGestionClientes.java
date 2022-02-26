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
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;

public class VentanaGestionClientes extends JPanel {
	public JTextField textFieldIdCliente;
	public JTextField textFieldNombreCliente;
	public JTextField textFieldTelefonoCliente;
	public JTextField textFieldBuscarClientePorId;
	public JTable table;
	DefaultTableModel model;
	public JButton btnRegistrarCliente;
	public JButton btnModificarCliente;
	public JButton btnEliminarCliente;
	public JButton btnBuscarCliente;
	public JButton btnSeleccionar;
	public JButton btnLimpiar;
	public JButton btnListaDeClientes;
	public JComboBox comboBoxYear;
	public JComboBox comboBoxMonth;
	public JComboBox comboBoxDay;
	

	/**
	 * Create the panel.
	 */
	public VentanaGestionClientes() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestion de Clientes");
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel.setBounds(30, 30, 260, 26);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Id");
		lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1.setBounds(30, 80, 261, 17);
		add(lblNewLabel_1);
		
		textFieldIdCliente = new JTextField();
		textFieldIdCliente.addKeyListener(new KeyAdapter() {
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
				
				
				if(textFieldIdCliente.getText().length()>= 15) {
					getToolkit().beep();
					e.consume();
					
					JOptionPane.showMessageDialog(null, "Ingresar 15 numeros o menos");
				}
			}
		});
		textFieldIdCliente.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldIdCliente.setBackground(new Color(255, 255, 255));
		textFieldIdCliente.setBorder(null);
		textFieldIdCliente.setBounds(30, 99, 261, 20);
		add(textFieldIdCliente);
		textFieldIdCliente.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 153, 255));
		separator.setBounds(30, 123, 261, 2);
		add(separator);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre");
		lblNewLabel_1_1.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(311, 80, 261, 17);
		add(lblNewLabel_1_1);
		
		textFieldNombreCliente = new JTextField();
		textFieldNombreCliente.addKeyListener(new KeyAdapter() {
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
				
				
				if(textFieldNombreCliente.getText().length()> 40) {
					getToolkit().beep();
					e.consume();
					
					JOptionPane.showMessageDialog(null, "Ingresar 40 letras o menos");
				}
			}
		});
		textFieldNombreCliente.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldNombreCliente.setBackground(new Color(255, 255, 255));
		textFieldNombreCliente.setBorder(null);
		textFieldNombreCliente.setColumns(10);
		textFieldNombreCliente.setBounds(311, 99, 261, 20);
		add(textFieldNombreCliente);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 153, 255));
		separator_1.setBounds(311, 123, 261, 2);
		add(separator_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Telefono");
		lblNewLabel_1_2.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(592, 80, 261, 17);
		add(lblNewLabel_1_2);
		
		textFieldTelefonoCliente = new JTextField();
		textFieldTelefonoCliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar=e.getKeyChar();
				
				if(Character.isLetter(validar) || (e.getKeyChar()>32 && e.getKeyChar()<48) || (e.getKeyChar()>57 && e.getKeyChar()<65) || (e.getKeyChar()>90 && e.getKeyChar()<97) || (e.getKeyChar()>122 && e.getKeyChar()<127)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "Ingresar solo numeros");
				}
				
				if(textFieldTelefonoCliente.getText().length()>= 15) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "Ingresar 15 letras o menos");
				}
				
			}
		});
		textFieldTelefonoCliente.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldTelefonoCliente.setBackground(new Color(255, 255, 255));
		textFieldTelefonoCliente.setBorder(null);
		textFieldTelefonoCliente.setColumns(10);
		textFieldTelefonoCliente.setBounds(592, 99, 261, 20);
		add(textFieldTelefonoCliente);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(0, 153, 255));
		separator_2.setBounds(592, 123, 261, 2);
		add(separator_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Fecha de Nacimiento (YYYY-MM-DD)");
		lblNewLabel_1_3.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(30, 143, 261, 17);
		add(lblNewLabel_1_3);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(new Color(0, 153, 255));
		separator_3.setBounds(30, 185, 261, 2);
		add(separator_3);
		
		btnRegistrarCliente = new JButton("REGISTRAR");
		btnRegistrarCliente.setFont(new Font("Roboto", Font.BOLD, 12));
		btnRegistrarCliente.setForeground(Color.WHITE);
		btnRegistrarCliente.setBorder(null);
		btnRegistrarCliente.setBackground(new Color(0,51,153));
		btnRegistrarCliente.setBounds(30, 209, 113, 25);
		add(btnRegistrarCliente);
		
		btnModificarCliente = new JButton("MODIFICAR");
		btnModificarCliente.setForeground(Color.WHITE);
		btnModificarCliente.setFont(new Font("Roboto", Font.BOLD, 12));
		btnModificarCliente.setBorder(null);
		btnModificarCliente.setBackground(new Color(0, 51, 153));
		btnModificarCliente.setBounds(153, 209, 113, 25);
		add(btnModificarCliente);
		
		btnEliminarCliente = new JButton("ELIMINAR");
		btnEliminarCliente.setForeground(Color.WHITE);
		btnEliminarCliente.setFont(new Font("Roboto", Font.BOLD, 12));
		btnEliminarCliente.setBorder(null);
		btnEliminarCliente.setBackground(new Color(0, 51, 153));
		btnEliminarCliente.setBounds(276, 209, 113, 25);
		add(btnEliminarCliente);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(30, 245, 828, 2);
		add(separator_6);
		
		textFieldBuscarClientePorId = new JTextField();
		textFieldBuscarClientePorId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
		textFieldBuscarClientePorId.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldBuscarClientePorId.setColumns(10);
		textFieldBuscarClientePorId.setBorder(null);
		textFieldBuscarClientePorId.setBackground(Color.WHITE);
		textFieldBuscarClientePorId.setBounds(30, 260, 700, 20);
		add(textFieldBuscarClientePorId);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setForeground(new Color(0, 153, 255));
		separator_7.setBounds(30, 283, 700, 2);
		add(separator_7);
		
		btnBuscarCliente = new JButton("BUSCAR");
		btnBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscarCliente.setForeground(Color.WHITE);
		btnBuscarCliente.setFont(new Font("Roboto", Font.BOLD, 12));
		btnBuscarCliente.setBorder(null);
		btnBuscarCliente.setBackground(new Color(0, 51, 153));
		btnBuscarCliente.setBounds(740, 260, 113, 25);
		add(btnBuscarCliente);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(30, 301, 823, 130);
		add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		scrollPane.setBackground(Color.WHITE);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		
		model = new DefaultTableModel();
		Object[] column = {"ID","Nombre","Telefono","FechaNacimiento"};
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
		btnLimpiar.setBounds(398, 209, 113, 25);
		add(btnLimpiar);
		
		btnListaDeClientes = new JButton("LISTA DE CLIENTES");
		btnListaDeClientes.setForeground(Color.WHITE);
		btnListaDeClientes.setFont(new Font("Roboto", Font.BOLD, 12));
		btnListaDeClientes.setBorder(null);
		btnListaDeClientes.setBackground(new Color(0, 51, 153));
		btnListaDeClientes.setBounds(153, 442, 131, 25);
		add(btnListaDeClientes);
		
		comboBoxYear = new JComboBox();
		comboBoxYear.setModel(new DefaultComboBoxModel(new String[] {"", "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022"}));
		comboBoxYear.setFont(new Font("Roboto", Font.PLAIN, 12));
		comboBoxYear.setBorder(null);
		comboBoxYear.setBackground(Color.WHITE);
		comboBoxYear.setBounds(30, 162, 56, 20);
		add(comboBoxYear);
		
		JLabel lblNewLabel_2 = new JLabel("-");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(96, 162, 14, 20);
		add(lblNewLabel_2);
		
		comboBoxMonth = new JComboBox();
		comboBoxMonth.setModel(new DefaultComboBoxModel(new String[] {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBoxMonth.setFont(new Font("Roboto", Font.PLAIN, 12));
		comboBoxMonth.setBorder(null);
		comboBoxMonth.setBackground(Color.WHITE);
		comboBoxMonth.setBounds(120, 162, 56, 20);
		add(comboBoxMonth);
		
		JLabel lblNewLabel_2_1 = new JLabel("-");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(186, 162, 14, 20);
		add(lblNewLabel_2_1);
		
		comboBoxDay = new JComboBox();
		comboBoxDay.setModel(new DefaultComboBoxModel(new String[] {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBoxDay.setFont(new Font("Roboto", Font.PLAIN, 12));
		comboBoxDay.setBorder(null);
		comboBoxDay.setBackground(Color.WHITE);
		comboBoxDay.setBounds(210, 162, 56, 20);
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
		textFieldIdCliente.setText(null);
		textFieldNombreCliente.setText(null);
		comboBoxYear.setSelectedIndex(0);
		comboBoxMonth.setSelectedIndex(0);
		comboBoxDay.setSelectedIndex(0);
		textFieldTelefonoCliente.setText(null);
	}
	
	
	public boolean validarCamposVacios() {
		boolean camposVacios=false;
		
		if(textFieldIdCliente.getText().isEmpty() || textFieldNombreCliente.getText().isEmpty() || validarComboBox(comboBoxYear) || validarComboBox(comboBoxMonth) || validarComboBox(comboBoxDay) || textFieldTelefonoCliente.getText().isEmpty()) {
			
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
		
		if(textFieldIdCliente.getText().isEmpty()==false && textFieldNombreCliente.getText().isEmpty()==false && validarComboBox(comboBoxYear)==false && validarComboBox(comboBoxMonth)==false && validarComboBox(comboBoxDay)==false && textFieldTelefonoCliente.getText().isEmpty()==false) {
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

