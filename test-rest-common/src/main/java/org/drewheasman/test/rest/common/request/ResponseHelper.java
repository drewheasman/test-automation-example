package org.drewheasman.test.rest.common.request;

import com.fasterxml.jackson.databind.type.TypeFactory;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.drewheasman.test.rest.common.pojo.api.GenericData;
import org.drewheasman.test.rest.common.pojo.api.GenericDataList;

import java.lang.reflect.Type;
import java.util.List;

public interface ResponseHelper {
    static <T> T getDataAs(Response response, Class<T> clazz) {
        GenericData<T> data = response.as(getDataTypeRef(GenericData.class, clazz));
        return data.getData();
    }

    static <T> List<T> getDataArrayAs(Response response, Class<T> clazz) {
        GenericDataList<T> dataList = response.as(getDataArrayTypeRef(GenericDataList.class, clazz));
        return dataList.getData();
    }

    static <T, C, R> TypeRef<R> getDataTypeRef(Class<T> dataClass, Class<C> childClass) {
        return new TypeRef<>() {
            @Override
            public Type getType() {
                return TypeFactory.defaultInstance().constructParametricType(dataClass, childClass);
            }
        };
    }

    static <T, C, R> TypeRef<R> getDataArrayTypeRef(Class<T> dataListClass, Class<C> childClass) {
        return new TypeRef<>() {
            @Override
            public Type getType() {
                return TypeFactory.defaultInstance().constructParametricType(dataListClass, childClass);
            }
        };
    }
}
