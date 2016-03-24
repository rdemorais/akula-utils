package br.com.akula.impl.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import br.com.akula.api.db.InstalacaoDbDao;

public class InstalacaoDbDaoImpl implements InstalacaoDbDao{

	@PersistenceContext
	protected EntityManager em;
	
	@Override
	public void executeSQLScript(final Resource scriptResource) throws RuntimeException {
		((Session)em.getDelegate()).doWork(new Work() {
			@Override
			public void execute(Connection connection) throws SQLException {
				ScriptUtils.executeSqlScript(connection, scriptResource);
			}
		});
	}
}