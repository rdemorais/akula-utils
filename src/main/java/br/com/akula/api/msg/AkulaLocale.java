package br.com.akula.api.msg;

import java.util.List;
import java.util.Locale;

public interface AkulaLocale {
	public List<String> localesSuportados();
	public void setLocalesSuportados(List<String> locales);
	public List<String> localesNomeAmigavel();
	public void setLocalesNomeAmigavel(List<String> nomes);
	public Locale localeSelecionado();
	public void setLocaleSelecionado(String locale);
}
