package ejercicio3;

public class MostrarEnPantalla implements Notificar {

	private Notificar notificador;

	public MostrarEnPantalla(Notificar notificador) {
		super();
		this.notificador = notificador;
	}

	@Override
	public void actualizar() {
		double temperature = Double.parseDouble(this.notificador.temperatura());
		System.out.println("Temperatura actual: " + temperature + " °C");

		if (temperature < 12) {
			System.out.println("Hace frío, se encenderá la caldera.");
		} else if (temperature > 17) {
			System.out.println("Hace calor, se encenderá el aire acondicionado.");
		}
		this.notificador.actualizar();

	}

	@Override
	public String temperatura() {

		return this.notificador.temperatura();
	}

}
