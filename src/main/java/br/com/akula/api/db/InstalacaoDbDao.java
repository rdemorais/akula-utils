package br.com.akula.api.db;

import org.springframework.core.io.Resource;

public interface InstalacaoDbDao {
	public void executeSQLScript(final Resource scriptResource) throws RuntimeException;
}