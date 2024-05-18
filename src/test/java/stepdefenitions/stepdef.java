package stepdefenitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import static junit.framework.Assert.assertEquals;

public class stepdef {

    public int statuscode;
    RequestSpecification httpRequest;
    Response response;
    public int responseCode;
    public ResponseBody body;
    public JSONObject requestParam = new JSONObject();
    public JsonPath jsonPath;


    @Given("I hit the url of get single user api endpoint")
    public void iHitTheUrlOfGetSingleUserApiEndpoint() {
        RestAssured.baseURI = "https://reqres.in/api/";
    }

    @When("I pass the url in the request api Get Single user")
    public void iPassTheUrlInTheRequestApiGetSingleUser() {
        httpRequest = RestAssured.given();
        response =  httpRequest.get("users/2");
    }


    @Then("I receive the response code as {int}")
    public void iReceiveTheResponseCodeAs(int arg0) {
        responseCode = response.getStatusCode();
        assertEquals(responseCode,200);
    }
}