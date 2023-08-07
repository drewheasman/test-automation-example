package org.drewheasman.test.rest.common.pojo.api;

import lombok.Data;

import java.util.List;

@Data
public class GenericDataList<T> {
    private List<T> data;
}
