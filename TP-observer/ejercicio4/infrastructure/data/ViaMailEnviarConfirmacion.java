package infrastructure.data;

import java.util.Properties;

import domain.portOut.ExcepcionesPortsOut;
import domain.portOut.Observer;
import domain.portOut.ParticipanteRecord;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class ViaMailEnviarConfirmacion implements Observer {

	@Override
	public void actualizar(ParticipanteRecord unParticipante) throws ExcepcionesPortsOut {
		String mensaje = "El participante: " + unParticipante.nombre() + " se inscribio correctamente" + "\n"
				+ "Con el numero de telefono: " + unParticipante.telefono() + "\n" + "Region: "
				+ unParticipante.region();

		String to = unParticipante.mail();

		String from = "jakartafrom@example.com";

		final String username = "e1aa2e5afc42df";

		final String password = "b8bc167ddcc249";

		String host = "smtp.mailtrap.io";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new jakarta.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {

			Message message = new MimeMessage(session);

			message.setFrom(new InternetAddress(from));

			message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("ticket");
			message.setText(mensaje);
			Transport.send(message);
			System.out.println("Email Message Sent Successfully");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

}
