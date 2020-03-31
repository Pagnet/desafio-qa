package execution.pageobject;

import org.openqa.selenium.By;

import base.testbase.TestBase;

public class ImportsPO extends TestBase {

	By cabecalhoDaPagina = By.tagName("h1");
	public void verificarCabecalhoDaPagina(String cabecalho) {
		verifyByElementText(cabecalhoDaPagina, "Cabecalho da Pagina", cabecalho);
	}
	
	By precoTotalDeImportacoes = By.id("total-all-imports");
	public void verificarPrecoTotalDeImportacoes(String valorTotal) {
		verifyByElementText(precoTotalDeImportacoes, "Preço Total de Importações", valorTotal);
	}
	
	By precoTotalDaImportacaoAtual = By.id("total-imports");
	public void verificarPrecoTotalDaImportacaoAtual(String valorTotalAtual) {
		verifyByElementText(precoTotalDaImportacaoAtual, "Preço Total da Importação Atual", valorTotalAtual);
	}

	public void verificarTituloTabelaDeImportacao(String coluna, String valorEsperado) {
		By tituloTabelaDeImportacao = By.xpath("/html/body/table/tbody/tr[1]/th[" + coluna + "]");
		
		verifyByElementText(tituloTabelaDeImportacao, "Título [coluna " + coluna + "] da tabela de importações", valorEsperado);
	}
	
	public void verificarCelulaTabelaDeImportacao(String linha, String coluna, String valorEsperado) {
		By celulaTabelaDeImportacao = By.xpath("/html/body/table/tbody/tr[" + linha + "]/td[" + coluna + "]");
		
		verifyByElementText(celulaTabelaDeImportacao, "Celula [linha " + linha + " - coluna " + coluna + "] da tabela de importações", valorEsperado);
	}
	
	
}
