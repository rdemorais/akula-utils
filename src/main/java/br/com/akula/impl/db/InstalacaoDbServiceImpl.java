package br.com.akula.impl.db;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.akula.api.db.AkulaInstalacaoDbPublisher;
import br.com.akula.api.db.InstalacaoDb;
import br.com.akula.api.db.InstalacaoDbService;

public class InstalacaoDbServiceImpl implements InstalacaoDbService{

	@Autowired
	private AkulaInstalacaoDbPublisher akulaInstalacaoDb;
	
	@Resource(name="instalacaoProps")
	private Properties instalacaoProps;
	
	@Override
	@Transactional
	public void instalarDb() throws RuntimeException {
		
		Map<String, String> mapProp = new HashMap<String, String>();
		String pName;
		for (Object propName : instalacaoProps.keySet()) {
			pName = String.valueOf(propName);
			mapProp.put(pName, instalacaoProps.getProperty(pName));
		}
		
		akulaInstalacaoDb.notificar(new InstalacaoDb(mapProp));
	}

	@Override
	@Transactional
	public void instalarDb(InstalacaoDb instalacaoDb) throws RuntimeException {
		akulaInstalacaoDb.notificar(instalacaoDb);
	}
}