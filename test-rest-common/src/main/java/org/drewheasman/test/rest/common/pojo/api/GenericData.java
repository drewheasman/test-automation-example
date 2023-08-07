package org.drewheasman.test.rest.common.pojo.api;

@lombok.Data
public class GenericData<T> {
    private T data;
}
