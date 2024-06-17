package br.com.erichiroshi.email.dto;

public record EmailDTO(

		String fromEmail,

		String fromName,

		String toEmail,

		String toName,

		String subject,

		String body) {
}
