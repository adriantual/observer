package ejercicio1y2;

import java.util.List;

public class Medidor extends Observable {

	private String temperatura;
	private ClimaOnline clima;

	public Medidor(ClimaOnline clima, List<Observer> observadores) {
		this.clima = clima;
		for (Observer observador : observadores) {
			this.agregarObservadores(observador);
		}
	}

	public void leerTemperatura() {
		this.temperatura = this.clima.temperatura();
		this.notificar(this.temperatura);
	}

}
