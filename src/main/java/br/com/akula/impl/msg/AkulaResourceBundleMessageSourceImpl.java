package br.com.akula.impl.msg;

import org.springframework.context.MessageSource;

import br.com.akula.api.msg.AkulaLocale;
import br.com.akula.api.msg.AkulaResourceBundleMessageSource;

public class AkulaResourceBundleMessageSourceImpl implements AkulaResourceBundleMessageSource{
	private MessageSource messageSource;
	private AkulaLocale akulaLocale;
	
	public String getMessage(String key) {
		try {
			return messageSource.getMessage(key, null, akulaLocale.localeSelecionado());
		} catch (Exception e) {
			return "Unresolved key: " + key;
		}
	}
	
	@Override
	public String getMessage(String key, Object[] args) {
		try {
			return messageSource.getMessage(key, args, akulaLocale.localeSelecionado());
		} catch (Exception e) {
			return "Unresolved key: " + key;
		}
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public void setAkulaLocale(AkulaLocale euLocale) {
		this.akulaLocale = euLocale;
	}
}