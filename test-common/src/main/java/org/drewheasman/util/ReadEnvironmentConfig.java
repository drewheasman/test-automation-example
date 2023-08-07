package org.drewheasman.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.drewheasman.pojo.config.EnvironmentConfig;

import java.io.IOException;

public class ReadEnvironmentConfig {
    private static final String ENV_FILE = "/env.json";

    private ReadEnvironmentConfig() {
    }

    public static <T extends EnvironmentConfig> T getConfig(Class<T> configClass) {
        try {
            return new ObjectMapper().readValue(configClass.getResourceAsStream(ENV_FILE), configClass);
        } catch (IOException e) {
            throw new RuntimeException("Could not get config as given class", e);
        }
    }
}
