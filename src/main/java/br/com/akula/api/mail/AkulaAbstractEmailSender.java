package br.com.akula.api.mail;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

public abstract class AkulaAbstractEmailSender {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private TemplateEngine templateEngine;
	
	protected void send(String subject, String to, String emailFrom, String nomeFrom, String templateName) 
			throws MessagingException, UnsupportedEncodingException {
		send(new HashMap<String, Object>(), subject, to, emailFrom, nomeFrom, templateName);
	}
	
	protected void send(Map<String, Object> vars, String subject, String to, String emailFrom, String nomeFrom, String templateName) 
			throws MessagingException, UnsupportedEncodingException {
		final Context ctx = new Context();
		for (String key : vars.keySet()) {
			ctx.setVariable(key, vars.get(key));
		}
		final MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
		message.setFrom(emailFrom, nomeFrom);
		message.setTo(to);
		message.setSubject(subject);
		final String htmlContent = templateEngine.process(templateName, ctx);
		message.setText(htmlContent, true); // true = isHtml
		mailSender.send(mimeMessage);
	}
}