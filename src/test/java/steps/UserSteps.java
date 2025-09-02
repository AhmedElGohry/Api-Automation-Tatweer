package steps;

import com.aventstack.extentreports.Status;
import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class UserSteps {
    private Response response;

    @Given("the base API is set")
    public void the_base_api_is_set() {
        RestAssured.baseURI = "https://reqres.in/api";
        Hooks.test.log(Status.INFO, "Base URI set to: " + RestAssured.baseURI);
    }

    @When("I send a POST request to create a user")
    public void i_send_a_post_request_to_create_a_user() {
        String body = "{\"name\":\"morpheus\",\"job\":\"leader\"}";

        response = given()
                .header("Content-Type", "application/json")
                .header("x-api-key", "reqres-free-v1")
                .body(body)
                .when()
                .post("/users");

        Hooks.test.log(Status.INFO, "POST Request Body: " + body);
        Hooks.test.log(Status.INFO, "POST Response: " + response.getBody().asPrettyString());
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(Integer statusCode) {
        Assert.assertEquals(response.getStatusCode(), statusCode.intValue());
        Hooks.test.log(Status.PASS, "Verified status code: " + statusCode);
    }

    @When("I send a GET request with delay {int}")
    public void i_send_a_get_request_with_delay(Integer delay) {
        response = given()
                .header("x-api-key", "reqres-free-v1")
                .queryParam("delay", delay)
                .when()
                .get("/users");

        Hooks.test.log(Status.INFO, "GET Request with delay=" + delay);
        Hooks.test.log(Status.INFO, "GET Response: " + response.getBody().asPrettyString());
    }

    @Then("the first user data should not be null")
    public void the_first_user_data_should_not_be_null() {
        Map<String, Object> firstUser = response.jsonPath().getMap("data[0]");

        Assert.assertNotNull(firstUser.get("id"), "id is null!");
        Assert.assertNotNull(firstUser.get("email"), "email is null!");
        Assert.assertNotNull(firstUser.get("first_name"), "first_name is null!");
        Assert.assertNotNull(firstUser.get("avatar"), "avatar is null!");

        Hooks.test.log(Status.PASS, "Verified first user data: " + firstUser);
    }
}
