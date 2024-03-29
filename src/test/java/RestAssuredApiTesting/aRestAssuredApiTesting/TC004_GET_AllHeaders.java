package RestAssuredApiTesting.aRestAssuredApiTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_GET_AllHeaders {

	@Test
	 void GetWeatherDetailsOfAllHeaders()  // IN THIS TEST CASE WE ARE VALIDATING HEADERS (This is a google MAP API)
	 {
	  
	  //Specify base URI
	  RestAssured.baseURI="https://maps.googleapis.com";
	  
	  //Request object
	  RequestSpecification httpRequest=RestAssured.given();
	  
	  //Response object		with in the this reason(33.8670522,151.1957362) whatever the market it will return by this API         	it has key value (AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s)
	  Response response=httpRequest.request(Method.GET,"/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
	  
	  //print response in console window
	  String responseBody=response.getBody().asString();
	  System.out.println("Response Body is:" +responseBody);
	  
	  //validating all headers  (capturing details of header from response)
	  Headers allHeaders= response.headers();
	 // for (Headers header:allHeaders) {  // error (Type mismatch: cannot convert from element type Header to Headers)
	    for (Header header:allHeaders) {
		  System.out.println(header);
	
	  
	 }
	 }
	 
	}
