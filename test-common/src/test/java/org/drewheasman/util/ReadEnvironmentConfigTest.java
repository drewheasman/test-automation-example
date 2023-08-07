package org.drewheasman.util;

import lombok.Data;
import org.drewheasman.pojo.config.EnvironmentConfig;
import org.junit.Assert;
import org.junit.Test;

public class ReadEnvironmentConfigTest {
    @Test
    public void readConfig() {
        TestEnvironmentConfig testEnvironmentConfig = ReadEnvironmentConfig.getConfig(TestEnvironmentConfig.class);
        Assert.assertEquals("someValue", testEnvironmentConfig.getSomeAttribute());
    }

    @Test
    public void mapToInvalidClass() {
        Assert.assertThrows(RuntimeException.class, () -> ReadEnvironmentConfig.getConfig(InvalidTestEnvironmentConfig.class));
    }

    @Data
    private static class TestEnvironmentConfig implements EnvironmentConfig {
        private String someAttribute;
    }

    @Data
    private static class InvalidTestEnvironmentConfig implements EnvironmentConfig {
        private int someAttribute;
    }
}
