package org.drewheasman.pojo.api;

import lombok.Data;

import java.util.List;

@Data
public class DataList<T> {
    private List<T> data;
}
