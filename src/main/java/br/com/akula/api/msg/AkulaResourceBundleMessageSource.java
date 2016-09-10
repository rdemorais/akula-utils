package br.com.akula.api.msg;

public interface AkulaResourceBundleMessageSource {
	public String getMessage(String key);
	public String getMessage(String key, Object[] args);
}