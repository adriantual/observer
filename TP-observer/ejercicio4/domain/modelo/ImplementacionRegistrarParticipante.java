package domain.modelo;

import java.util.List;

import domain.portIn.RegistrarParticipante;
import domain.portOut.Observer;
import domain.portOut.ParticipanteRecord;

public class ImplementacionRegistrarParticipante extends Observable implements RegistrarParticipante {

	public ImplementacionRegistrarParticipante(List<Observer> listaObservadores) {

		// arreglar
		for (Observer obs : listaObservadores) {
			this.agregarObservador(obs);
		}
	}

	@Override
	public void registrarParticipante(String nombre, String telefono, String region, String mail) {
		// crear persona y usar getters validar datos

		Region unaRegion = new Region(region);
		Telefono unTelefono = new Telefono(telefono);
		Participante unParticipante = new Participante(nombre, unTelefono, unaRegion, mail);
		this.notificar(new ParticipanteRecord(unParticipante.nombre(), unParticipante.telefono(),
				unParticipante.region(), unParticipante.mail()));
		// tipoRegistro.registrar(unParticipante.nombre(), unParticipante.telefono(),
		// unParticipante.region());

	}

}
