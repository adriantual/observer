package ejercicio1y2;

import java.util.List;

public class Main {

	public static void main(String[] args) {

		Medidor medidor = new Medidor(new WeatherChannelService("e3a815eaff208aeecbc836319f9643cf"),
				List.of(new ArchivarLectura("Archivo"), new MostrarEnPantalla()));

		medidor.leerTemperatura();

	}

}
