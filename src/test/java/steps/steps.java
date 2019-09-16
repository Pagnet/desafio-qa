package steps;

import br.com.blue.factory.PropertiesFactory;
import br.com.blue.report.ReportManager;
import br.com.blue.util.Globals;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import org.junit.After;
import org.junit.Before;
import pageObject.HomePage;

public class steps {

    @Dado("^usuario acessar o sistema Lista de Importacoes$")
    public void usuarioAcessarOSistemaListaDeImportacoes() throws Throwable {
        Globals.browser.setURL(PropertiesFactory.getProp().getProperty("prop.url"));
    }


    @Entao("^sera feita a validacao de todos os compradores do sistema \"([^\"]*)\"$")
    public void seraFeitaAValidacaoDeTodosOsCompradoresDoSistema(String arg0) throws Throwable {
        HomePage.homePage.validaNomeComprador(arg0);
    }

    @Entao("^sera feita a validacao de todos os precos dos produtos do sistema \"([^\"]*)\"$")
    public void seraFeitaAValidacaoDeTodosOsPrecosDosProdutosDoSistema(String arg0) throws Throwable {
        HomePage.homePage.validaPreco(arg0);

    }

    @Entao("^sera feita a validacao dos valores totais de cada compra realizada por cada comprador no sistema \"([^\"]*)\"$")
    public void seraFeitaAValidacaoDosValoresTotaisDeCadaCompraRealizadaPorCadaCompradorNoSistema(String arg0) throws Throwable {
        HomePage.homePage.validaValorTotal(arg0);

    }

    @After
    public void finalizaReport(){
        ReportManager.getInstance().flushReport();

    }
}
