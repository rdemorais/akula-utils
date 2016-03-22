package br.com.akula.api.db;

import org.springframework.context.ApplicationEventPublisherAware;

public interface AkulaInstalacaoDbPublisher extends ApplicationEventPublisherAware {
	public void notificar(InstalacaoDb instalacaoDb);
}