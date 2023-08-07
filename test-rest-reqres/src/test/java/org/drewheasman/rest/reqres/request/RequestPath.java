package org.drewheasman.rest.reqres.request;

import static org.drewheasman.rest.reqres.request.RequestKey.ID_PATH_KEY;
import static org.drewheasman.rest.reqres.request.RequestKey.RESOURCE_PATH_KEY;

public class RequestPath {
    public static final String ROOT_PATH = "";
    public static final String RESOURCE_PATH = String.format("%s/{%s}", ROOT_PATH, RESOURCE_PATH_KEY);
    public static final String RESOURCE_ID_PATH = String.format("%s/{%s}", RESOURCE_PATH, ID_PATH_KEY);
    public static final String USERS_PATH = String.format("%s/users", ROOT_PATH);
    public static final String USERS_ID_PATH = String.format("%s/{%s}", USERS_PATH, ID_PATH_KEY);
    public static final String REGISTER_PATH = String.format("%s/register", ROOT_PATH);
    public static final String LOGIN_PATH = String.format("%s/login", ROOT_PATH);
    public static final String LOGOUT_PATH = String.format("%s/logout", ROOT_PATH);
}
