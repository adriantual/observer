package domain.portOut;

public class ExcepcionesPortsOut extends Exception {
	public ExcepcionesPortsOut(Exception ex, String msg) {
		super(msg, ex);
	}
}
