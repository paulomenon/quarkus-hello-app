package org.pamenon;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class GreetingEventTest {

    @Test
    void testWelcomeMessage() {
        // Define the JSON payload
        String payload = """
            {
                "name": "London Java Community",
                "location": "Red Hat"
            }
            """;

        // Send a POST request and verify the response
        given().log().all()
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post("/welcome")
                .then()
                .statusCode(200)
                .body(is("Welcome to London Java Community at Red Hat"));
    }

}