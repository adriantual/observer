package domain.modelo;

import java.util.Objects;

import domain.portIn.ExcepcionesPortsIn;

public class Telefono {
	private String numero;

	public Telefono(String numero) {
		Objects.requireNonNull(numero);

		if (numero.isEmpty())
			throw new ExcepcionesPortsIn("Debe cargar un telefono");

		if (!validarTelefono(numero))
			throw new ExcepcionesPortsIn("El tel�fono debe ingresarse de la siguiente forma: NNNN-NNNNNN");

		this.numero = numero;
	}

	private boolean validarTelefono(String numero) {
		String regex = "\\d{4}-\\d{6}";
		return numero.matches(regex);
	}

	public String getNumero() {
		return numero;
	}

	public String Numero() {
		return this.numero;
	}

}
