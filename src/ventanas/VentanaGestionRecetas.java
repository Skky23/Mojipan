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

public class VentanaGestionRecetas extends JPanel {
	public JTable table;
	DefaultTableModel model;
	public JButton btnBuscarItem;
	public JComboBox comboBoxArgumentoBusqueda;
	

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
		
		btnBuscarItem = new JButton("BUSCAR");
		btnBuscarItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscarItem.setForeground(Color.WHITE);
		btnBuscarItem.setFont(new Font("Roboto", Font.BOLD, 12));
		btnBuscarItem.setBorder(null);
		btnBuscarItem.setBackground(new Color(159,11,47));
		btnBuscarItem.setBounds(249, 79, 142, 25);
		add(btnBuscarItem);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 133, 825, 300);
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
		Object[] column = {"ID", "Nombre", "Cantidad Disponible", "Costo Unidad", "Costo Total"};
		Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		comboBoxArgumentoBusqueda = new JComboBox();
		comboBoxArgumentoBusqueda.setModel(new DefaultComboBoxModel(new String[] {"", "ID", "Nombre"}));
		comboBoxArgumentoBusqueda.setFont(new Font("Roboto", Font.PLAIN, 14));
		comboBoxArgumentoBusqueda.setBounds(30, 78, 177, 25);
		add(comboBoxArgumentoBusqueda);

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
	    
        case "ID":
        	paramentroSQL = "id_insumo"; 
            break;
        case "Nombre":
        	paramentroSQL = "nombre_insumo";
            break;
	    }
		return paramentroSQL;
	}	
	
	/*public boolean validarCamposVacios() {
		boolean camposVacios=false;
		
		if(textFieldNombreProducto.getText().isEmpty() || textFieldCantidad.getText().isEmpty() || textFieldCostoUnidad.getText().isEmpty()){
			
			camposVacios=true;
		}else {
			camposVacios=false;
		}
		return camposVacios;
	}*/
}
