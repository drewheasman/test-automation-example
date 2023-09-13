package org.drewheasman.test.rest.common.pojo.config;

import lombok.Data;
import org.drewheasman.test.pojo.config.EnvironmentConfig;

import java.net.URI;

@Data
public abstract class RestConfig implements EnvironmentConfig {
    private URI apiUri;
}
