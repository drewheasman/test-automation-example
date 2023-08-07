package org.drewheasman.test.rest.common.pojo.config;

import lombok.Data;
import org.drewheasman.test.config.EnvironmentConfig;

import java.net.URI;

@Data
public abstract class ApiConfig implements EnvironmentConfig {
    private URI apiUri;
}
