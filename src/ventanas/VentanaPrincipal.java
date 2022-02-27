package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	public JPanel contentPane;
	public JPanel panelPrincipalVentanas;
	public JTextField textFieldFechaSistema;
	public JTextField textFieldUsuarioConectado;
	public JButton btnPerfil;
	public JButton btnGestionUsuarios;
	public JButton btnGestionClientes;
	public JButton btnGestionProveedores;
	public JButton btnInventario;
	public JButton btnVentas;
	public JButton btnReportes;
	public JButton btnSalir;

	
	
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelLateral = new JPanel();
		panelLateral.setBackground(new Color(0, 51, 102));
		panelLateral.setBounds(0, 0, 300, 661);
		contentPane.add(panelLateral);
		panelLateral.setLayout(null);
		
		JLabel iconTituloPanelLateral = new JLabel("");
		iconTituloPanelLateral.setBounds(61, 23, 45, 45);
		panelLateral.add(iconTituloPanelLateral);
		iconTituloPanelLateral.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/iconZapato.png")));
		
		JLabel lblTituloPanelLateral = new JLabel("Calzado Eze");
		lblTituloPanelLateral.setBounds(116, 23, 124, 45);
		panelLateral.add(lblTituloPanelLateral);
		lblTituloPanelLateral.setForeground(new Color(255, 255, 255));
		lblTituloPanelLateral.setHorizontalAlignment(SwingConstants.LEFT);
		lblTituloPanelLateral.setFont(new Font("Roboto", Font.BOLD, 22));
		
		JSeparator separatorTituloPanelLateral = new JSeparator();
		separatorTituloPanelLateral.setBounds(52, 66, 198, 2);
		panelLateral.add(separatorTituloPanelLateral);
		
		btnPerfil = new JButton("   Perfil");
		btnPerfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPerfil.setBackground(new Color(51, 51, 225));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnPerfil.setBackground(new Color(0, 51, 102));
			}
		});
		btnPerfil.setFocusPainted(false);
		btnPerfil.setHorizontalAlignment(SwingConstants.LEFT);
		btnPerfil.setBounds(25, 102, 275, 45);
		panelLateral.add(btnPerfil);
		btnPerfil.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/iconBotonPerfil.png")));
		btnPerfil.setForeground(new Color(255, 255, 255));
		btnPerfil.setBackground(new Color(0, 51, 102));
		btnPerfil.setFont(new Font("Roboto", Font.BOLD, 16));
		btnPerfil.setBorder(null);
		
		btnGestionUsuarios = new JButton("   Gestión de Usuarios");
		btnGestionUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnGestionUsuarios.setBackground(new Color(51, 51, 225));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnGestionUsuarios.setBackground(new Color(0, 51, 102));
			}
		});
		btnGestionUsuarios.setFocusPainted(false);
		btnGestionUsuarios.setHorizontalAlignment(SwingConstants.LEFT);
		btnGestionUsuarios.setBounds(25, 147, 275, 45);
		panelLateral.add(btnGestionUsuarios);
		btnGestionUsuarios.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/iconBotonGestionUsuarios.png")));
		btnGestionUsuarios.setForeground(Color.WHITE);
		btnGestionUsuarios.setFont(new Font("Roboto", Font.BOLD, 16));
		btnGestionUsuarios.setBorder(null);
		btnGestionUsuarios.setBackground(new Color(0, 51, 102));
		
		btnGestionClientes = new JButton("   Gestión de Clientes");
		btnGestionClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnGestionClientes.setBackground(new Color(51, 51, 225));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnGestionClientes.setBackground(new Color(0, 51, 102));
			}
		});
		btnGestionClientes.setFocusPainted(false);
		btnGestionClientes.setHorizontalAlignment(SwingConstants.LEFT);
		btnGestionClientes.setBounds(25, 192, 275, 45);
		panelLateral.add(btnGestionClientes);
		btnGestionClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGestionClientes.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/iconBotonGestionUsuarios.png")));
		btnGestionClientes.setForeground(Color.WHITE);
		btnGestionClientes.setFont(new Font("Roboto", Font.BOLD, 16));
		btnGestionClientes.setBorder(null);
		btnGestionClientes.setBackground(new Color(0, 51, 102));
		
		btnGestionProveedores = new JButton("   Gestion de Proveedores");
		btnGestionProveedores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnGestionProveedores.setBackground(new Color(51, 51, 225));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnGestionProveedores.setBackground(new Color(0, 51, 102));
			}
		});
		btnGestionProveedores.setFocusPainted(false);
		btnGestionProveedores.setHorizontalAlignment(SwingConstants.LEFT);
		btnGestionProveedores.setBounds(25, 237, 275, 45);
		panelLateral.add(btnGestionProveedores);
		btnGestionProveedores.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/iconBotonGestionUsuarios.png")));
		btnGestionProveedores.setForeground(Color.WHITE);
		btnGestionProveedores.setFont(new Font("Roboto", Font.BOLD, 16));
		btnGestionProveedores.setBorder(null);
		btnGestionProveedores.setBackground(new Color(0, 51, 102));
		
		btnInventario = new JButton("   Inventario");
		btnInventario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnInventario.setBackground(new Color(51, 51, 225));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnInventario.setBackground(new Color(0, 51, 102));
			}
		});
		btnInventario.setFocusPainted(false);
		btnInventario.setHorizontalAlignment(SwingConstants.LEFT);
		btnInventario.setBounds(25, 282, 275, 45);
		panelLateral.add(btnInventario);
		btnInventario.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/iconInventario.png")));
		btnInventario.setForeground(Color.WHITE);
		btnInventario.setFont(new Font("Roboto", Font.BOLD, 16));
		btnInventario.setBorder(null);
		btnInventario.setBackground(new Color(0, 51, 102));
		
		btnVentas = new JButton("   Ventas");
		btnVentas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnVentas.setBackground(new Color(51, 51, 225));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnVentas.setBackground(new Color(0, 51, 102));
			}
		});
		btnVentas.setFocusPainted(false);
		btnVentas.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/iconVentas.png")));
		btnVentas.setHorizontalAlignment(SwingConstants.LEFT);
		btnVentas.setBounds(25, 327, 275, 45);
		panelLateral.add(btnVentas);
		btnVentas.setForeground(Color.WHITE);
		btnVentas.setFont(new Font("Roboto", Font.BOLD, 16));
		btnVentas.setBorder(null);
		btnVentas.setBackground(new Color(0, 51, 102));
		
		btnReportes = new JButton("   Reportes");
		btnReportes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnReportes.setBackground(new Color(51, 51, 225));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnReportes.setBackground(new Color(0, 51, 102));
			}
		});
		btnReportes.setFocusPainted(false);
		btnReportes.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/iconReportes.png")));
		btnReportes.setHorizontalAlignment(SwingConstants.LEFT);
		btnReportes.setBounds(25, 372, 275, 45);
		panelLateral.add(btnReportes);
		btnReportes.setForeground(Color.WHITE);
		btnReportes.setFont(new Font("Roboto", Font.BOLD, 16));
		btnReportes.setBorder(null);
		btnReportes.setBackground(new Color(0, 51, 102));
		
		btnSalir = new JButton("   Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSalir.setBackground(new Color(51, 51, 225));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSalir.setBackground(new Color(0, 51, 102));
			}
		});
		btnSalir.setFocusPainted(false);
		btnSalir.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/iconsBotonSalir.png")));
		btnSalir.setHorizontalAlignment(SwingConstants.LEFT);
		btnSalir.setBounds(25, 417, 275, 45);
		panelLateral.add(btnSalir);
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setFont(new Font("Roboto", Font.BOLD, 16));
		btnSalir.setBorder(null);
		btnSalir.setBackground(new Color(0, 51, 102));
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(new Color(51, 102, 153));
		panelSuperior.setBounds(300, 46, 884, 131);
		contentPane.add(panelSuperior);
		panelSuperior.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Usuario:");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(60, 40, 62, 20);
		panelSuperior.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Roboto", Font.PLAIN, 16));
		
		textFieldFechaSistema = new JTextField();
		textFieldFechaSistema.setForeground(Color.WHITE);
		textFieldFechaSistema.setEditable(false);
		textFieldFechaSistema.setFont(new Font("Roboto", Font.PLAIN, 20));
		textFieldFechaSistema.setBorder(null);
		textFieldFechaSistema.setBackground(new Color(51, 102, 153));
		textFieldFechaSistema.setBounds(60, 71, 310, 35);
		panelSuperior.add(textFieldFechaSistema);
		textFieldFechaSistema.setColumns(10);
		
		textFieldUsuarioConectado = new JTextField();
		textFieldUsuarioConectado.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldUsuarioConectado.setForeground(Color.WHITE);
		textFieldUsuarioConectado.setEditable(false);
		textFieldUsuarioConectado.setBorder(null);
		textFieldUsuarioConectado.setBackground(new Color(51, 102, 153));
		textFieldUsuarioConectado.setFont(new Font("Roboto", Font.PLAIN, 16));
		textFieldUsuarioConectado.setColumns(10);
		textFieldUsuarioConectado.setBounds(132, 41, 238, 20);
		panelSuperior.add(textFieldUsuarioConectado);
		
		panelPrincipalVentanas = new JPanel();
		panelPrincipalVentanas.setBackground(Color.WHITE);
		panelPrincipalVentanas.setBounds(300, 176, 884, 485);
		contentPane.add(panelPrincipalVentanas);
		panelPrincipalVentanas.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CIVU");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel.setBounds(300, 11, 884, 24);
		contentPane.add(lblNewLabel);
	}
}
