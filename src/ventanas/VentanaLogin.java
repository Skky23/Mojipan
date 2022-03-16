package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField casillaUsuario;
	private JPasswordField casillaPassword;
	public JButton btnEntrar;

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public VentanaLogin() throws IOException {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(String.valueOf(casillaPassword.getPassword()).equals("")){
					casillaPassword.setText("**********");
					casillaPassword.setForeground(Color.LIGHT_GRAY);
				}
				
				if(casillaUsuario.getText().equals("")) {
					casillaUsuario.setText("Ingrese su usuario");
					casillaUsuario.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBorder(null);

		lblNewLabel.setIcon(new ImageIcon(VentanaLogin.class.getResource("/imagenes/logo.jpeg")));
		lblNewLabel.setBounds(483, 0, 301, 461);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("INICIAR SESIÓN");
		lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 16));
		lblNewLabel_1.setBounds(50, 107, 164, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("USUARIO");
		lblNewLabel_2.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(50, 147, 164, 23);
		contentPane.add(lblNewLabel_2);
		
		casillaUsuario = new JTextField();
		casillaUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//escribir la validaciones para la casilla debe ser solo numeros no mas de 15 numeros
				char validar=e.getKeyChar();
				
				if(Character.isLetter(validar)) {
					getToolkit().beep();
					e.consume();
					
					JOptionPane.showMessageDialog(null, "Ingresar solo numeros");
				}
				
				
				if(casillaUsuario.getText().length()>= 15) {
					getToolkit().beep();
					e.consume();
					
					JOptionPane.showMessageDialog(null, "Ingresar 15 numeros o menos");
				}
			}
		});
		casillaUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				casillaUsuario.setText("");
				casillaUsuario.setForeground(Color.BLACK);
				if(String.valueOf(casillaPassword.getPassword()).equals("")){
					textoPasswordInicial();
				}
			}
		});
		casillaUsuario.setForeground(Color.LIGHT_GRAY);
		casillaUsuario.setBorder(null);
		casillaUsuario.setFont(new Font("Roboto", Font.PLAIN, 14));
		casillaUsuario.setText("Ingrese su usuario");
		casillaUsuario.setBounds(50, 181, 400, 23);
		contentPane.add(casillaUsuario);
		casillaUsuario.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(50, 215, 400, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_3 = new JLabel("MOJIPAN");
		lblNewLabel_3.setFont(new Font("Roboto", Font.BOLD, 24));
		lblNewLabel_3.setBounds(106, 40, 126, 45);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2_1 = new JLabel("CONTRASEÑA");
		lblNewLabel_2_1.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(50, 234, 164, 23);
		contentPane.add(lblNewLabel_2_1);
		
		casillaPassword = new JPasswordField();
		casillaPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//adicionar validacion para la casilla no debe utilizar ciertos caracteres especiales 
				
				if(e.getKeyChar()==61 || e.getKeyChar()==59) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "No se permiten los caracteres = ;");
				}
				
				if(casillaPassword.getPassword().length>=10) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "Ingresar 10 caracteres o menos");
				}
				
			}
		});
		casillaPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				casillaPassword.setText("");
				casillaPassword.setForeground(Color.BLACK);
				if(casillaUsuario.getText().equals("")) {
					textoUsuarioInicial();
				}
			}
		});
		casillaPassword.setForeground(Color.LIGHT_GRAY);
		casillaPassword.setBorder(null);
		casillaPassword.setText("**********");
		casillaPassword.setBounds(50, 268, 400, 23);
		contentPane.add(casillaPassword);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(50, 302, 400, 2);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(VentanaLogin.class.getResource("/imagenes/pan.png")));
		lblNewLabel_4.setIcon(new ImageIcon(VentanaLogin.class.getResource("/imagenes/iconPan.png")));
		lblNewLabel_4.setBounds(50, 40, 45, 45);
		contentPane.add(lblNewLabel_4);
		
		btnEntrar = new JButton("ENTRAR");
		btnEntrar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEntrar.setBackground(new Color(210, 45, 87));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnEntrar.setBackground(new Color(159, 11, 47));
			}
		});
		btnEntrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEntrar.setBorder(null);
		btnEntrar.setBackground(new Color(159, 11, 47));
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.setFont(new Font("Roboto", Font.BOLD, 14));
		btnEntrar.setBounds(50, 335, 126, 39);
		contentPane.add(btnEntrar);
		
	}
	
	
	
	public void textoUsuarioInicial() {
		casillaUsuario.setText("Ingrese su usuario");
		casillaUsuario.setForeground(Color.LIGHT_GRAY);
	}
	
	public void textoPasswordInicial() {
		casillaPassword.setText("**********");
		casillaPassword.setForeground(Color.LIGHT_GRAY);
	}
	
	public String usuarioIngresado() {
		String usuario = casillaUsuario.getText();
		return usuario;
	}
	
	public String passwordIngresado() {
		String password = String.valueOf(casillaPassword.getPassword());
		return password;
	}
	
}




