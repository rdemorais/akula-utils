package br.com.akula.impl.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import br.com.akula.api.config.AkulaPropertyFile;

@Configuration
@PropertySource("classpath:app.properties")
public class AkulaPropertyFileImpl implements AkulaPropertyFile{
	
	@Autowired
	private Environment env;
	
	@Override
	public String getProperty(String key) {
		return env.getProperty(key);
	}
}