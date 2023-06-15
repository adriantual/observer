package ejercicio3;

public class Medidor implements Notificar {

	private String temperatura;
	private ClimaOnline clima;

	public Medidor(ClimaOnline clima) {
		this.clima = clima;

	}

	public void leerTemperatura() {
		this.temperatura = this.clima.temperatura();
		// this.notificar(this.temperatura);
	}

	@Override
	public void actualizar() {
		this.temperatura = this.clima.temperatura();

	}

	@Override
	public String temperatura() {
		// TODO Auto-generated method stub
		return this.temperatura = this.clima.temperatura();

	}

}
