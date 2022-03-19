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
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class VentanaGestionInventario extends JPanel {
	public JTextField textFieldBuscarItem;
	public JTable table;
	DefaultTableModel model;
	public JButton btnBuscarItem;
	public 	JButton btnListaInventario;
	public JButton btnModificarItem;
	public JButton btnLimpiar;
	public JTextField textFieldCantidad;
	public JTextField textFieldNombreProducto;
	public JTextField textFieldIdItem;
	public JComboBox comboBoxArgumentoBusqueda;
	

	/**
	 * Create the panel.
	 */
	public VentanaGestionInventario() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Productos");
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel.setBounds(30, 30, 260, 26);
		add(lblNewLabel);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(30, 183, 828, 2);
		add(separator_6);
		
		textFieldBuscarItem = new JTextField();
		textFieldBuscarItem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				
				if(e.getKeyChar()==61 || e.getKeyChar()==59) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "No se permiten los caracteres = ;");
				}
	
				
				if(textFieldBuscarItem.getText().length()>= 50) {
					getToolkit().beep();
					e.consume();
					
					JOptionPane.showMessageDialog(null, "Ingresar 50 caracteres o menos");
				}
				
			}
		});
		textFieldBuscarItem.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldBuscarItem.setColumns(10);
		textFieldBuscarItem.setBorder(null);
		textFieldBuscarItem.setBackground(Color.WHITE);
		textFieldBuscarItem.setBounds(176, 196, 525, 20);
		add(textFieldBuscarItem);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setForeground(new Color(159,11,47));
		separator_7.setBounds(176, 219, 525, 2);
		add(separator_7);
		
		btnBuscarItem = new JButton("BUSCAR");
		btnBuscarItem.setIcon(new ImageIcon(VentanaGestionInventario.class.getResource("/imagenes/iconBuscar.png")));
		btnBuscarItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscarItem.setForeground(Color.WHITE);
		btnBuscarItem.setFont(new Font("Roboto", Font.BOLD, 12));
		btnBuscarItem.setBorder(null);
		btnBuscarItem.setBackground(new Color(159,11,47));
		btnBuscarItem.setBounds(711, 196, 142, 25);
		add(btnBuscarItem);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 236, 823, 185);
		add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Roboto", Font.PLAIN, 13));
		table.setBackground(Color.WHITE);
		
		model = new DefaultTableModel();
		Object[] column = {"ID", "Nombre", "Cantidad Disponible","Precio Unidad","Costo Unidad"};
		Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		btnListaInventario = new JButton("LISTA INVENTARIO");
		btnListaInventario.setIcon(new ImageIcon(VentanaGestionInventario.class.getResource("/imagenes/iconLista.png")));
		btnListaInventario.setForeground(Color.WHITE);
		btnListaInventario.setFont(new Font("Roboto", Font.BOLD, 12));
		btnListaInventario.setBorder(null);
		btnListaInventario.setBackground(new Color(159,11,47));
		btnListaInventario.setBounds(30, 432, 165, 25);
		add(btnListaInventario);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cantidad");
		lblNewLabel_1_1.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(562, 80, 244, 17);
		add(lblNewLabel_1_1);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			
				char validar=e.getKeyChar();
				
				if(Character.isLetter(validar) || (e.getKeyChar()>32 && e.getKeyChar()<48) || (e.getKeyChar()>57 && e.getKeyChar()<65) || (e.getKeyChar()>90 && e.getKeyChar()<97) || (e.getKeyChar()>122 && e.getKeyChar()<127)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "Ingresar solo numeros");
				}
				
				if(textFieldCantidad.getText().length()>= 7) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "Ingresar 7 numeros o menos");
					
				}	
			}
		});
		textFieldCantidad.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldCantidad.setColumns(10);
		textFieldCantidad.setBorder(null);
		textFieldCantidad.setBackground(Color.WHITE);
		textFieldCantidad.setBounds(562, 99, 244, 20);
		add(textFieldCantidad);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Nombre");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1_1.setBounds(293, 80, 247, 17);
		add(lblNewLabel_1_1_1_1_1_1);
		
		textFieldNombreProducto = new JTextField();
		textFieldNombreProducto.setEditable(false);
		textFieldNombreProducto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				if(e.getKeyChar()==61 || e.getKeyChar()==59) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "No se permiten los caracteres = ;");
				}
				
				if(textFieldNombreProducto.getText().length()>=40) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "Ingresar 40 caracteres o menos");
				}
				
			}
		});
		textFieldNombreProducto.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldNombreProducto.setColumns(10);
		textFieldNombreProducto.setBackground(SystemColor.menu);
		textFieldNombreProducto.setBounds(293, 99, 247, 20);
		add(textFieldNombreProducto);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("ID Item");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1.setBounds(30, 80, 244, 17);
		add(lblNewLabel_1_1_1_1_1);
		
		textFieldIdItem = new JTextField();
		textFieldIdItem.setEditable(false);
		textFieldIdItem.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldIdItem.setColumns(10);
		textFieldIdItem.setBackground(SystemColor.menu);
		textFieldIdItem.setBounds(30, 99, 244, 20);
		add(textFieldIdItem);
		
		btnModificarItem = new JButton("MODIFICAR");
		btnModificarItem.setIcon(new ImageIcon(VentanaGestionInventario.class.getResource("/imagenes/iconEditar.png")));
		btnModificarItem.setForeground(Color.WHITE);
		btnModificarItem.setFont(new Font("Roboto", Font.BOLD, 12));
		btnModificarItem.setBorder(null);
		btnModificarItem.setBackground(new Color(159,11,47));
		btnModificarItem.setBounds(30, 147, 113, 25);
		add(btnModificarItem);
		
		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.setIcon(new ImageIcon(VentanaGestionInventario.class.getResource("/imagenes/iconBarrer.png")));
		btnLimpiar.setForeground(Color.WHITE);
		btnLimpiar.setFont(new Font("Roboto", Font.BOLD, 12));
		btnLimpiar.setBorder(null);
		btnLimpiar.setBackground(new Color(159,11,47));
		btnLimpiar.setBounds(153, 147, 113, 25);
		add(btnLimpiar);
		
		comboBoxArgumentoBusqueda = new JComboBox();
		comboBoxArgumentoBusqueda.setModel(new DefaultComboBoxModel(new String[] {"", "ID", "Nombre"}));
		comboBoxArgumentoBusqueda.setFont(new Font("Roboto", Font.PLAIN, 14));
		comboBoxArgumentoBusqueda.setBounds(30, 196, 136, 25);
		add(comboBoxArgumentoBusqueda);
		
		JSeparator separator_7_1 = new JSeparator();
		separator_7_1.setForeground(new Color(159,11,47));
		separator_7_1.setBounds(30, 122, 244, 2);
		add(separator_7_1);
		
		JSeparator separator_7_1_1 = new JSeparator();
		separator_7_1_1.setForeground(new Color(159,11,47));
		separator_7_1_1.setBounds(293, 122, 247, 2);
		add(separator_7_1_1);
		
		JSeparator separator_7_1_4 = new JSeparator();
		separator_7_1_4.setForeground(new Color(159,11,47));
		separator_7_1_4.setBounds(562, 122, 244, 2);
		add(separator_7_1_4);

	}
	
	public void limpiarCasillas() {
		
		textFieldCantidad.setText(null);
		textFieldNombreProducto.setText(null);
		textFieldIdItem.setText(null);		
	}
	
	
	public void borrarElementosTabla() {
		 
        int numeroFilasBorrar = model.getRowCount();
        //remove rows from the bottom one by one
        for (int i = numeroFilasBorrar - 1; i >= 0; i--) {
            model.removeRow(i);
        }
	}
	
	public String parametroBusquedaItem(JComboBox box) {
		
		String parametro = box.getSelectedItem().toString();
		String paramentroSQL = "";
		
	    switch (parametro) {
	    
        case "ID":
        	paramentroSQL = "id_producto"; 
            break;
        case "Nombre":
        	paramentroSQL = "nombre_producto";
            break;
	    }
		
		return paramentroSQL;
	}
	
	
}
