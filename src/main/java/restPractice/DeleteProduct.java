package restPractice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;


public class DeleteProduct extends BaseData {
	
	
	@Test
	public void deletProduct() {
		
		//String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2OTYxMzU1N2M5NDE2NDZiN2E4YzI0NTIiLCJ1c2VyRW1haWwiOiJkbWRoYW53ZUBnbWFpbC5jb20iLCJ1c2VyTW9iaWxlIjo4MTc3ODc4NzY3LCJ1c2VyUm9sZSI6ImN1c3RvbWVyIiwiaWF0IjoxNzcxNzgzNDcxLCJleHAiOjE4MDMzNDEwNzF9.q249IeGrA0_H0BXldXfj5UAx0kMri2aa7aqLHHq7utI";	

		
		RestAssured.baseURI = "https://rahulshettyacademy.com/api/";
		
		given()
		.headers("Authorization", token)
		.when()
		.delete("ecom/product/delete-product/"+productID+"")
		.then()
		.statusCode(200).log().all();
		
		
	}

}
