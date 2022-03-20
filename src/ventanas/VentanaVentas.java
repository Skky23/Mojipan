package ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;

public class VentanaVentas extends JPanel {
	
	public JTextField textFieldIdItem;
	public JTable table;
	public DefaultTableModel model;
	public DefaultTableModel model_1;
	public JButton btnEliminarRegistroTabla;
	public JButton btnLimpiarRegistrosTabla;
	public JButton btnVenta;
	public JButton btnAgregarItem;
	public JComboBox comboCantidad;
	public JTable table_1;
	private JLabel lblNewLabel_1_3;
	public JTextField textFieldTotal;
	public JTextField textFieldIDEmpleado;
	public JSeparator separator_2;
	public JLabel lblNewLabel_1_4;
	private JLabel lblNewLabel_1_5;
	public JComboBox comboPago;

	/**
	 * Create the panel.
	 */
	public VentanaVentas() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ventas");
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel.setBounds(30, 30, 260, 26);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID producto:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1.setBounds(30, 99, 97, 27);
		add(lblNewLabel_1);
		
		textFieldIdItem = new JTextField();
		textFieldIdItem.addKeyListener(new KeyAdapter() {
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
				
				
				if(textFieldIdItem.getText().length()>= 15) {
					getToolkit().beep();
					e.consume();
					
					JOptionPane.showMessageDialog(null, "Ingresar 15 numeros o menos");
				}
				
			}
		});
		textFieldIdItem.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldIdItem.setBackground(new Color(255, 255, 255));
		textFieldIdItem.setBorder(null);
		textFieldIdItem.setBounds(147, 103, 253, 20);
		add(textFieldIdItem);
		textFieldIdItem.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(159, 11, 47));
		separator.setBounds(147, 125, 253, 2);
		add(separator);
		
		JLabel lblNewLabel_1_2 = new JLabel("Cantidad:");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(30, 209, 69, 26);
		add(lblNewLabel_1_2);
		
		btnEliminarRegistroTabla = new JButton("QUITAR PRODUCTO");
		btnEliminarRegistroTabla.setIcon(new ImageIcon(VentanaVentas.class.getResource("/imagenes/iconRemover.png")));
		btnEliminarRegistroTabla.setForeground(Color.WHITE);
		btnEliminarRegistroTabla.setFont(new Font("Roboto", Font.BOLD, 12));
		btnEliminarRegistroTabla.setBorder(null);
		btnEliminarRegistroTabla.setBackground(new Color(159, 11, 47));
		btnEliminarRegistroTabla.setBounds(30, 419, 142, 26);
		add(btnEliminarRegistroTabla);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(30, 245, 825, 2);
		add(separator_6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 257, 825, 148);
		add(scrollPane);
		scrollPane.setBackground(Color.WHITE);
		
		table = new JTable();
		table.setFont(new Font("Roboto", Font.PLAIN, 13));
		table.setBackground(Color.WHITE);
		
		model = new DefaultTableModel();
		
		Object[] column = {"ID","Producto","Cantidad","Precio unitario","Subtotal"};
		Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		
		
		btnVenta = new JButton("GENERAR VENTA");
		btnVenta.setIcon(new ImageIcon(VentanaVentas.class.getResource("/imagenes/iconVentas.png")));
		btnVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVenta.setForeground(Color.WHITE);
		btnVenta.setFont(new Font("Roboto", Font.BOLD, 12));
		btnVenta.setBorder(null);
		btnVenta.setBackground(new Color(159, 11, 47));
		btnVenta.setBounds(447, 415, 131, 35);
		add(btnVenta);
		
		btnLimpiarRegistrosTabla = new JButton("QUITAR TODO");
		btnLimpiarRegistrosTabla.setIcon(new ImageIcon(VentanaVentas.class.getResource("/imagenes/iconRemover.png")));
		btnLimpiarRegistrosTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLimpiarRegistrosTabla.setForeground(Color.WHITE);
		btnLimpiarRegistrosTabla.setFont(new Font("Roboto", Font.BOLD, 12));
		btnLimpiarRegistrosTabla.setBorder(null);
		btnLimpiarRegistrosTabla.setBackground(new Color(159, 11, 47));
		btnLimpiarRegistrosTabla.setBounds(193, 419, 142, 26);
		add(btnLimpiarRegistrosTabla);
		
		comboCantidad = new JComboBox();
		comboCantidad.setBackground(Color.WHITE);
		comboCantidad.setFont(new Font("Roboto", Font.PLAIN, 12));
		comboCantidad.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50"}));
		comboCantidad.setBorder(null);
		comboCantidad.setBounds(109, 215, 158, 20);
		add(comboCantidad);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(434, 30, 421, 156);
		add(scrollPane_2);
		
		table_1 = new JTable();
		table_1.setFont(new Font("Roboto", Font.PLAIN, 13));
		table_1.setBackground(Color.WHITE);
		
		model_1 = new DefaultTableModel();
		
		Object[] column_1 = {"ID","Nombre","Cantidad","Precio"};
		Object[] row_1 = new Object[0];
		model_1.setColumnIdentifiers(column_1);
		table_1.setModel(model_1);
		
		scrollPane_2.setViewportView(table_1);
		
		lblNewLabel_1_3 = new JLabel("Total");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(610, 421, 84, 20);
		add(lblNewLabel_1_3);
		
		textFieldTotal = new JTextField();
		textFieldTotal.setBackground(Color.WHITE);
		textFieldTotal.setEditable(false);
		textFieldTotal.setColumns(10);
		textFieldTotal.setBounds(704, 421, 151, 20);
		add(textFieldTotal);
		
		btnAgregarItem = new JButton("AGREGAR");
		btnAgregarItem.setIcon(new ImageIcon(VentanaVentas.class.getResource("/imagenes/iconAgregar.png")));
		btnAgregarItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAgregarItem.setForeground(Color.WHITE);
		btnAgregarItem.setFont(new Font("Roboto", Font.BOLD, 12));
		btnAgregarItem.setBorder(null);
		btnAgregarItem.setBackground(new Color(159, 11, 47));
		btnAgregarItem.setBounds(292, 209, 95, 26);
		add(btnAgregarItem);
		
		textFieldIDEmpleado = new JTextField();
		textFieldIDEmpleado.setFont(new Font("Dialog", Font.PLAIN, 14));
		textFieldIDEmpleado.setColumns(10);
		textFieldIDEmpleado.setBorder(null);
		textFieldIDEmpleado.setBackground(Color.WHITE);
		textFieldIDEmpleado.setBounds(147, 160, 253, 20);
		add(textFieldIDEmpleado);
		
		separator_2 = new JSeparator();
		separator_2.setForeground(new Color(159, 11, 47));
		separator_2.setBounds(147, 184, 253, 2);
		add(separator_2);
		
		lblNewLabel_1_4 = new JLabel("ID empleado:");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_4.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1_4.setBounds(31, 160, 106, 26);
		add(lblNewLabel_1_4);
		
		lblNewLabel_1_5 = new JLabel("Tipo de pago:");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_5.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1_5.setBounds(481, 209, 97, 26);
		add(lblNewLabel_1_5);
		
		comboPago = new JComboBox();
		comboPago.setBackground(Color.WHITE);
		comboPago.setFont(new Font("Roboto", Font.PLAIN, 12));
		comboPago.setModel(new DefaultComboBoxModel (new String[] {"","Contado","Fiado"}));
		comboPago.setBorder(null);
		comboPago.setBounds(588, 214, 158, 20);
		add(comboPago);
		
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
		
	}
	
	public void borrarElementosTabla(DefaultTableModel model) {
		 
        int numeroFilasBorrar = model.getRowCount();
        //remove rows from the bottom one by one
        for (int i = numeroFilasBorrar - 1; i >= 0; i--) {
            model.removeRow(i);
        }
	}
}
