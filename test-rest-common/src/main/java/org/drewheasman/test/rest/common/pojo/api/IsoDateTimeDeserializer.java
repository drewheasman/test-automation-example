package org.drewheasman.test.rest.common.pojo.api;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class IsoDateTimeDeserializer extends JsonDeserializer<ZonedDateTime> {
    @Override
    public ZonedDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, DateTimeParseException {
        String dateString = jsonParser.getText();

        ZonedDateTime zonedDateTime = ZonedDateTime.parse(dateString, DateTimeFormatter.ISO_OFFSET_DATE_TIME);

        if (!zonedDateTime.getOffset().equals(ZoneOffset.UTC)) {
            throw new DateTimeParseException("Time must be in UTC (with 'Z' timezone offset)", zonedDateTime.toString(), 0);
        }

        return zonedDateTime;
    }
}
