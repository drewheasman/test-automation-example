package org.drewheasman.test.ui.common.pojo.config;

import lombok.Data;
import org.drewheasman.test.pojo.config.EnvironmentConfig;

import java.net.URL;

@Data
public abstract class UIConfig implements EnvironmentConfig {
    private URL websiteUrl;
}
