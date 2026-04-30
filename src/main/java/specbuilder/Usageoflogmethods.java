package specbuilder;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;


public class Usageoflogmethods {
	
	@Test
	public void fetchuser() {
		
		RestAssured.baseURI = "https://reqres.in/";
		 given()
		// .log().uri()
		 .log().ifValidationFails()  //request mdhe apn ky pathvtoy he tevhch log kr jr run or validation fails
		 .when()
		 .get("api/users/1")
		 .then()
		 .assertThat()
		 //.log().headers();
		// .log().all()
		// .log().ifValidationFails() //if validation fails print the response long
		// .log().ifStatusCodeIsEqualTo(200) 
		 .log().ifError()


		 .statusCode(200);
		 
		
	}

}
