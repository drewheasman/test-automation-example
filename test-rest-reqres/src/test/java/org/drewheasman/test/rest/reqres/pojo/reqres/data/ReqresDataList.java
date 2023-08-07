package org.drewheasman.test.rest.reqres.pojo.reqres.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.drewheasman.test.rest.common.pojo.api.GenericDataList;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class ReqresDataList<T> extends GenericDataList<T> {
    private List<T> data;
    private Integer page;
    @JsonProperty("per_page")
    private Integer perPage;
    private Integer total;
    @JsonProperty("total_pages")
    private Integer totalPages;
    private Support support;
}
