package API;

import br.com.blue.factory.PropertiesFactory;
import br.com.blue.report.ReportManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;


public class Globals {

    public static Globals global = new Globals();

    static String url = PropertiesFactory.getProp().getProperty("prop.endpoint");

    public Response response;

    private RequestSpecification request;

    public RequestSpecification GETRequest(){

        RestAssured.baseURI = url;
        this.request = given();
        return request;
    }

    public void IsEqualsTitle(String textCompare){

        given().log().all().
                when().
                get(url).
                then().
                body("html.head.title", equalTo(textCompare));

    }

}
