package ventanas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class VentanaBienvenida extends JPanel {

	/**
	 * Create the panel.
	 */
	public VentanaBienvenida() {
		setBorder(null);
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido al Sistema CIVU");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 40));
		lblNewLabel.setBounds(107, 160, 657, 83);
		add(lblNewLabel);

	}
}
