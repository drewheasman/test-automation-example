package org.drewheasman.test.rest.common.pojo;

public class PojoHelper {
    private static final String UNDEFINED_STRING = "undefined";
    private static final Integer UNDEFINED_INTEGER = -82;

    private PojoHelper() {
    }

    public static Boolean defined(String field) {
        return !field.equals(UNDEFINED_STRING);
    }

    public static Boolean defined(Integer field) {
        return !field.equals(UNDEFINED_INTEGER);
    }
}
