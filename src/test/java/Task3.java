import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import models.Pet;
import models.PetResponse;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Task3 {

    @Test
    public void testPostRequestWithPOJO() {
        // Base URL for the PetStore API
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        // Create the Pet object (request body)
        Pet petRequest = new Pet();
        petRequest.setId(101);
        petRequest.setName("Doggie");
        petRequest.setStatus("available");

        // Send the POST request to /pet endpoint
        PetResponse petResponse = given()
                .header("Content-Type", "application/json")
                .body(petRequest)  // Send POJO as JSON body
                .when()
                .post("/pet")
                .then()
                .statusCode(200) // Ensure the status code is 200
                .extract()
                .as(PetResponse.class);  // Convert response JSON to POJO

        // Validate response body using the POJO
        System.out.println("Response ID: " + petResponse.getId());
        System.out.println("Response Name: " + petResponse.getName());
        System.out.println("Response Status: " + petResponse.getStatus());

        // Additional assertions to verify the response
        assert petResponse.getId() == petRequest.getId();
        assert petResponse.getName().equals(petRequest.getName());
        assert petResponse.getStatus().equals(petRequest.getStatus());
    }
}
