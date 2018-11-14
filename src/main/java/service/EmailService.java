package service;

import java.util.Properties;

import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;
import org.simplejavamail.mailer.config.TransportStrategy;


public class EmailService {
	public EmailService() {
		super();
		Email email = EmailBuilder.startingBlank().from("Ludovic Ouvry", "ausecourse@gmail.com")
				.to("ludo", "ludovic.ouvry@etudiant.univ-lille1.fr").withSubject("Subject!").withPlainText("a").buildEmail();

		MailerBuilder.withSMTPServer("smtp.gmail.com", 587, "ausecourse@gmail.com", "ausecourse123")
		.withTransportStrategy(TransportStrategy.SMTP_TLS).buildMailer().sendMail(email);
		System.out.println("OK");
	}
}