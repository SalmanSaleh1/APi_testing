import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Task2 {

    @Test
    public void testAuthPostRequestTask2() {
        // Base URL for the API
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

        // Request body for the POST request
        String requestBody = "{\n" +
                "  \"username\": \"admin\",\n" +
                "  \"password\": \"password123\"\n" +
                "}";

        // Send the POST request to the /auth endpoint
        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/auth")
                .then()
                .statusCode(200) // Ensure the status code is 200
                .extract().response(); // Get the response

        // Print the response body for Task2
        System.out.println("Response Body for Task2: " + response.asString());
    }
}
