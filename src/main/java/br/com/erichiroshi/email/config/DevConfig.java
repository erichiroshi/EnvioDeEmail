package br.com.erichiroshi.email.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.erichiroshi.email.services.EmailService;
import br.com.erichiroshi.email.services.MailjetEmailService;

@Configuration
@Profile("dev")
public class DevConfig {

	@Bean
	EmailService emailService() {
		return new MailjetEmailService();
	}
}