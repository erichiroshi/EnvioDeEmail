package br.com.erichiroshi.email.services;

import br.com.erichiroshi.email.dto.EmailDTO;

public interface EmailService {

	void sendEmail(EmailDTO dto);
}
