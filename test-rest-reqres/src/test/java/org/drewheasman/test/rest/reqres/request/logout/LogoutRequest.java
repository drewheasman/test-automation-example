package org.drewheasman.test.rest.reqres.request.logout;

import io.restassured.response.Response;
import org.drewheasman.test.rest.common.request.RestHelper;
import org.drewheasman.test.rest.common.request.RestRequestType;
import org.drewheasman.test.rest.reqres.request.RequestPath;
import org.drewheasman.test.rest.reqres.request.ResreqRequest;

public class LogoutRequest extends ResreqRequest {
    public static Response postLogout() {
        return RestHelper.request(RestRequestType.POST, config.getApiUri(), RequestPath.LOGOUT_PATH);
    }
}
