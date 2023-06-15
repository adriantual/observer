package ejercicio3;

public class Main {

	public static void main(String[] args) {

		Notificar notificacion = new ArchivarLectura("Archivo",
				new MostrarEnPantalla(new Medidor(new WeatherChannelService("e3a815eaff208aeecbc836319f9643cf"))));

		notificacion.actualizar();
	}

}
