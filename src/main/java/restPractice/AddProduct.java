package restPractice;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;


public class AddProduct extends BaseData{
	
	@Test
	public void addProduct(){
		File productImage = new File("C:\\Users\\ec1003au\\Downloads\\jeans.png");
		//String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2OTYxMzU1N2M5NDE2NDZiN2E4YzI0NTIiLCJ1c2VyRW1haWwiOiJkbWRoYW53ZUBnbWFpbC5jb20iLCJ1c2VyTW9iaWxlIjo4MTc3ODc4NzY3LCJ1c2VyUm9sZSI6ImN1c3RvbWVyIiwiaWF0IjoxNzcxNzgzNDcxLCJleHAiOjE4MDMzNDEwNzF9.q249IeGrA0_H0BXldXfj5UAx0kMri2aa7aqLHHq7utI";
		RestAssured.baseURI= "https://rahulshettyacademy.com/";
		
		Response resp = given()
				
		.header("Authorization",token)
		.contentType("multipart/form-data")
		
		//form fields
		.multiPart("productName", "Jeans")
		.multiPart("productDescription", "Denim fashion Jeans")
		.multiPart("productCategory", "fashion")
		.multiPart("productSubCategory", "straight")
		.multiPart("productPrice", "2000")
		.multiPart("productAddedBy", "69613557c941646b7a8c2452")
		.multiPart("productFor", "women")
		.multiPart("productImage", productImage)
		
		.when()
		  .post("api/ecom/product/add-product")
		
		.then()
		  .log().all()
		  .statusCode(201).extract().response();
		
		productID = resp.jsonPath().getString("productId");
		 userID = resp.jsonPath().getString("userId");
		
		
		  
	}

}
