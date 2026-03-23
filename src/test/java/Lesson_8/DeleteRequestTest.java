package Lesson_8;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeleteRequestTest {
    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    @DisplayName("DELETE Request - проверка тела и кода ответа")
    void testDeleteRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";
        Response response = given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .extract().response();
        System.out.println("DELETE Response:");
        System.out.println("Status: " + response.getStatusCode());
        System.out.println("Body: " + response.getBody().asString());
    }
}


