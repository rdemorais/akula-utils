package br.com.akula.impl.db;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.util.PropertyPlaceholderHelper;

import br.com.akula.api.db.AkulaInstalacaoDbEvent;
import br.com.akula.api.db.AkulaInstalacaoDbEventHandler;
import br.com.akula.api.db.InstalacaoDb;
import br.com.akula.api.db.InstalacaoDbDao;
import br.com.akula.api.file.AkulaFileSystem;

public class AbstractAkulaInstalacaoDbEventHandler implements AkulaInstalacaoDbEventHandler {

	private int ordem;
	
	@Autowired
	private AkulaFileSystem akulaFileSystem;
	
	@Autowired
	protected InstalacaoDbDao instalacaoDb;
	
	@Override
	public void onApplicationEvent(AkulaInstalacaoDbEvent event) {
		throw new RuntimeException("overide...");
	}

	public Resource replaceVariable(InstalacaoDb instalacaoDb, String resourcePath) throws RuntimeException {
		try {
			String sqlModel = akulaFileSystem.getResourceContent(resourcePath);
			Properties prop = new Properties();
			
			Map<String, String> propsMap = instalacaoDb.getProps();
			Set<String> propsSet = propsMap.keySet();
			
			for (String key : propsSet) {
				prop.put(key, propsMap.get(key));				
			}
			
			PropertyPlaceholderHelper helper = new PropertyPlaceholderHelper("${","}");
			
			String sqlFinal = helper.replacePlaceholders(sqlModel , prop);
			return new ByteArrayResource(sqlFinal.getBytes());
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		} 
	}

	@Override
	public int getOrder() {
		return ordem;
	}
	
	@Override
	public void setOrder(int order) {
		this.ordem = order;
	}
}