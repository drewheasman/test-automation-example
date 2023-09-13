package org.drewheasman.test.rest.common.pojo.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.junit.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class IsoDateTimeDeserializerTest {
    @Test
    public void deserializeValidZonedDateTime() throws JsonProcessingException {
        String dateString = "2023-08-07T12:34:56Z";

        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(ZonedDateTime.class, new IsoDateTimeDeserializer());
        objectMapper.registerModule(module);

        ZonedDateTime deserializedData = objectMapper.readValue("\"" + dateString + "\"", ZonedDateTime.class);

        assertEquals(ZoneId.of("Z"), deserializedData.getZone());
        assertEquals(dateString, deserializedData.toString());
    }

    @Test
    public void deserializeInvalidZonedDateTime() {
        String dateString = "2023-08-07T12:34:56+01:00";

        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(ZonedDateTime.class, new IsoDateTimeDeserializer());
        objectMapper.registerModule(module);

        assertThrows(DateTimeParseException.class, () -> objectMapper.readValue("\"" + dateString + "\"", ZonedDateTime.class));
    }
}
