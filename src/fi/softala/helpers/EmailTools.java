package fi.softala.helpers;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

/**
 * Luokka, jolla voi l�hett�� s�hk�postia. Ota huomioon, ett� perusta t�t� varten
 * dummy-tili gmailiin, jotta omat kredentiaalisi eiv�t vaarannu! Dummy tilin salasana
 * kannattaa vaihtaa kurssin suorittamisen j�lkeen.
 * @author Jukka Juslin
 *
 */
public class EmailTools {
	public void sendEmail(String senderGoogleEmail, String senderGooglePassword, String receiverEmail, String title, String emailContent ) {
		// Asetetaan Stringeihin l�hett�j�n kredentiaalit
		String from = senderGoogleEmail;
		String pass = senderGooglePassword;
		// S�hk�postipalvelin
		String host = "smtp.gmail.com";

		// Haetaan j�rjestelm�n ominaisuudet
		Properties properties = System.getProperties();
		// Asetetaan s�hk�postipalvelin
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.user", from);
		properties.put("mail.smtp.password", pass);
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");

		// Haetaan oletus session olio
		Session session = Session.getDefaultInstance(properties);

		try {
			// Luo oletus MimeMessage olio
			MimeMessage message = new MimeMessage(session);

			// Viestin l�hett�j�n asettaminen (t�ytyy olla gmail-osoite)
			message.setFrom(new InternetAddress(from));

			// Viestin vastaanottajan asettaminen
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					receiverEmail));

			// Viestin otsikko eli subject
			message.setSubject(title);

			// Asetetaan itse viestin sis�lt�
			message.setText(emailContent);

			// L�hetet��n viesti
			Transport transport = session.getTransport("smtp");
			transport.connect(host, from, pass);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}
