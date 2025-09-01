package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiUtils {

    public static Response postRequest(String url, String body) {
        RestAssured.useRelaxedHTTPSValidation();
        return given()
                .contentType("application/json")
                .body(body)
                .when()
                .post(url)
                .then()
                .extract().response();
    }

    public static Response getRequest(String url) {
        RestAssured.useRelaxedHTTPSValidation();
        return given()
                .when()
                .get(url)
                .then()
                .extract().response();
    }
}
