package ejercicio1y2;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {

	private List<Observer> observadores;

	public Observable() {
		this.observadores = new ArrayList<Observer>();
	}

	public void agregarObservadores(Observer unObservador) {
		this.observadores.add(unObservador);
	}

	public void notificar(String valor) {
		for (Observer unObservador : observadores) {
			unObservador.actualizar(valor);
		}
	}
}
