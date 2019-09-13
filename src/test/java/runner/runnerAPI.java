package runner;

import API.Globals;
import io.restassured.http.Method;
import org.junit.Assert;
import org.junit.Test;


public class runnerAPI{


    @Test
    public void testStatusCode(){

        Globals.global.response = Globals.global.GETRequest().request(Method.GET, "") ;
        Assert.assertEquals("Status expected: ", Globals.global.response.statusLine(), "HTTP/1.1 200 OK");

        System.out.println("Header : "+  Globals.global.response.body());
    }

    @Test
    public void testCompareTitle(){

       Globals.global.IsEqualsTitle("Teste realizado por Saulo Santiago");
    }


}
