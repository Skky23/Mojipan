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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaGestionInsumos extends JPanel {
	public JTextField textFieldBuscarItem;
	public JTable table;
	DefaultTableModel model;
	public JButton btnBuscarItem;
	public 	JButton btnListaInventario;
	public JButton btnRegistrarItem;
	public JButton btnModificarItem;
	public JButton btnEliminarItem;
	public JButton btnLimpiar;
	public JTextField textFieldCantidad;
	public JTextField textFieldCostoUnidad;
	public JTextField textFieldNombreProducto;
	public JTextField textFieldIdItem;
	public JComboBox comboBoxArgumentoBusqueda;
	

	/**
	 * Create the panel.
	 */
	public VentanaGestionInsumos() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Insumos");
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel.setBounds(30, 30, 260, 26);
		add(lblNewLabel);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(30, 257, 828, 2);
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
		textFieldBuscarItem.setBounds(176, 270, 525, 20);
		add(textFieldBuscarItem);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setForeground(new Color(159,11,47));
		separator_7.setBounds(176, 293, 525, 2);
		add(separator_7);
		
		btnBuscarItem = new JButton("BUSCAR");
		btnBuscarItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscarItem.setForeground(Color.WHITE);
		btnBuscarItem.setFont(new Font("Roboto", Font.BOLD, 12));
		btnBuscarItem.setBorder(null);
		btnBuscarItem.setBackground(new Color(159,11,47));
		btnBuscarItem.setBounds(711, 270, 142, 25);
		add(btnBuscarItem);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(30, 307, 823, 124);
		add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Roboto", Font.PLAIN, 13));
		table.setBackground(Color.WHITE);
		
		model = new DefaultTableModel();
		Object[] column = {"ID", "Nombre", "Cantidad Disponible", "Costo Unidad", "Costo Total"};
		Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		btnListaInventario = new JButton("LISTA INVENTARIO");
		btnListaInventario.setForeground(Color.WHITE);
		btnListaInventario.setFont(new Font("Roboto", Font.BOLD, 12));
		btnListaInventario.setBorder(null);
		btnListaInventario.setBackground(new Color(159,11,47));
		btnListaInventario.setBounds(30, 441, 143, 25);
		add(btnListaInventario);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cantidad");
		lblNewLabel_1_1.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(563, 80, 190, 17);
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
		textFieldCantidad.setBounds(563, 99, 244, 20);
		add(textFieldCantidad);
		
		textFieldCostoUnidad = new JTextField();
		textFieldCostoUnidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				char validar=e.getKeyChar();
				
				if(Character.isLetter(validar) || (e.getKeyChar()>32 && e.getKeyChar()<48) || (e.getKeyChar()>57 && e.getKeyChar()<65) || (e.getKeyChar()>90 && e.getKeyChar()<97) || (e.getKeyChar()>122 && e.getKeyChar()<127)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "Ingresar solo numeros");
				}
				
				if(textFieldCostoUnidad.getText().length()>= 7) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "Ingresar 7 numeros o menos");
				
				}
			}
		});
		textFieldCostoUnidad.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldCostoUnidad.setColumns(10);
		textFieldCostoUnidad.setBorder(null);
		textFieldCostoUnidad.setBackground(Color.WHITE);
		textFieldCostoUnidad.setBounds(30, 160, 120, 20);
		add(textFieldCostoUnidad);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Costo Unidad");
		lblNewLabel_1_1_1_1.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setBounds(30, 141, 247, 17);
		add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Nombre");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1_1.setBounds(293, 80, 247, 17);
		add(lblNewLabel_1_1_1_1_1_1);
		
		textFieldNombreProducto = new JTextField();
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
		textFieldNombreProducto.setBorder(null);
		textFieldNombreProducto.setBackground(Color.WHITE);
		textFieldNombreProducto.setBounds(293, 99, 247, 20);
		add(textFieldNombreProducto);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("ID ");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1.setBounds(30, 80, 244, 17);
		add(lblNewLabel_1_1_1_1_1);
		
		textFieldIdItem = new JTextField();
		textFieldIdItem.setEditable(false);
		textFieldIdItem.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldIdItem.setColumns(10);
		textFieldIdItem.setBorder(null);
		textFieldIdItem.setBackground(Color.WHITE);
		textFieldIdItem.setBounds(30, 99, 244, 20);
		add(textFieldIdItem);
		
		btnRegistrarItem = new JButton("AGREGAR");
		btnRegistrarItem.setForeground(Color.WHITE);
		btnRegistrarItem.setFont(new Font("Roboto", Font.BOLD, 12));
		btnRegistrarItem.setBorder(null);
		btnRegistrarItem.setBackground(new Color(159,11,47));
		btnRegistrarItem.setBounds(30, 221, 113, 25);
		add(btnRegistrarItem);
		
		btnModificarItem = new JButton("MODIFICAR");
		btnModificarItem.setForeground(Color.WHITE);
		btnModificarItem.setFont(new Font("Roboto", Font.BOLD, 12));
		btnModificarItem.setBorder(null);
		btnModificarItem.setBackground(new Color(159,11,47));
		btnModificarItem.setBounds(161, 221, 113, 25);
		add(btnModificarItem);
		
		btnEliminarItem = new JButton("ELIMINAR");
		btnEliminarItem.setForeground(Color.WHITE);
		btnEliminarItem.setFont(new Font("Roboto", Font.BOLD, 12));
		btnEliminarItem.setBorder(null);
		btnEliminarItem.setBackground(new Color(159,11,47));
		btnEliminarItem.setBounds(293, 221, 113, 25);
		add(btnEliminarItem);
		
		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.setForeground(Color.WHITE);
		btnLimpiar.setFont(new Font("Roboto", Font.BOLD, 12));
		btnLimpiar.setBorder(null);
		btnLimpiar.setBackground(new Color(159,11,47));
		btnLimpiar.setBounds(427, 221, 113, 25);
		add(btnLimpiar);
		
		comboBoxArgumentoBusqueda = new JComboBox();
		comboBoxArgumentoBusqueda.setModel(new DefaultComboBoxModel(new String[] {"", "ID", "Nombre"}));
		comboBoxArgumentoBusqueda.setFont(new Font("Roboto", Font.PLAIN, 14));
		comboBoxArgumentoBusqueda.setBounds(30, 270, 136, 25);
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
		separator_7_1_4.setBounds(563, 122, 244, 2);
		add(separator_7_1_4);
		
		JSeparator separator_7_1_1_1 = new JSeparator();
		separator_7_1_1_1.setForeground(new Color(159,11,47));
		separator_7_1_1_1.setBounds(30, 183, 247, 2);
		add(separator_7_1_1_1);

	}
	
	public void limpiarCasillas() {
		
		textFieldCantidad.setText(null);
		textFieldCostoUnidad.setText(null);
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
        	paramentroSQL = "id_insumo"; 
            break;
        case "Nombre":
        	paramentroSQL = "nombre_insumo";
            break;
	    }
		return paramentroSQL;
	}	
	
	public boolean validarCamposVacios() {
		boolean camposVacios=false;
		
		if(textFieldNombreProducto.getText().isEmpty() || textFieldCantidad.getText().isEmpty() || textFieldCostoUnidad.getText().isEmpty()){
			
			camposVacios=true;
		}else {
			camposVacios=false;
		}
		return camposVacios;
	}
}
