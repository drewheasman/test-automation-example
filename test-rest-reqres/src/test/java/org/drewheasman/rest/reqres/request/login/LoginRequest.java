package org.drewheasman.rest.reqres.request.login;

import io.restassured.response.Response;
import org.drewheasman.request.RestHelper;
import org.drewheasman.request.RestRequestType;
import org.drewheasman.rest.reqres.pojo.reqres.login.LoginPost;
import org.drewheasman.rest.reqres.request.ResreqRequest;

import static org.drewheasman.rest.reqres.request.RequestPath.LOGIN_PATH;

public class LoginRequest extends ResreqRequest {
    public static Response postLogin(LoginPost loginPost) {
        return RestHelper.requestWithBody(RestRequestType.POST, config.getApiUri(), LOGIN_PATH, loginPost);
    }
}
