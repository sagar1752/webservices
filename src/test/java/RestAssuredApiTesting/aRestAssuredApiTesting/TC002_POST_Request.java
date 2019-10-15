package RestAssuredApiTesting.aRestAssuredApiTesting;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class TC002_POST_Request {

	@Test
	void regestrationSuccessfull () {  // THIS program is : RestAssured Automation Test Case For TESTING API's

		//Specify base URI
		//all api's links http://www.pavantestingtools.com/2019/05/apiwebservices-testing-using-restassured.html
		RestAssured.baseURI="http://restapi.demoqa.com/customer/";

		//why we need to create  "httpRequest" object ? 
		//ANS. to sending request we create request object , when you send some request you need to create request object.
		RequestSpecification httpRequest = RestAssured.given();

		//3. now this is POST  request so we need to post some request to server  in JSON format 
		// so  we need to send request in JSON format, than it will create new record in DataBase
		//  before sending request we need to create data/ body for that   we use some different class JSONObject and create obj
		// Request PAYLOAD (means request body) sending along with post request
		JSONObject requestParameter = new JSONObject();
		requestParameter.put("FirstName","SAGAR1");  //  if data is already available in data base then status code will be show 200
		requestParameter.put("LastName","SAGARo1");  // so data should be unique
		requestParameter.put("UserName","SAGAR1");
		requestParameter.put("Password","SAGARxyx1");
		requestParameter.put("Email","SAGAR1@gmail.com");

		// we need to specify which kind of data we are sending 
		// we need to specify header also
		// httpRequest.header(headerName, headerValue, additionalHeaderValues)
		//									which type, above data is JSON type
		httpRequest.header("Content-Type","application/json");
		// now we need to attached parameter and header with POST request . for that
		httpRequest.body(requestParameter.toJSONString());

		// now we send request
		Response response = httpRequest.request(Method.POST,"/register");

		//4 print response in console window, and here we are extracting the body in string
		//why we write "response.getBody().asString();" and stored in  string , bcz response come in JSON format 
		//so thats why we convert into string.
		// and in JSON we have a lots of things like (Header, status code, status line etc.)
		String  responseBoby = response.getBody().asString(); // attached above data to the request
		System.out.println("Response Body  is :"+responseBoby);

		//5. how to verify status code validation 
		// again we use "response" object bcz it contains all information
		int statusCode =response.getStatusCode();
		System.out.println("My status Code is :"+statusCode);
		//now validate:
		Assert.assertEquals(statusCode, 201);

		// success code is a part of response body, so how we extract success body
		//"response" contains everything
		//Success code valiadtion
		String successCodeResponse = response.jsonPath().get("SuccessCode");
		Assert.assertEquals(successCodeResponse, "OPERATION_SUCCESS");
	}
}
