package RestAssuredApiTesting.aRestAssuredApiTesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC005_GET_ValiadtingJSONBody {

	@Test
	 void verifyJSONBody()  // IN THIS TEST CASE WE ARE VALIDATING HEADERS (This is a google MAP API)
	 {
	  
	  //Specify base URI
	  RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city/";
	  
	  //Request object
	  RequestSpecification httpRequest=RestAssured.given();
	  
	  Response response=httpRequest.request(Method.GET,"/Delhi");
	  
	  //print response in console window
	  String responseBody=response.getBody().asString();
	  System.out.println("Response Body is:" +responseBody);
	  
	  Assert.assertEquals(responseBody.contains("Delhi"), true);
	  
	  //Extracting values of each nodes in JSON
	  
	  JsonPath jsonPathObj =  response.jsonPath();
	  System.out.println(jsonPathObj.get("City"));
	  System.out.println(jsonPathObj.get("Temperature"));
	  System.out.println(jsonPathObj.get("Humidity"));
	  System.out.println(jsonPathObj.get("WeatherDescription"));
	  System.out.println(jsonPathObj.get("CiWindSpeedty"));

	Assert.assertEquals(jsonPathObj.get("Temperature"), "27.88 Degree celsius");
	  
	
	 }
	 
	}
