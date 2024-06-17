package br.com.erichiroshi.email.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.erichiroshi.email.dto.EmailDTO;

public class MockEmailService implements EmailService {

	private static Logger LOG = LoggerFactory.getLogger(MockEmailService.class);

	public void sendEmail(EmailDTO dto) {

		LOG.info("Sending email to: " + dto.toEmail());
		LOG.info("Email sent!");

	}
}