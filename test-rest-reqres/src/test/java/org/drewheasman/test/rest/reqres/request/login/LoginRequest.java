package org.drewheasman.test.rest.reqres.request.login;

import io.restassured.response.Response;
import org.drewheasman.test.rest.common.request.RestHelper;
import org.drewheasman.test.rest.common.request.RestRequestType;
import org.drewheasman.test.rest.reqres.pojo.reqres.login.LoginPost;
import org.drewheasman.test.rest.reqres.request.ResreqRequest;

import static org.drewheasman.test.rest.reqres.request.RequestPath.LOGIN_PATH;

public class LoginRequest extends ResreqRequest {
    public static Response postLogin(LoginPost loginPost) {
        return RestHelper.requestWithBody(RestRequestType.POST, config.getApiUri(), LOGIN_PATH, loginPost);
    }
}
