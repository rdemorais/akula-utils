package br.com.akula.api.db;

public interface InstalacaoDbService {
	public void instalarDb() throws RuntimeException;
	public void instalarDb(InstalacaoDb instalacaoDb) throws RuntimeException;
}