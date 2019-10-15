package RestAssuredApiTesting.aRestAssuredApiTesting;
import org.apache.poi.util.SystemOutLogger;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Request {
	
	@Test
	void getWeatherDetails () {  // THIS program is : RestAssured Automation Test Case For TESTING API's
		
		//Specify base URI
		//all api's links http://www.pavantestingtools.com/2019/05/apiwebservices-testing-using-restassured.html
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city/";
		
		//why we need to create  "httpRequest" object ? 
		//ANS. to sending request we create request object , when you send some request you need to create request object.
		RequestSpecification httpRequest = RestAssured.given();
		
		
		//3. for response create object for response,  "/Hyderabad" is a parameter , 
		// httpRequest.request(Method.GET,"/Hyderabad"); = requested to the server
		//stored response in = response object
		Response response = httpRequest.request(Method.GET,"/Hyderabad");
		
		//4 print response in console window, and here we are extracting the body in string
		//why we write "response.getBody().asString();" and stored in  string , bcz response come in JSON format 
		//so thats why we convert into string.
		// and in JSON we have a lots of things like (Header, status code, status line etc.)
		String  responseBoby = response.getBody().asString();
		System.out.println("Response Body  is :"+responseBoby);
		
		//5. how to verify status code validation 
		// again we use "response" object bcz it contains all information
		int statusCode =response.getStatusCode();
		System.out.println("My status Code is :"+statusCode);
		//now validate:
		Assert.assertEquals(statusCode, 200);
		// now verify status LINE validation
		String statusLine = response.getStatusLine();
		System.out.println("Status Line of my Response is :"+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
		
		
	}

}
