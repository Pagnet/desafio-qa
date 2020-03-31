package execution.run;

import org.testng.annotations.Test;

import base.testbase.Hooks;
import execution.dataprovider.ImportsDP;
import execution.testcase.ImportsTC;

public class Imports extends Hooks {

	ImportsTC importsTC;

	@Test(priority = 0, dataProvider = "cabecalhoPagina", dataProviderClass=ImportsDP.class)
	public void verificarAberturaDoSite(String cabecalho) {
		importsTC = new ImportsTC();
		importsTC.verificarCabecalhoDaPagina(cabecalho);

		softAssert.assertAll();

	}
	
	@Test(priority = 1, dataProvider = "totalizadoresDeImportacoes", dataProviderClass=ImportsDP.class)
	public void verificarTotalizadoresDeImportacoes(String valorTotalImportacaoAtual, String valorTotalImportacoes) {
		importsTC = new ImportsTC();
		importsTC.verificarTotalizadoresDeImportacoes(valorTotalImportacaoAtual, valorTotalImportacoes);

		softAssert.assertAll();

	}
	
	@Test(priority = 2, dataProvider = "titulosDaTabelaDeImportacoes", dataProviderClass=ImportsDP.class)
	public void verificarTitulosDaTabelaDeImportacoes(
			String infoTituloComprador,
			String infoTituloDescricao,
			String infoTituloPreco,
			String infoTituloQuantidade,
			String infoTituloTotal,
			String infoTituloNomeVendedor,
			String infoTituloEnderecoVendedor
			) {
		importsTC = new ImportsTC();
		importsTC.verificarTitulosDaTabelaDeImportacoes(
				infoTituloComprador,
				infoTituloDescricao,
				infoTituloPreco,
				infoTituloQuantidade,
				infoTituloTotal,
				infoTituloNomeVendedor,
				infoTituloEnderecoVendedor
				);
		
		softAssert.assertAll();
	}
		
	@Test(priority = 3, dataProvider = "linhasDaTabelaDeImportacoes", dataProviderClass=ImportsDP.class)
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
		importsTC = new ImportsTC();
		importsTC.verificarLinhaDaTabelaDeImportacoes(
				linhaDaTabelaDeImportacoes, 
				infoCelulaComprador,
				infoCelulaDescricao,
				infoCelulaPreco,
				infoCelulaQuantidade,
				infoCelulaTotal,
				infoCelulaNomeVendedor,
				infoCelulaEnderecoVendedor
				);

		softAssert.assertAll();
	}

	
}
