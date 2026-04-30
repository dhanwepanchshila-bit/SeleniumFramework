package restPractice;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

public class Basics {
	
public static void main(String[] args) {
	
	String newAddress = "70 Summer walk, USA";
	
	RestAssured.baseURI = "https://rahulshettyacademy.com";
	
	String response = given().log().all()
	.queryParam("key", "qaclick123")
	.header("Content-Type", "application/json")
	.body(Payload.addPlace())
	.when()
	.post("maps/api/place/add/json")
	.then()
	.assertThat()
	.statusCode(200)
	.body("scope", equalTo("APP"))
	.header("server", "Apache/2.4.52 (Ubuntu)")
	.extract().response().asString();
	
	System.out.println(response);
	JsonPath js = new JsonPath(response); //for parsing json
	String placeId = js.getString("place_id");
	System.out.println(placeId);
	
	given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
	.body("{\r\n"
			+ "\"place_id\":\""+placeId+ "\",\r\n"
			+ "\"address\":\""+newAddress+"\",\r\n"
			+ "\"key\":\"qaclick123\"\r\n"
			+ "}")
	.when()
	.put("maps/api/place/update/json")
	.then()
	.assertThat().log().all()
	.statusCode(200)
	.body("msg", equalTo("Address successfully updated"));
	
    String getPlaceResponse = given().log().all().queryParam("key", "qaclick123").queryParam("place_id",placeId)
    		                 .when()
    		                 .get("/maps/api/place/get/json")
    		                 .then()
    		                 .assertThat()
    		                 .statusCode(200).log().all().extract().response().asString();
    
    JsonPath js1 = new JsonPath(getPlaceResponse);
    String Actualaddress = js1.getString("address");
    System.out.println(Actualaddress);
    Assert.assertEquals(Actualaddress, newAddress);
    		                
}
}
