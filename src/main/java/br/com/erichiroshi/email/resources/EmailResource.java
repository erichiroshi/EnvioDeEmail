package br.com.erichiroshi.email.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erichiroshi.email.dto.EmailDTO;
import br.com.erichiroshi.email.services.EmailService;

@RestController
@RequestMapping("/emails")
public class EmailResource {

	@Autowired
	private EmailService emailService;

	@PostMapping
	public ResponseEntity<Void> send(@RequestBody EmailDTO dto) {
		emailService.sendEmail(dto);
		return ResponseEntity.noContent().build();
	}

}