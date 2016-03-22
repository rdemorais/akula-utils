package br.com.akula.api.db;

import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;

public interface AkulaInstalacaoDbEventHandler extends ApplicationListener<AkulaInstalacaoDbEvent>, Ordered{
	public void setOrder(int order);
}
