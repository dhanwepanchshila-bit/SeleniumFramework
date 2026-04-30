package restPractice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;


public class PlaceOrder extends BaseData{
	
	@Test
	public void createOrder() {
		
		//String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2OTYxMzU1N2M5NDE2NDZiN2E4YzI0NTIiLCJ1c2VyRW1haWwiOiJkbWRoYW53ZUBnbWFpbC5jb20iLCJ1c2VyTW9iaWxlIjo4MTc3ODc4NzY3LCJ1c2VyUm9sZSI6ImN1c3RvbWVyIiwiaWF0IjoxNzcxNzgzNDcxLCJleHAiOjE4MDMzNDEwNzF9.q249IeGrA0_H0BXldXfj5UAx0kMri2aa7aqLHHq7utI";	

		
		RestAssured.baseURI = "https://rahulshettyacademy.com/";
		
		Response resp = given()
			    .body("{\r\n"
			        + "    \"orders\": [\r\n"
			        + "        {\r\n"
			        + "            \"country\": \"india\",\r\n"
			        + "            \"productOrderedId\": \"" + productID + "\"\r\n"
			        + "        }\r\n"
			        + "    ]\r\n"
			        + "}")
			    .header("Authorization", token)
			    .contentType("application/json")
				
			.when()
			.post("api/ecom/order/create-order")
			.then().log().all().extract().response();
			//.statusCode(201).extract().response();
		
//		String message = resp.jsonPath().getString("message");
//		System.out.println(message);
				
		
	}

}
