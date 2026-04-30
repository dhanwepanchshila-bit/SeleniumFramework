package restPractice;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class E2EFlowTest {

    // 🔹 shared data (data traverse hote)
    String token;
    String productId;

    @Test(priority = 1)
    public void login() {

        RestAssured.baseURI = "https://rahulshettyacademy.com/";

        Response resp =
            given()
                .contentType("application/json")
                .body("{\r\n"
        				+ "  \"userEmail\": \"dmdhanwe@gmail.com\",\r\n"
        				+ "  \"userPassword\": \"Camsup@1234\"\r\n"
        				+ "}")
            .when()
                .post("api/ecom/auth/login")
            .then()
                .statusCode(200)
                .extract().response();

        token = resp.jsonPath().getString("token");
        System.out.println("TOKEN = " + token);
    }

    @Test(priority = 2)
    public void addProduct() {

        File productImage = new File("C:\\Users\\ec1003au\\Downloads\\jeans.png");

        Response resp =
            given()
                .header("Authorization", token)
        		.contentType("multipart/form-data")

                .multiPart("productName", "Jeans")
                .multiPart("productDescription", "Denim fashion Jeans")
                .multiPart("productCategory", "fashion")
                .multiPart("productSubCategory", "straight")
                .multiPart("productPrice", "3000")
                .multiPart("productAddedBy", "69613557c941646b7a8c2452")
                .multiPart("productFor", "women")
                .multiPart("productImage", productImage)
            .when()
                .post("api/ecom/product/add-product")
            .then()
                .statusCode(201)
                .extract().response();

        productId = resp.jsonPath().getString("productId");
        System.out.println("PRODUCT ID = " + productId);
    }

    @Test(priority = 3)
    public void placeOrder() {

        Response resp =
            given()
                .header("Authorization", token)
                .contentType("application/json")
                .body(String.format(
                	    "{ \"orders\": [ { \"country\": \"India\", \"productOrderedId\": \"%s\" } ] }",
                	    productId
                	))
            .when()
                .post("api/ecom/order/create-order")
            .then()
                .statusCode(201)
                .extract().response();

        System.out.println("ORDER MESSAGE = " + resp.jsonPath().getString("message"));
    }

    @Test(priority = 4)
    public void deleteProduct() {

        given()
            .header("Authorization", token)
        .when()
            .delete("api/ecom/product/delete-product/" + productId)
        .then()
            .statusCode(200)
            .log().all();
    }
}

// <class name="restPractice.DeleteProduct"/>