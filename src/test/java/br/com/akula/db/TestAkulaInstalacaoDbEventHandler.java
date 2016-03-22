package br.com.akula.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.akula.api.db.AkulaInstalacaoDbEvent;
import br.com.akula.api.db.InstalacaoDb;
import br.com.akula.impl.db.AbstractAkulaInstalacaoDbEventHandler;

public class TestAkulaInstalacaoDbEventHandler extends AbstractAkulaInstalacaoDbEventHandler{
	
	private static final Logger logger = LoggerFactory.getLogger(TestAkulaInstalacaoDbEventHandler.class);
	
	@Override
	public void onApplicationEvent(AkulaInstalacaoDbEvent event) {
		logger.debug("onAppEvent de TestAkulaInstalacaoDbEventHandler");
		
		InstalacaoDb instDb = (InstalacaoDb) event.getSource();
		
	}
}