package infrastructure.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import domain.portIn.ExcepcionesPortsIn;
import domain.portIn.RegistrarParticipante;

public class AgregarParticipanteUI extends JFrame {

	private JPanel contentPane;
	private JTextField nombre;
	private JTextField telefono;
	private JTextField region;
	private JTextField mail;
	RegistrarParticipante registrar;

	public AgregarParticipanteUI(RegistrarParticipante registrar) {

		this.registrar = registrar;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		nombre = new JTextField();
		nombre.setBounds(121, 36, 86, 20);
		contentPane.add(nombre);
		nombre.setColumns(10);

		telefono = new JTextField();
		telefono.setBounds(326, 36, 86, 20);
		contentPane.add(telefono);
		telefono.setColumns(10);

		region = new JTextField();
		region.setBounds(121, 110, 86, 20);
		contentPane.add(region);
		region.setColumns(10);

		mail = new JTextField();
		mail.setBounds(326, 110, 86, 20);
		contentPane.add(mail);
		mail.setColumns(10);

		JLabel lblNewLabel = new JLabel("NOMBRE");
		lblNewLabel.setBounds(24, 39, 58, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("REGION");
		lblNewLabel_1.setBounds(25, 113, 46, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("TELEFONO");
		lblNewLabel_2.setBounds(235, 39, 81, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("MAIL");
		lblNewLabel_3.setBounds(235, 113, 46, 14);
		contentPane.add(lblNewLabel_3);

		JButton btnNewButton = new JButton("CARGAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					registrar.registrarParticipante(nombre.getText(), telefono.getText(), region.getText(),
							mail.getText());

					dispose();

				} catch (ExcepcionesPortsIn e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());

				}

			}
		});
		btnNewButton.setBounds(169, 214, 134, 36);
		contentPane.add(btnNewButton);
		setVisible(true);
	}
}
