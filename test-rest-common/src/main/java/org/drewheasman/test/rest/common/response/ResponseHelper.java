package org.drewheasman.test.rest.common.response;

import com.fasterxml.jackson.databind.type.TypeFactory;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.drewheasman.test.rest.common.pojo.api.Data;
import org.drewheasman.test.rest.common.pojo.api.DataList;

import java.lang.reflect.Type;
import java.util.List;

public interface ResponseHelper {
    static <T> T getDataAs(Response response, Class<T> clazz) {
        Data<T> data = response.as(getDataTypeRef(Data.class, clazz));
        return data.getData();
    }

    static <T> List<T> getDataArrayAs(Response response, Class<T> clazz) {
        DataList<T> dataList = response.as(getDataArrayTypeRef(DataList.class, clazz));
        return dataList.getData();
    }

    static <Td, Tc, Tr> TypeRef<Tr> getDataTypeRef(Class<Td> dataClass, Class<Tc> childClass) {
        return new TypeRef<>() {
            @Override
            public Type getType() {
                return TypeFactory.defaultInstance().constructParametricType(dataClass, childClass);
            }
        };
    }

    static <Tdl, Tc, Tr> TypeRef<Tr> getDataArrayTypeRef(Class<Tdl> dataListClass, Class<Tc> childClass) {
        return new TypeRef<>() {
            @Override
            public Type getType() {
                return TypeFactory.defaultInstance().constructParametricType(dataListClass, childClass);
            }
        };
    }
}
