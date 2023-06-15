package main;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.List;

import domain.modelo.ImplementacionRegistrarParticipante;
import infrastructure.data.EnBaseDeDatosRegistrar;
import infrastructure.data.ViaMailEnviarConfirmacion;
import infrastructure.ui.AgregarParticipanteUI;

public class Main {
	public static void main(String[] args) throws SQLException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new AgregarParticipanteUI(new ImplementacionRegistrarParticipante(
							List.of(new EnBaseDeDatosRegistrar("jdbc:mysql://localhost:3306/layer-ejercicio1"),
									new ViaMailEnviarConfirmacion())));

				} catch (Exception e) {
					System.out.println(e);
				}
			}
		});
	}
}