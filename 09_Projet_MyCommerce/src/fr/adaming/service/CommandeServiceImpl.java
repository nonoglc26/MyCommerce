package fr.adaming.service;

import java.util.Properties;

import javax.ejb.Stateful;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import fr.adaming.model.Client;

@Stateful
public class CommandeServiceImpl implements ICommandeService {

	@Override
	public void envoyerMail(Client cl) {
		// definir le mail et le mot de passe du compte gmail qui enverra le
		// mail
		final String username = "";
		final String password = "";

		// configurer le serveur smtp
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");

		// envoyer le pseudo et le mot de passe
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// creer le mail
			Message message = new MimeMessage(session);

			// indiquer l'expediteur
			message.setFrom(new InternetAddress(username));

			// indiquer le destinataire
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(cl.getEmail()));

			// indiquer le sujet
			message.setText("Confirmation de l'ajout d'un nouveau client à votre charge");

			// envoyer le mail
			Transport.send(message);
			System.out.println("message bien envoyé !");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

}
