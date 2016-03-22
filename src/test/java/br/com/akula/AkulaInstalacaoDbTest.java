package br.com.akula;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.akula.api.db.InstalacaoDbService;

@ContextConfiguration("/META-INF/app-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AkulaInstalacaoDbTest {
	private static final Logger logger = LoggerFactory.getLogger(AkulaInstalacaoDbTest.class);
	
	@Autowired
	private InstalacaoDbService instalacaoDbService;
	
	@Test
	public void testInstalacaoDb() {
		instalacaoDbService.instalarDb();
		logger.debug("InstalacaoDb executado com sucesso");
	}
}