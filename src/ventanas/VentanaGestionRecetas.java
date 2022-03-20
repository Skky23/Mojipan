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
import javax.swing.ImageIcon;

public class VentanaGestionRecetas extends JPanel {
	public JTable table;
	DefaultTableModel model;
	public JButton btnObtenerReceta;
	public JComboBox comboBoxRecetas;
	public JTextField textFieldCantidadProducto;
	public JTextField textFieldPesoUnidad;
	public JTextField textFieldCostoUnidad;
	public JTextField textFieldMargenGanancia;
	public JTextField textFieldPrecioUnidad;
	public JButton btnCalcularPrecio;
	public JButton btnCalcularCostoUnidad;
	public JButton btnCrearProductos;

	/**
	 * Create the panel.
	 */
	public VentanaGestionRecetas() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Recetas");
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel.setBounds(30, 30, 260, 26);
		add(lblNewLabel);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(30, 114, 828, 2);
		add(separator_6);
		
		btnObtenerReceta = new JButton("TRAER RECETA");
		btnObtenerReceta.setIcon(new ImageIcon(VentanaGestionRecetas.class.getResource("/imagenes/iconLibro.png")));
		btnObtenerReceta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnObtenerReceta.setForeground(Color.WHITE);
		btnObtenerReceta.setFont(new Font("Roboto", Font.BOLD, 12));
		btnObtenerReceta.setBorder(null);
		btnObtenerReceta.setBackground(new Color(159,11,47));
		btnObtenerReceta.setBounds(249, 79, 162, 25);
		add(btnObtenerReceta);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 133, 825, 170);
		add(scrollPane);
	
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		table = new JTable();
		table.setFont(new Font("Roboto", Font.PLAIN, 13));
		table.setBackground(Color.WHITE);
		
		model = new DefaultTableModel();
		Object[] column = {"Nombre Ingrediente", "Peso(gr)", "Costo Gramo", "Costo Total"};
		Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		comboBoxRecetas = new JComboBox();
		comboBoxRecetas.setModel(new DefaultComboBoxModel(new String[] {"", "pan rey barra"}));
		comboBoxRecetas.setFont(new Font("Roboto", Font.PLAIN, 14));
		comboBoxRecetas.setBounds(30, 78, 177, 25);
		add(comboBoxRecetas);
		
		JLabel lblNewLabel_1 = new JLabel("Numero de Unidades:");
		lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(30, 320, 142, 20);
		add(lblNewLabel_1);
		
		textFieldCantidadProducto = new JTextField();
		textFieldCantidadProducto.setBounds(209, 321, 104, 20);
		add(textFieldCantidadProducto);
		textFieldCantidadProducto.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Peso Unidad:");
		lblNewLabel_1_1.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(344, 320, 96, 20);
		add(lblNewLabel_1_1);
		
		textFieldPesoUnidad = new JTextField();
		textFieldPesoUnidad.setColumns(10);
		textFieldPesoUnidad.setBounds(450, 321, 104, 20);
		add(textFieldPesoUnidad);
		
		JLabel lblNewLabel_1_2 = new JLabel("Costo Unidad:");
		lblNewLabel_1_2.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(30, 351, 142, 20);
		add(lblNewLabel_1_2);
		
		textFieldCostoUnidad = new JTextField();
		textFieldCostoUnidad.setEditable(false);
		textFieldCostoUnidad.setColumns(10);
		textFieldCostoUnidad.setBounds(209, 352, 104, 20);
		add(textFieldCostoUnidad);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Margen de Ganancia (%):");
		lblNewLabel_1_1_1.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(30, 382, 169, 20);
		add(lblNewLabel_1_1_1);
		
		textFieldMargenGanancia = new JTextField();
		textFieldMargenGanancia.setColumns(10);
		textFieldMargenGanancia.setBounds(209, 383, 104, 20);
		add(textFieldMargenGanancia);
		
		btnCalcularCostoUnidad = new JButton("CALCULAR COSTO UNIDAD");
		btnCalcularCostoUnidad.setIcon(new ImageIcon(VentanaGestionRecetas.class.getResource("/imagenes/iconCalculadora.png")));
		btnCalcularCostoUnidad.setForeground(Color.WHITE);
		btnCalcularCostoUnidad.setFont(new Font("Roboto", Font.BOLD, 12));
		btnCalcularCostoUnidad.setBorder(null);
		btnCalcularCostoUnidad.setBackground(new Color(159, 11, 47));
		btnCalcularCostoUnidad.setBounds(344, 370, 210, 20);
		add(btnCalcularCostoUnidad);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Precio Unidad:");
		lblNewLabel_1_1_1_1.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(30, 413, 169, 20);
		add(lblNewLabel_1_1_1_1);
		
		textFieldPrecioUnidad = new JTextField();
		textFieldPrecioUnidad.setEditable(false);
		textFieldPrecioUnidad.setColumns(10);
		textFieldPrecioUnidad.setBounds(209, 414, 104, 20);
		add(textFieldPrecioUnidad);
		
		btnCalcularPrecio = new JButton("CALCULAR PRECIO");
		btnCalcularPrecio.setIcon(new ImageIcon(VentanaGestionRecetas.class.getResource("/imagenes/iconCalculadora.png")));
		btnCalcularPrecio.setForeground(Color.WHITE);
		btnCalcularPrecio.setFont(new Font("Roboto", Font.BOLD, 12));
		btnCalcularPrecio.setBorder(null);
		btnCalcularPrecio.setBackground(new Color(159, 11, 47));
		btnCalcularPrecio.setBounds(344, 413, 210, 20);
		add(btnCalcularPrecio);
		
		btnCrearProductos = new JButton("CREAR PRODUCTO");
		btnCrearProductos.setIcon(new ImageIcon(VentanaGestionRecetas.class.getResource("/imagenes/iconAgregar.png")));
		btnCrearProductos.setForeground(Color.WHITE);
		btnCrearProductos.setFont(new Font("Roboto", Font.BOLD, 12));
		btnCrearProductos.setBorder(null);
		btnCrearProductos.setBackground(new Color(159, 11, 47));
		btnCrearProductos.setBounds(30, 444, 283, 20);
		add(btnCrearProductos);

	}
	
	public void limpiarCasillas() {
		
		
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
	    
        case "pan rey barra":
        	paramentroSQL = "panreybarra"; 
            break;
	    }
		return paramentroSQL;
	}	
}
