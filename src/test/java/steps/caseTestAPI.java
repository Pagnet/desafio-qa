package steps;

import API.ManagerAPI;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import io.restassured.http.Method;
import org.junit.Assert;

public class caseTestAPI {


    @Dado("^que foi realizada a requisicao no sistema$")
    public void queFoiRealizadaARequisicaoNoSistema() throws Throwable {
        ManagerAPI.global.response = ManagerAPI.global.GETRequest().request(Method.GET, "") ;
    }

    @Então("^será realizado a requisicao no sistema e validado se o mesmo foi realizado com sucesso$")
    public void seráRealizadoARequisicaoNoSistemaEValidadoSeOMesmoFoiRealizadoComSucesso() throws Throwable {
        Assert.assertEquals("Status expected: ", ManagerAPI.global.response.statusLine(), "HTTP/1.1 200 OK");
    }

    @Então("^será realizado a requisicao no sistema e validado se o texto do titulo foi encontrado com sucesso$")
    public void seráRealizadoARequisicaoNoSistemaEValidadoSeOTextoDoTituloFoiEncontradoComSucesso() throws Throwable {
        ManagerAPI.global.IsEqualsTitle("Teste realizado por Saulo Santiago");
    }

}
