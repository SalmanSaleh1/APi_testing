import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Task1 {

    @Test
    public void testGetBookingIds() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

        Response response = given()
                .when()
                .get("/booking")
                .then()
                .statusCode(200)
                .extract()
                .response();

        System.out.println("Response Body: " + response.asString());
    }
}