package br.com.akula.impl.msg;

import java.util.List;
import java.util.Locale;

import br.com.akula.api.msg.AkulaLocale;

public class AkulaLocaleImpl implements AkulaLocale{
	private List<String> localesSuportados;
	private List<String> localesNomeAmigavel;
	private Locale localeSelecionado;
	
	public List<String> localesSuportados() {
		return this.localesSuportados;
	}

	public List<String> localesNomeAmigavel() {
		return this.localesNomeAmigavel;
	}

	public Locale localeSelecionado() {
		return this.localeSelecionado;
	}

	public void setLocalesSuportados(List<String> locales) {
		this.localesSuportados = locales;
	}

	public void setLocalesNomeAmigavel(List<String> nomes) {
		this.localesNomeAmigavel = nomes;
	}

	public void setLocaleSelecionado(String locale) {
		//Recebe no formato pt_BR
		if(locale == null || locale.equals("")) {
			this.localeSelecionado = Locale.getDefault();
			return;
		}
		String loc[] = locale.split("_");
		this.localeSelecionado = new Locale(loc[0], loc[1]);
	}
}