package org.drewheasman.test.rest.reqres.request;

import org.drewheasman.test.rest.reqres.pojo.config.ReqresConfig;
import org.drewheasman.test.util.ReadEnvironmentConfig;

public abstract class ResreqRequest {
    protected static final ReqresConfig config = ReadEnvironmentConfig.getConfig(ReqresConfig.class);
}
