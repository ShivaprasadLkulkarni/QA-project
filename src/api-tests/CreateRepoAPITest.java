package api_tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RepositoryApiTest {

    @Test
    public void createRepository() {
        String token = "ghp_abCdefgHIJklMnOpQrSTUvWxYz1234567890"; //sample token
        String repoName = "api-test-repo";

        Response response = RestAssured.given()
                .header("Authorization", "token " + token)
                .header("Content-Type", "application/json")
                .body("{\"name\": \"" + repoName + "\", \"private\": false}")
                .post("https://api.github.com/user/repos");

        Assert.assertEquals(response.getStatusCode(), 201);  
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains(repoName));
    }
}
