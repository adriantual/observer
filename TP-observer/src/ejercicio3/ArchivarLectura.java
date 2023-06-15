package ejercicio3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ArchivarLectura implements Notificar {

	private File direccion;
	private FileWriter escribir;
	private PrintWriter lineaEscritura;
	private Notificar notificador;

	public ArchivarLectura(String direccion, Notificar notificador) {
		super();
		this.direccion = new File(direccion);
		this.notificador = notificador;
	}

	public void archivar(String clima) {
		LocalDate fecha = LocalDate.now();
		String Lectura = fecha + "," + clima;

		try {
			if (this.direccion.exists())
				this.direccion.createNewFile();

			this.escribir = new FileWriter(direccion, true);
			this.lineaEscritura = new PrintWriter(this.escribir);
			this.lineaEscritura.println(Lectura);

		} catch (IOException e) {
			// throw new ("No se pudo registrar el participante en el archivo.", e);
		} finally {
			try {
				this.escribir.close();
				this.lineaEscritura.close();
			} catch (IOException e) {
				// throw new ("Error al cerrar el archivo de registro.", e);
			}

		}

	}

	@Override
	public void actualizar() {

		String fechaHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		String entrada = fechaHora + " - Temperatura: " + this.notificador.temperatura() + " °C";

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(direccion, true))) {
			writer.write(entrada);
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.notificador.actualizar();

	}

	@Override
	public String temperatura() {
		// TODO Auto-generated method stub
		return this.notificador.temperatura();
	}

}
