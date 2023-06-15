package domain.modelo;

import java.util.Objects;

import domain.portIn.ExcepcionesPortsIn;

class Participante {

	private String nombre;
	private Telefono telefono;
	private Region region;
	private String mail;

// no abusar d elos primitivos teoria calistenia
	public Participante(String nombre, Telefono telefono, Region region, String mail) {
		super();
		Objects.requireNonNull(nombre);
		if (nombre.isEmpty())
			throw new ExcepcionesPortsIn("El campo nombre no puede estar vacio.");
		this.nombre = nombre;
		this.telefono = telefono;
		this.region = region;
		this.mail = mail;
	}

	public String nombre() {
		return nombre;
	}

	public String telefono() {
		return telefono.Numero();
	}

	public String region() {
		return region.nombre();
	}

	public String mail() {
		return mail;
	}
}
