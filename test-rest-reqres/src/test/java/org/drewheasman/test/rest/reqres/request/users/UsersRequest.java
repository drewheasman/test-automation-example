package org.drewheasman.test.rest.reqres.request.users;

import io.restassured.response.Response;
import org.drewheasman.test.rest.common.request.RestHelper;
import org.drewheasman.test.rest.common.request.RestRequestType;
import org.drewheasman.test.rest.reqres.pojo.reqres.user.UserPost;
import org.drewheasman.test.rest.reqres.request.ResreqRequest;

import java.util.Map;

import static org.drewheasman.test.rest.reqres.request.RequestKey.ID_PATH_KEY;
import static org.drewheasman.test.rest.reqres.request.RequestPath.USERS_ID_PATH;
import static org.drewheasman.test.rest.reqres.request.RequestPath.USERS_PATH;

public class UsersRequest extends ResreqRequest {
    public static Response getUserList() {
        return RestHelper.request(RestRequestType.GET, config.getApiUri(), USERS_PATH);
    }

    public static Response getUser(String id) {
        return RestHelper.request(RestRequestType.GET, config.getApiUri(), USERS_ID_PATH, Map.of(ID_PATH_KEY, id));
    }

    public static Response putUser(String id, UserPost user) {
        return RestHelper.requestWithBody(RestRequestType.PUT, config.getApiUri(), USERS_ID_PATH, Map.of(ID_PATH_KEY, id), user);
    }

    public static Response patchUser(String id, UserPost user) {
        return RestHelper.requestWithBody(RestRequestType.PATCH, config.getApiUri(), USERS_ID_PATH, Map.of(ID_PATH_KEY, id), user);
    }

    public static Response deleteUser(String id) {
        return RestHelper.request(RestRequestType.DELETE, config.getApiUri(), USERS_ID_PATH, Map.of(ID_PATH_KEY, id));
    }
}
