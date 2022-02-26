package controlador;

import modelo.Usuario;
import ventanas.VentanaPerfil;

public class ControladorPerfil {
	
	Usuario persona;
	VentanaPerfil ventanaPerfil;
	
	public ControladorPerfil(VentanaPerfil ventanaPerfil, Usuario persona ) {
		this.ventanaPerfil=ventanaPerfil;
		this.persona=persona;
	}
	
	
	public void ponerInformacionUsuario() {
		ventanaPerfil.textFieldIdUsuario.setText(String.valueOf(persona.getId()));
		ventanaPerfil.textFieldNombreUsuario.setText(persona.getNombre());
		ventanaPerfil.textFieldFechaNacimientoUsuario.setText(persona.getFechaNacimiento().toString());
		ventanaPerfil.textFieldCargoUsuario.setText(persona.getCargo());
		ventanaPerfil.textFieldTelefonoUsuario.setText(persona.getTelefono());
		ventanaPerfil.textFieldPasswordUsuario.setText(persona.getPassword());
		
	}
	

}