package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.ConsultaReceta;
import ventanas.VentanaGestionRecetas;

public class ControladorRecetas implements ActionListener{

	VentanaGestionRecetas ventanaGestionRecetas ;
	ConsultaReceta consultaReceta = new ConsultaReceta();
	
	public ControladorRecetas(VentanaGestionRecetas ventanaGestionRecetas) {
		this.ventanaGestionRecetas=ventanaGestionRecetas;
		this.ventanaGestionRecetas.btnObtenerReceta.addActionListener(this);
		this.ventanaGestionRecetas.btnCalcularPrecio.addActionListener(this);
		this.ventanaGestionRecetas.btnCalcularCostoUnidad.addActionListener(this);
		this.ventanaGestionRecetas.btnCrearProductos.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == ventanaGestionRecetas.btnCalcularCostoUnidad) {
			int pesoUnidad = Integer.parseInt(ventanaGestionRecetas.textFieldPesoUnidad.getText());
			int numeroUnidades = Integer.parseInt(ventanaGestionRecetas.textFieldCantidadProducto.getText());
			
			consultaReceta.calcularValoresPesoTabla(ventanaGestionRecetas, numeroUnidades, pesoUnidad);
			int costoTotal = calcularTotalTabla();
			int costoDirecto = costoTotal/numeroUnidades;
			int costoIndirecto = (int) (costoDirecto*0.4);
			int costoPan = costoDirecto + costoIndirecto;
			
			ventanaGestionRecetas.textFieldCostoUnidad.setText(String.valueOf(costoPan));
			
		}
			
		if(e.getSource() == ventanaGestionRecetas.btnCalcularPrecio) {
			
			int costo = Integer.parseInt(ventanaGestionRecetas.textFieldCostoUnidad.getText());
			double porcentaje = Double.parseDouble(ventanaGestionRecetas.textFieldMargenGanancia.getText());
			porcentaje = porcentaje/100;
			porcentaje = porcentaje +1;
			int precio = (int) Math.round(costo*porcentaje);
		
			ventanaGestionRecetas.textFieldPrecioUnidad.setText(String.valueOf(precio));
		}
		
		if(e.getSource() == ventanaGestionRecetas.btnObtenerReceta) {
			consultaReceta.traerNombreInsumos(ventanaGestionRecetas.table, ventanaGestionRecetas.parametroBusquedaItem(ventanaGestionRecetas.comboBoxRecetas));
			consultaReceta.calcularValoresCostoGramoTablaReceta(ventanaGestionRecetas.table);
		}
		
		if(e.getSource() == ventanaGestionRecetas.btnCrearProductos) {
			consultaReceta.crearProducto(ventanaGestionRecetas);
			consultaReceta.actualizarCantidadInsumos(ventanaGestionRecetas);
		}
		
	}
	
	
	public int calcularTotalTabla() {
		
		int costoDirecto = 0;
		
		for(int i=0; i<9;i++) {
			
			double costoUnidad = (double)ventanaGestionRecetas.table.getValueAt(i, 2);
			int peso = (int)ventanaGestionRecetas.table.getValueAt(i, 1);
			
			int total = (int) Math.round(costoUnidad*peso);
			
			costoDirecto = costoDirecto + total;
			ventanaGestionRecetas.table.setValueAt(total, i, 3);
		}
		
		
		return costoDirecto;
		
	}
	
}
