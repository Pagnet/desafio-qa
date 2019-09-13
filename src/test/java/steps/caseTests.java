package steps;

import br.com.blue.factory.PropertiesFactory;
import br.com.blue.util.Globals;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;

public class caseTests {

    @Dado("^usuário acessar o sistema Lista de Importações$")
    public void usuárioAcessarOSistemaListaDeImportações() throws Throwable {
        Globals.browser.setURL(PropertiesFactory.getProp().getProperty("prop.url"));
    }

    @Então("^será feita a validação de todos os compradores do sistema$")
    public void seráFeitaAValidaçãoDeTodosOsCompradoresDoSistema() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Então("^será feita a validação de todos os precos dos produtos do sistema$")
    public void seráFeitaAValidaçãoDeTodosOsPrecosDosProdutosDoSistema() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }




}
