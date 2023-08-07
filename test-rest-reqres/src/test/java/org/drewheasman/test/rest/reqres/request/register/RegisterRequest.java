package org.drewheasman.test.rest.reqres.request.register;

import io.restassured.response.Response;
import org.drewheasman.test.rest.common.request.RestHelper;
import org.drewheasman.test.rest.common.request.RestRequestType;
import org.drewheasman.test.rest.reqres.pojo.reqres.register.RegisterPost;
import org.drewheasman.test.rest.reqres.request.ResreqRequest;

import static org.drewheasman.test.rest.reqres.request.RequestPath.REGISTER_PATH;

public class RegisterRequest extends ResreqRequest {
    public static Response postRegister(RegisterPost registerPost) {
        return RestHelper.requestWithBody(RestRequestType.POST, config.getApiUri(), REGISTER_PATH, registerPost);
    }
}
