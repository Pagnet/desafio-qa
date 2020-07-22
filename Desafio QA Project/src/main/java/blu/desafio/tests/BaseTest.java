package blu.desafio.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import blu.desafio.core.DriverFactory;
import blu.desafio.pages.ListaImportacoesPage;

public class BaseTest {

	static ListaImportacoesPage listaPage = new ListaImportacoesPage();
	
	@BeforeClass
	public static void inicializa() {
		listaPage.acessarTela();
	}
	
	@AfterClass
	public static void finaliza() {
		DriverFactory.killDriver();
	}

}
