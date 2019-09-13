package runner;

import API.ManagerAPI;
import io.restassured.http.Method;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class runnerAPI {

   @Before
    public void queFoiRealizadaARequisicaoNoSistema() throws Throwable {
        ManagerAPI.global.response = ManagerAPI.global.GETRequest().request(Method.GET, "") ;
    }

   @Test
    public void seráRealizadoARequisicaoNoSistemaEValidadoSeOMesmoFoiRealizadoComSucesso() throws Throwable {
        Assert.assertEquals("Status expected: ", ManagerAPI.global.response.statusLine(), "HTTP/1.1 200 OK");
    }

  @Test
    public void seráRealizadoARequisicaoNoSistemaEValidadoSeOTextoDoTituloFoiEncontradoComSucesso() throws Throwable {
        ManagerAPI.global.IsEqualsTitle("Teste realizado por Saulo Santiago");
    }

}
