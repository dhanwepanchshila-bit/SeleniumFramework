package specbuilder;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RequestandResponseSpecBuilder {
	
	RequestSpecification requestspecification ;
	ResponseSpecification responsesepcification;

	@BeforeClass
	public void initRequestAndResponse() {
		
		RequestSpecBuilder reqspecbuild = new RequestSpecBuilder();
		reqspecbuild.setBaseUri("https://rahulshettyacademy.com/");
		reqspecbuild.addHeader("Content-Type", "application/json");
		reqspecbuild.log(LogDetail.ALL);
		
		requestspecification = reqspecbuild.build(); //all above things we defined will be in this requestspecification object
		
		ResponseSpecBuilder resSpecbuild = new ResponseSpecBuilder();
		resSpecbuild.expectStatusCode(200);
		resSpecbuild.expectContentType(ContentType.JSON);
		resSpecbuild.log(LogDetail.ALL);

		
		responsesepcification = resSpecbuild.build();
	}
	
	@Test
     public void Login() {
		
		
		        given(requestspecification)
		
				//.spec(requestspecification) we can also write requestspecification in give directly but we can't do the same with then
		
		.body("{\r\n"
				+ "  \"userEmail\": \"dmdhanwe@gmail.com\",\r\n"
				+ "  \"userPassword\": \"Camsup@1234\"\r\n"
				+ "}")
		
		
		.when()
		.post("api/ecom/auth/login")
		.then()
		.spec(responsesepcification);

		
		
		
	}

}
