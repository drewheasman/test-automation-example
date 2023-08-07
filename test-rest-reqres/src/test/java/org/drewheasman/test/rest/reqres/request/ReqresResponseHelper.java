package org.drewheasman.test.rest.reqres.request;

import io.restassured.response.Response;
import org.drewheasman.test.rest.common.request.ResponseHelper;
import org.drewheasman.test.rest.reqres.pojo.reqres.data.ReqresData;
import org.drewheasman.test.rest.reqres.pojo.reqres.data.ReqresDataList;

import java.util.List;

public class ReqresResponseHelper implements ResponseHelper {
    public static <T> T getDataAs(Response response, Class<T> clazz) {
        ReqresData<T> data = response.as(ResponseHelper.getDataTypeRef(ReqresData.class, clazz));
        return data.getData();
    }

    public static <T> List<T> getDataArrayAs(Response response, Class<T> clazz) {
        ReqresDataList<T> dataList = response.as(ResponseHelper.getDataArrayTypeRef(ReqresDataList.class, clazz));
        return dataList.getData();
    }
}
