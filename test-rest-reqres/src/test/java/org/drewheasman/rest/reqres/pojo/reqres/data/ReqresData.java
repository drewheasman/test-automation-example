package org.drewheasman.rest.reqres.pojo.reqres.data;

import lombok.EqualsAndHashCode;
import org.drewheasman.pojo.api.Data;

@EqualsAndHashCode(callSuper = true)
@lombok.Data
public class ReqresData<T> extends Data<T> {
    private T data;
    private Support support;
}
