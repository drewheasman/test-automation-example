package org.drewheasman.test.rest.reqres.pojo.reqres.data;

import lombok.EqualsAndHashCode;
import org.drewheasman.test.rest.common.pojo.api.GenericData;

@EqualsAndHashCode(callSuper = true)
@lombok.Data
public class ReqresData<T> extends GenericData<T> {
    private T data;
    private Support support;
}
