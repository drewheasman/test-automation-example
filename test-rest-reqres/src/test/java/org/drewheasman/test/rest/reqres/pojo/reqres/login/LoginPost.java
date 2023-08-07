package org.drewheasman.test.rest.reqres.pojo.reqres.login;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginPost {
    private String username;
    private String email;
    private String password;
}
