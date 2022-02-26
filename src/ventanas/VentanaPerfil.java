package ventanas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class VentanaPerfil extends JPanel {
	public JTextField textFieldIdUsuario;
	public JTextField textFieldNombreUsuario;
	public JTextField textFieldFechaNacimientoUsuario;
	public JTextField textFieldCargoUsuario;
	public JTextField textFieldTelefonoUsuario;
	public JTextField textFieldPasswordUsuario;

	/**
	 * Create the panel.
	 */
	public VentanaPerfil() {
		setBorder(null);
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Perfil de Usuario");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel.setBounds(30, 30, 260, 26);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Id");
		lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1.setBounds(30, 81, 370, 17);
		add(lblNewLabel_1);
		
		textFieldIdUsuario = new JTextField();
		textFieldIdUsuario.setEditable(false);
		textFieldIdUsuario.setForeground(Color.LIGHT_GRAY);
		textFieldIdUsuario.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldIdUsuario.setBackground(new Color(255, 255, 255));
		textFieldIdUsuario.setBorder(null);
		textFieldIdUsuario.setBounds(30, 108, 370, 20);
		add(textFieldIdUsuario);
		textFieldIdUsuario.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 153, 255));
		separator.setBounds(30, 131, 370, 2);
		add(separator);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre");
		lblNewLabel_1_1.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(30, 178, 370, 17);
		add(lblNewLabel_1_1);
		
		textFieldNombreUsuario = new JTextField();
		textFieldNombreUsuario.setEditable(false);
		textFieldNombreUsuario.setForeground(Color.LIGHT_GRAY);
		textFieldNombreUsuario.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldNombreUsuario.setBackground(new Color(255, 255, 255));
		textFieldNombreUsuario.setBorder(null);
		textFieldNombreUsuario.setColumns(10);
		textFieldNombreUsuario.setBounds(30, 206, 370, 20);
		add(textFieldNombreUsuario);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 153, 255));
		separator_1.setBounds(30, 229, 360, 2);
		add(separator_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Fecha de Nacimiento");
		lblNewLabel_1_2.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(30, 276, 370, 17);
		add(lblNewLabel_1_2);
		
		textFieldFechaNacimientoUsuario = new JTextField();
		textFieldFechaNacimientoUsuario.setEditable(false);
		textFieldFechaNacimientoUsuario.setForeground(Color.LIGHT_GRAY);
		textFieldFechaNacimientoUsuario.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldFechaNacimientoUsuario.setBackground(new Color(255, 255, 255));
		textFieldFechaNacimientoUsuario.setBorder(null);
		textFieldFechaNacimientoUsuario.setColumns(10);
		textFieldFechaNacimientoUsuario.setBounds(30, 304, 360, 20);
		add(textFieldFechaNacimientoUsuario);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(0, 153, 255));
		separator_2.setBounds(30, 327, 370, 2);
		add(separator_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Cargo");
		lblNewLabel_1_3.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(462, 80, 370, 17);
		add(lblNewLabel_1_3);
		
		textFieldCargoUsuario = new JTextField();
		textFieldCargoUsuario.setEditable(false);
		textFieldCargoUsuario.setForeground(Color.LIGHT_GRAY);
		textFieldCargoUsuario.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldCargoUsuario.setBackground(new Color(255, 255, 255));
		textFieldCargoUsuario.setBorder(null);
		textFieldCargoUsuario.setColumns(10);
		textFieldCargoUsuario.setBounds(462, 108, 370, 20);
		add(textFieldCargoUsuario);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(new Color(0, 153, 255));
		separator_3.setBounds(462, 131, 370, 2);
		add(separator_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Telefono");
		lblNewLabel_1_4.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_4.setBounds(462, 178, 370, 17);
		add(lblNewLabel_1_4);
		
		textFieldTelefonoUsuario = new JTextField();
		textFieldTelefonoUsuario.setEditable(false);
		textFieldTelefonoUsuario.setForeground(Color.LIGHT_GRAY);
		textFieldTelefonoUsuario.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldTelefonoUsuario.setBackground(new Color(255, 255, 255));
		textFieldTelefonoUsuario.setBorder(null);
		textFieldTelefonoUsuario.setColumns(10);
		textFieldTelefonoUsuario.setBounds(462, 206, 370, 20);
		add(textFieldTelefonoUsuario);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(new Color(0, 153, 255));
		separator_4.setBounds(462, 229, 370, 2);
		add(separator_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Password");
		lblNewLabel_1_5.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_1_5.setBounds(462, 276, 370, 17);
		add(lblNewLabel_1_5);
		
		textFieldPasswordUsuario = new JTextField();
		textFieldPasswordUsuario.setEditable(false);
		textFieldPasswordUsuario.setForeground(Color.LIGHT_GRAY);
		textFieldPasswordUsuario.setFont(new Font("Roboto", Font.PLAIN, 14));
		textFieldPasswordUsuario.setBackground(new Color(255, 255, 255));
		textFieldPasswordUsuario.setBorder(null);
		textFieldPasswordUsuario.setColumns(10);
		textFieldPasswordUsuario.setBounds(462, 304, 370, 20);
		add(textFieldPasswordUsuario);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setForeground(new Color(0, 153, 255));
		separator_5.setBounds(462, 327, 370, 2);
		add(separator_5);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setOrientation(SwingConstants.VERTICAL);
		separator_6.setBounds(432, 30, 2, 350);
		add(separator_6);

	}
}

