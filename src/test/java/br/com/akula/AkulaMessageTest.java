package br.com.akula;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.akula.api.msg.AkulaResourceBundleMessageSource;

@ContextConfiguration("/META-INF/app-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AkulaMessageTest {
	
	private static final Logger logger = LoggerFactory.getLogger(AkulaMessageTest.class);
	
	@Autowired
	private AkulaResourceBundleMessageSource akulaMessage;
	
	@Test
	public void testAkulaMessage() {
		String msg = akulaMessage.getMessage("akula.prop.test");
		
		assertEquals("Valor nao corresponde", "Valor da propriedade teste com acentuação", msg);
		
		logger.debug("akulaMessage funcionando corretamente");
	}
}