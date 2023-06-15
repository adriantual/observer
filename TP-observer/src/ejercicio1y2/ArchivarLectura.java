package ejercicio1y2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ArchivarLectura implements Observer {

	private File direccion;
	private FileWriter escribir;
	private PrintWriter lineaEscritura;

	public ArchivarLectura(String direccion) {
		super();
		this.direccion = new File(direccion);
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
	public void actualizar(String temperatura) {

		String fechaHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		String entrada = fechaHora + " - Temperatura: " + temperatura + " °C";

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(direccion, true))) {
			writer.write(entrada);
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
