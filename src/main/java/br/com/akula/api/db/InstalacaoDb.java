package br.com.akula.api.db;

import java.util.Map;

public class InstalacaoDb {
	
	private Map<String, String> props;

	public InstalacaoDb() {
	}
	
	public InstalacaoDb(Map<String, String> props) {
		this.props = props;
	}
	
	public Map<String, String> getProps() {
		return props;
	}

	public void setProps(Map<String, String> props) {
		this.props = props;
	}
}