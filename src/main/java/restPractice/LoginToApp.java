package restPractice;

import static org.assertj.core.api.Assertions.extractProperty;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class LoginToApp extends BaseData {
	
	@Test
	public void Login() {
		
		RestAssured.baseURI ="https://rahulshettyacademy.com/";
		
		Response resp = given()
		
		.body("{\r\n"
				+ "  \"userEmail\": \"dmdhanwe@gmail.com\",\r\n"
				+ "  \"userPassword\": \"Camsup@1234\"\r\n"
				+ "}")
		
		.headers("Content-Type", "application/json")
		.when()
		.post("api/ecom/auth/login")
		.then()
		.log().all()
		.extract()
		.response();
		
		JsonPath jp = resp.jsonPath();
		token = jp.getString("token");
	    userId = jp.getString("userId");
		String Message = jp.getString("message");
		
		System.out.println("Token= " +token);
		System.out.println("userID= " +userId);
		System.out.println("Message= " +Message);
		
	}

}
