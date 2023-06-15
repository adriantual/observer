package ejercicio1y2;

public class MostrarEnPantalla implements Observer {

	@Override
	public void actualizar(String temperatura) {
		// System.out.println("Temperatura actual: " + temperatura + " °C");
		double temperature = Double.parseDouble(temperatura);
		if (temperature < 12) {
			System.out.println("Hace frío, se encenderá la caldera.");
		} else if (temperature > 17) {
			System.out.println("Hace calor, se encenderá el aire acondicionado.");
		}

	}

}
