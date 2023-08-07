package org.drewheasman.rest.reqres.request;

import org.drewheasman.rest.reqres.pojo.config.ReqresConfig;
import org.drewheasman.util.ReadEnvironmentConfig;

public abstract class ResreqRequest {
    protected static final ReqresConfig config = ReadEnvironmentConfig.getConfig(ReqresConfig.class);
}
