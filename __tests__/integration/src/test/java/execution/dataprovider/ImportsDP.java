package execution.dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import base.dataproviderbase.JsonReader;

public class ImportsDP {
	
	@DataProvider(name="cabecalhoPagina")
	public static Object[][] cabecalhoPagina() throws IOException
	{
		return JsonReader.getdata("src/test/java/execution/datajson/cabecalhoPagina.json", "cabecalhoPagina");
	}
	
	@DataProvider(name="totalizadoresDeImportacoes")
	public static Object[][] totalizadoresDeImportacoes() throws IOException
	{
		return JsonReader.getdata("src/test/java/execution/datajson/totalizadoresDeImportacoes.json", "totalizadoresDeImportacoes");
	}

	@DataProvider(name="titulosDaTabelaDeImportacoes")
	public static Object[][] titulosDaTabelaDeImportacoes() throws IOException
	{
		return JsonReader.getdata("src/test/java/execution/datajson/titulosDaTabelaDeImportacoes.json", "titulosDaTabelaDeImportacoes");
	}
	
	@DataProvider(name="linhasDaTabelaDeImportacoes")
	public static Object[][] linhasDaTabelaDeImportacoes() throws IOException
	{
		return JsonReader.getdata("src/test/java/execution/datajson/linhasDaTabelaDeImportacoes.json", "linhasDaTabelaDeImportacoes");
	}
}
