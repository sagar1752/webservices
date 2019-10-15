package RestAssuredApiTesting.aRestAssuredApiTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveAuthProvider;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC006_GET_Authentication {

	@Test
	void verifyAuthentication()  // IN THIS TEST CASE WE ARE VALIDATING Authentication
	{
		//1. Specify base URI
		RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";

		//start  (run all code to comment this block)

		//Basic Authentication
		//RequestSpecification is a predefined class in restAssured. create object
		PreemptiveBasicAuthScheme authScheme =  new PreemptiveBasicAuthScheme();
		authScheme.setUserName("ToolsQA");
		authScheme.setPassword("TestPassword");

		// we need to specify that what type of authentication (authScheme).  "authentication" is a method
		RestAssured.authentication=authScheme;
		//END

		//Request object   at the time of request it will use authentication
		RequestSpecification httpRequest=RestAssured.given();// using this object we send the request

		//Response object
		// we are adding just slash / bcz we don't have any parameter. slash representing home page
		Response response=httpRequest.request(Method.GET,"/");// what type of request you are sending is GET

		int statusCode =response.getStatusCode();
		System.out.println("My status Code is :"+statusCode);
		//now validate:
		Assert.assertEquals(statusCode, 200);	

		//print response in console window
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is:" +responseBody);
	}
}
