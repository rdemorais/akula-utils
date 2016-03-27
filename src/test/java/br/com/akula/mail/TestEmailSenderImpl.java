package br.com.akula.mail;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;

import br.com.akula.api.mail.AkulaAbstractEmailSender;

public class TestEmailSenderImpl extends AkulaAbstractEmailSender implements TestEmailSender{
	
	private static final Logger logger = LoggerFactory.getLogger(TestEmailSenderImpl.class);
	
	@Async
	public void notificar() {
		Map<String, Object> vars = new HashMap<String, Object>();
		
		vars.put("nome", "Rafael");
		
		String to = "rdemorais.freitas@gmail.com";
		String from = "rdemorais.freitas@gmail.com";
		String fromNome = "Rafael de Morais";
		String subject = "Teste Akula Email";
		String templateName = "email-template.html";
		try {
			send(vars, subject, to, from, fromNome, templateName);
			logger.debug("Email enviado com sucesso: " + to);
		} catch (MessagingException e) {
			logger.error(e.getMessage(), e);
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage(), e);
		}
	}
}