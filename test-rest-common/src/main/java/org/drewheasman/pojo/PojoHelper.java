package org.drewheasman.pojo;

public class PojoHelper {
    public static final String UNDEFINED_STRING = "undefined";
    public static final Integer UNDEFINED_INTEGER = -82;

    public static Boolean defined(String field) {
        return !field.equals(UNDEFINED_STRING);
    }

    public static Boolean defined(Integer field) {
        return !field.equals(UNDEFINED_INTEGER);
    }
}
