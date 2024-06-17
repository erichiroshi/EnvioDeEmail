package br.com.erichiroshi.email.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mailjet.client.ClientOptions;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.transactional.SendContact;
import com.mailjet.client.transactional.SendEmailsRequest;
import com.mailjet.client.transactional.TrackOpens;
import com.mailjet.client.transactional.TransactionalEmail;

import br.com.erichiroshi.email.dto.EmailDTO;

@Service
public class MailjetEmailService implements EmailService{
	
	private static Logger LOG = LoggerFactory.getLogger(MailjetEmailService.class);

	@Value("${spring.mailjet.api-key}")
	private String apiKey;

	@Value("${spring.mailjet.secret-key}")
	private String secretKey;

	public void sendEmail(EmailDTO dto) {

		MailjetClient client = new MailjetClient(ClientOptions.builder()
				.apiKey(apiKey)
				.apiSecretKey(secretKey)
				.build());

		TransactionalEmail message = TransactionalEmail
				.builder()
				.from(new SendContact(dto.fromEmail(), dto.fromName()))
				.to(new SendContact(dto.toEmail(), dto.toName()))
				.subject(dto.subject())
				.htmlPart(dto.body())
				.trackOpens(TrackOpens.ENABLED)
	            .header("test-header-key", "test-value")
	            .customID("custom-id-value")
				.build();

		SendEmailsRequest request = SendEmailsRequest
				.builder()
//				.message(message) // you can add up to 50 messages per request
				.message(message)
				.build();
		
		// act
		try {
			LOG.info("Enviando email!");
			request.sendWith(client);
		} catch (MailjetException e) {
			e.printStackTrace();
		}

	}
}