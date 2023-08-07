package org.drewheasman.rest.reqres.pojo.reqres.register;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegisterPost {
    private String username;
    private String email;
    private String password;
}
