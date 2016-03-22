package br.com.akula.api.db;

import org.springframework.context.ApplicationEvent;

public class AkulaInstalacaoDbEvent extends ApplicationEvent {

	private static final long serialVersionUID = 7791944383820933981L;

	public AkulaInstalacaoDbEvent(InstalacaoDb source) {
		super(source);
	}
}