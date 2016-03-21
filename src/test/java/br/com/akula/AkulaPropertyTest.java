package br.com.akula;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.akula.api.config.AkulaPropertyFile;

@ContextConfiguration("/META-INF/app-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AkulaPropertyTest {
	
	private static final Logger logger = LoggerFactory.getLogger(AkulaPropertyTest.class);
	
	@Autowired
	private AkulaPropertyFile akulaPropertyFile;
	
	@Test
	public void testAkulaPropertyFile() {
		String propValue = akulaPropertyFile.getProperty("akula.prop.file.teste");
		
		assertEquals("Valor nao corresponde", "12345", propValue);
		
		logger.debug("testAkulaPropertyFile sucesso");
	}
}