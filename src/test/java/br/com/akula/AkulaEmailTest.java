package br.com.akula;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.akula.mail.TestEmailSender;

@ContextConfiguration("/META-INF/app-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AkulaEmailTest {
	
	@Autowired
	private TestEmailSender emailSender;
	
	@Test
	public void testEmailSender() {
	
		emailSender.notificar();
	}
}