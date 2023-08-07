package org.drewheasman.test.rest.common.request;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestHelper {
    public static Response request(RestRequestType requestType, URI baseUri, String path) {
        return request(requestType, null, baseUri, path, Map.of(), Map.of(), null);
    }

    public static Response requestWithBody(RestRequestType requestType, URI baseUri, String path, Object body) {
        return request(requestType, null, baseUri, path, Map.of(), Map.of(), body);
    }

    public static Response request(RestRequestType requestType, URI baseUri, String path, Map<String, String> pathKeyValues) {
        return request(requestType, null, baseUri, path, pathKeyValues, Map.of(), null);
    }

    public static Response requestWithBody(RestRequestType requestType, URI baseUri, String path, Map<String, String> pathKeyValues, Object body) {
        return request(requestType, null, baseUri, path, pathKeyValues, Map.of(), body);
    }

    private static Response request(RestRequestType requestType, String token, URI baseUri, String path, Map<String, String> pathKeyValues, Map<String, String> queryKeyValues, Object body) {
        RequestSpecification request;

        if (body == null) {
            request = given(RestSpecification.requestSpec(baseUri));
        } else {
            request = given(RestSpecification.requestSpec(baseUri, ContentType.JSON));
            request.body(body);
        }

        if (token != null) {
            request.auth().oauth2(token);
        }

        request.pathParams(pathKeyValues);
        request.queryParams(queryKeyValues);

        Response response = switch (requestType) {
            case GET -> request.when().get(path);
            case PATCH -> request.when().patch(path);
            case PUT -> request.when().put(path);
            case POST -> request.when().post(path);
            case DELETE -> request.when().delete(path);
        };

        ValidatableResponse validatableResponse;

        if (response.getBody().asString().isEmpty()) {
            validatableResponse = response.then().spec(RestSpecification.responseSpec());
        } else {
            validatableResponse = response.then().spec(RestSpecification.responseSpec(ContentType.JSON));
        }

        return validatableResponse.extract().response();
    }
}
