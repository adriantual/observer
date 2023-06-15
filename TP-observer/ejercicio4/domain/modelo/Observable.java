package domain.modelo;

import java.util.ArrayList;
import java.util.List;

import domain.portOut.ExcepcionesPortsOut;
import domain.portOut.Observer;
import domain.portOut.ParticipanteRecord;

public abstract class Observable {

	List<Observer> observadores;

	public Observable() {
		super();
		this.observadores = new ArrayList<>();
	}

	public void agregarObservador(Observer unObservador) {
		this.observadores.add(unObservador);
	}

	public void notificar(ParticipanteRecord unParticipante) {
		for (Observer unObservador : observadores) {
			try {
				unObservador.actualizar(unParticipante);
			} catch (ExcepcionesPortsOut e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
