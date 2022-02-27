package principal;

import java.io.IOException;

import controlador.ControladorLogin;
import ventanas.VentanaLogin;

public class MainMojipan {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		VentanaLogin ventanaLogin = new VentanaLogin();
		ControladorLogin controladorLogin = new ControladorLogin(ventanaLogin);
		controladorLogin.iniciar();

	}

}
