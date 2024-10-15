package api_tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CreateRepoAPITest {
    public static void main(String[] args) {
        // Set base URI
        RestAssured.baseURI = "https://api.github.com";

        // Your personal access token (replace with your token)
        String token = "your_personal_access_token";

        // Make POST request to create a new repository
        Response response = given()
            .header("Authorization", "token " + token)
            .header("Content-Type", "application/json")
            .body("{\"name\": \"TestRepo\", \"private\": false}")
            .when()
            .post("/user/repos");

        // Verify the response code is 201 Created
        response.then().statusCode(201);

        // Print response body
        System.out.println(response.getBody().asString());
    }
}

