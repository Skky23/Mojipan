package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import modelo.Conexion;
import modelo.ConsultaUsuario;
import modelo.Usuario;
import ventanas.VentanaBienvenida;
import ventanas.VentanaLogin;
import ventanas.VentanaPrincipal;



public class ControladorLogin implements ActionListener, KeyListener {
	
	VentanaLogin ventanaLogin;
	VentanaPrincipal ventanaPrincipal;
	VentanaBienvenida  ventanaBienvenida = new VentanaBienvenida();
	Conexion conexion;
	Connection con;
	ConsultaUsuario consultaUsuario = new ConsultaUsuario();
	Usuario persona = new Usuario();
	ControladorMenuPrincipal controladorMenuPrincipal;
	
	
	 public ControladorLogin (VentanaLogin ventanaLogin){
	        this.ventanaLogin = ventanaLogin;
	        this.ventanaLogin.btnEntrar.addActionListener(this);
	    }
	 
	 //metodo para iniciar la vista
	 public void iniciar(){
		 
		 ventanaLogin.setTitle("Login");
		 ventanaLogin.setLocationRelativeTo(null);
		 ventanaLogin.setVisible(true);
		 
	    }

	 
	
	//para validar si el usuario esta en la base de datos
	public void validarUsuario() {
		
		String usuario = ventanaLogin.usuarioIngresado();
		String password = ventanaLogin.passwordIngresado();
		
		if(password.length() == 0 || usuario.length() == 0 || (usuario.equals("Ingrese su usuario") && password.equals("**********"))) {
			
			JOptionPane.showMessageDialog(null, "Ingrese su Usuario y Password");
			
		}else {
			
			conexion = new Conexion();
			con = conexion.getConnection();

			int userId = Integer.parseInt(ventanaLogin.usuarioIngresado());
			String sql = "select * from usuarios where id_usuario='"+userId+"' and contraseña='"+password+"'";
		
			try {
				
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				
				
				if(rs.next()) {
					
					//guardo la informacion del usuario que se encuentra en la base de datos en el objeto persona
					consultaUsuario.buscar(persona, userId);
						iniciarVentanaPrincipal();
						try{
			                con.close();
			            }catch (SQLException e){
			                System.err.println(e);
			            }	
				} else {
					
					JOptionPane.showMessageDialog(null, "Error de Acceso");
					
				}
				
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
			}
			
		}
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == ventanaLogin.btnEntrar) {
			
			validarUsuario();
	
		}
		
	}
	
	
	private void iniciarVentanaPrincipal() {
		ventanaLogin.dispose();
		ventanaPrincipal = new VentanaPrincipal();
		ventanaPrincipal.setTitle("Menu Principal");
		

		
		LocalDate date = LocalDate.now();
		int mes = date.getMonthValue();
		int dia = date.getDayOfMonth();
		
		ventanaPrincipal.textFieldFechaSistema.setText("Hoy es " + obtenerMes(mes)+ " " + dia + " " + "del año " + 2022 );
		ventanaPrincipal.textFieldUsuarioConectado.setText(persona.getNombre());
		ventanaPrincipal.setVisible(true);
		ventanaPrincipal.setLocationRelativeTo(null);
		
		ventanaBienvenida.setSize(885, 485);
		ventanaBienvenida.setLocation(0, 0);
		ventanaPrincipal.panelPrincipalVentanas.add(ventanaBienvenida);
		ventanaPrincipal.panelPrincipalVentanas.revalidate();
		ventanaPrincipal.panelPrincipalVentanas.repaint();
		
		
		controladorMenuPrincipal = new ControladorMenuPrincipal(ventanaPrincipal, persona);
		
	}
	
	
	
	public String obtenerMes(int mes) {
		
		String mesString;
		
		switch (mes) {
        case 1:  mesString = "Enero";
                 break;
        case 2:  mesString  = "Febrero";
                 break;
        case 3:  mesString = "Marzo";
                 break;
        case 4:  mesString = "Abril";
                 break;
        case 5:  mesString = "Mayo";
                 break;
        case 6:  mesString = "Junio";
                 break;
        case 7:  mesString = "Julio";
                 break;
        case 8:  mesString = "Agosto";
                 break;
        case 9:  mesString = "Septiembre";
                 break;
        case 10: mesString = "Octubre";
                 break;
        case 11: mesString = "Noviembre";
                 break;
        case 12: mesString = "Diciembre";
                 break;
        default: mesString = "Invalid month";
                 break;
        }
	
		return mesString;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			validarUsuario();
		}
			
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
