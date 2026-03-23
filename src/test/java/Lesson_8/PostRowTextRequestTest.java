package Lesson_8;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostRowTextRequestTest {
    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    @DisplayName("POST Row Text Request - проверка тела и кода ответа")
    void testPostRowTextRequest() {
        String requestBody = "{ \"test\": \"value\" }";
        Response response = given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data.test", equalTo("value"))
                .body("json.test", equalTo("value"))
                .extract().response();
        System.out.println("POST Row Text Response:");
        System.out.println("Status: " + response.getStatusCode());
        System.out.println("Body: " + response.getBody().asString());
    }
}
