package org.drewheasman.test.rest.common.request;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.net.URI;

public class RestSpecification {
    public static RequestSpecification requestSpec(URI baseUri) {
        RequestSpecBuilder builder = new RequestSpecBuilder();

        builder.log(LogDetail.ALL);
        builder.setBaseUri(baseUri);
        builder.noContentType();

        return builder.build();
    }

    public static RequestSpecification requestSpec(URI baseUri, ContentType contentType) {
        RequestSpecBuilder builder = new RequestSpecBuilder();

        builder.log(LogDetail.ALL);
        builder.setBaseUri(baseUri);
        builder.setContentType(contentType);

        return builder.build();
    }

    public static ResponseSpecification responseSpec() {
        ResponseSpecBuilder builder = new ResponseSpecBuilder();

        builder.log(LogDetail.ALL);

        return builder.build();
    }

    public static ResponseSpecification responseSpec(ContentType contentType) {
        ResponseSpecBuilder builder = new ResponseSpecBuilder();

        builder.log(LogDetail.ALL);
        builder.expectContentType(contentType);

        return builder.build();
    }
}
