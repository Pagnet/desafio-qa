package execution.testcase;

import execution.pageobject.ImportsPO;

public class ImportsTC {

	ImportsPO importsPO;
	
	public ImportsTC() {
		importsPO = new ImportsPO();	     
	}
	
	public void verificarCabecalhoDaPagina(String cabecalho) {
		importsPO.verificarCabecalhoDaPagina(cabecalho);
		
	}
	
	public void verificarTotalizadoresDeImportacoes(String valorTotalImportacaoAtual, String valorTotalImportacoes) {
		importsPO.verificarPrecoTotalDaImportacaoAtual(valorTotalImportacaoAtual);
		importsPO.verificarPrecoTotalDeImportacoes(valorTotalImportacoes);
		
	}
	
	public void verificarTitulosDaTabelaDeImportacoes(
			String infoTituloComprador,
			String infoTituloDescricao,
			String infoTituloPreco,
			String infoTituloQuantidade,
			String infoTituloTotal,
			String infoTituloNomeVendedor,
			String infoTituloEnderecoVendedor
			) {
		importsPO.verificarTituloTabelaDeImportacao("1", infoTituloComprador);
		importsPO.verificarTituloTabelaDeImportacao("2", infoTituloDescricao);
		importsPO.verificarTituloTabelaDeImportacao("3", infoTituloPreco);
		importsPO.verificarTituloTabelaDeImportacao("4", infoTituloQuantidade);
		importsPO.verificarTituloTabelaDeImportacao("5", infoTituloTotal);
		importsPO.verificarTituloTabelaDeImportacao("6", infoTituloNomeVendedor);
		importsPO.verificarTituloTabelaDeImportacao("7", infoTituloEnderecoVendedor);
		
	}
	
	public void verificarLinhaDaTabelaDeImportacoes(
			String linhaDaTabelaDeImportacoes, 
			String infoCelulaComprador,
			String infoCelulaDescricao,
			String infoCelulaPreco,
			String infoCelulaQuantidade,
			String infoCelulaTotal,
			String infoCelulaNomeVendedor,
			String infoCelulaEnderecoVendedor
			) {
		importsPO.verificarCelulaTabelaDeImportacao(linhaDaTabelaDeImportacoes, "1", infoCelulaComprador);
		importsPO.verificarCelulaTabelaDeImportacao(linhaDaTabelaDeImportacoes, "2", infoCelulaDescricao);
		importsPO.verificarCelulaTabelaDeImportacao(linhaDaTabelaDeImportacoes, "3", infoCelulaPreco);
		importsPO.verificarCelulaTabelaDeImportacao(linhaDaTabelaDeImportacoes, "4", infoCelulaQuantidade);
		importsPO.verificarCelulaTabelaDeImportacao(linhaDaTabelaDeImportacoes, "5", infoCelulaTotal);
		importsPO.verificarCelulaTabelaDeImportacao(linhaDaTabelaDeImportacoes, "6", infoCelulaNomeVendedor);
		importsPO.verificarCelulaTabelaDeImportacao(linhaDaTabelaDeImportacoes, "7", infoCelulaEnderecoVendedor);
		
	}
}
