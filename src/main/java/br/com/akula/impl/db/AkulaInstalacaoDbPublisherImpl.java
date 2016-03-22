package br.com.akula.impl.db;

import org.springframework.context.ApplicationEventPublisher;

import br.com.akula.api.db.AkulaInstalacaoDbEvent;
import br.com.akula.api.db.AkulaInstalacaoDbPublisher;
import br.com.akula.api.db.InstalacaoDb;

public class AkulaInstalacaoDbPublisherImpl implements AkulaInstalacaoDbPublisher {

	private ApplicationEventPublisher publisher;
	
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		publisher = applicationEventPublisher;
	}

	@Override
	public void notificar(InstalacaoDb instalacaoDb) {
		publisher.publishEvent(new AkulaInstalacaoDbEvent(instalacaoDb));
	}
}