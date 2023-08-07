package org.drewheasman.rest.reqres.request.logout;

import io.restassured.response.Response;
import org.drewheasman.request.RestHelper;
import org.drewheasman.request.RestRequestType;
import org.drewheasman.rest.reqres.request.ResreqRequest;

import static org.drewheasman.rest.reqres.request.RequestPath.LOGOUT_PATH;

public class LogoutRequest extends ResreqRequest {
    public static Response postLogout() {
        return RestHelper.request(RestRequestType.POST, config.getApiUri(), LOGOUT_PATH);
    }
}
