package org.drewheasman.pojo.config;

import lombok.Data;

import java.net.URI;

@Data
public abstract class ApiConfig implements EnvironmentConfig {
    private URI apiUri;
}
