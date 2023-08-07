package org.drewheasman.rest.reqres.pojo.reqres.resource;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.drewheasman.pojo.api.IsoDateTimeDeserializer;

import java.time.ZonedDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class UnknownResourceUpdatedResponse extends UnknownResource {
    @JsonDeserialize(using = IsoDateTimeDeserializer.class)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private ZonedDateTime updatedAt;
}
