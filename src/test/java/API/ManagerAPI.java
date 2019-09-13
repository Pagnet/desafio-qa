package API;

import br.com.blue.factory.PropertiesFactory;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.core.IsEqual;

import static io.restassured.RestAssured.given;


public class ManagerAPI {

    public static ManagerAPI global = new ManagerAPI();

    static String url = PropertiesFactory.getProp().getProperty("prop.url");

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
                body("html.head.title", IsEqual.equalTo(textCompare));

    }

}
