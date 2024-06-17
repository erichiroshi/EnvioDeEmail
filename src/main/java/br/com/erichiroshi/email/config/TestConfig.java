package br.com.erichiroshi.email.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.erichiroshi.email.services.EmailService;
import br.com.erichiroshi.email.services.MockEmailService;

@Configuration
@Profile("test")
public class TestConfig {

	@Bean
	EmailService emailService() {
		return new MockEmailService();
	}
}