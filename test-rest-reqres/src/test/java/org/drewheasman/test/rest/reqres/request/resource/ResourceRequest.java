package org.drewheasman.test.rest.reqres.request.resource;

import io.restassured.response.Response;
import org.drewheasman.test.rest.common.request.RestHelper;
import org.drewheasman.test.rest.common.request.RestRequestType;
import org.drewheasman.test.rest.reqres.pojo.reqres.resource.UnknownResourcePost;
import org.drewheasman.test.rest.reqres.request.ResreqRequest;

import java.util.Map;

import static org.drewheasman.test.rest.reqres.request.RequestKey.ID_PATH_KEY;
import static org.drewheasman.test.rest.reqres.request.RequestKey.RESOURCE_PATH_KEY;
import static org.drewheasman.test.rest.reqres.request.RequestPath.RESOURCE_ID_PATH;
import static org.drewheasman.test.rest.reqres.request.RequestPath.RESOURCE_PATH;

public class ResourceRequest extends ResreqRequest {
    public static Response getResourceList(String resource) {
        return RestHelper.request(RestRequestType.GET, config.getApiUri(), RESOURCE_PATH, Map.of(RESOURCE_PATH_KEY, resource));
    }

    public static Response getResource(String resource, String id) {
        return RestHelper.request(RestRequestType.GET, config.getApiUri(), RESOURCE_ID_PATH, Map.of(RESOURCE_PATH_KEY, resource, ID_PATH_KEY, id));
    }

    public static Response putResource(String resource, String id, UnknownResourcePost unknownResourcePost) {
        return RestHelper.requestWithBody(RestRequestType.PUT, config.getApiUri(), RESOURCE_ID_PATH, Map.of(RESOURCE_PATH_KEY, resource, ID_PATH_KEY, id), unknownResourcePost);
    }

    public static Response patchResource(String resource, String id, UnknownResourcePost unknownResourcePost) {
        return RestHelper.requestWithBody(RestRequestType.PATCH, config.getApiUri(), RESOURCE_ID_PATH, Map.of(RESOURCE_PATH_KEY, resource, ID_PATH_KEY, id), unknownResourcePost);
    }

    public static Response deleteResource(String resource, String id) {
        return RestHelper.request(RestRequestType.DELETE, config.getApiUri(), RESOURCE_ID_PATH, Map.of(RESOURCE_PATH_KEY, resource, ID_PATH_KEY, id));
    }
}
