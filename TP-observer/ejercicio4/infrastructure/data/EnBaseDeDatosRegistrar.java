package infrastructure.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import domain.portOut.ExcepcionesPortsOut;
import domain.portOut.Observer;
import domain.portOut.ParticipanteRecord;

public class EnBaseDeDatosRegistrar implements Observer {

	private Conn conn;

	public EnBaseDeDatosRegistrar(String conn) {
		this.conn = new Conn(conn);
	}

	public void actualizar(ParticipanteRecord unParticipante) throws ExcepcionesPortsOut {

		try {
			Connection dbConn = this.conn.open();
			PreparedStatement st = dbConn
					.prepareStatement("insert into participantes(nombre, telefono, region, mail) values(?,?,?,?)");

			st.setString(1, unParticipante.nombre());
			st.setString(2, unParticipante.telefono());
			st.setString(3, unParticipante.region());
			st.setString(4, unParticipante.mail());
			st.executeUpdate();
			st.close();

		} catch (SQLException e) {
			throw new ExcepcionesPortsOut(e, "No ha podido registrarse el participante.");
		}

	}
}
