package com.alexandreesl.handson.converters;

import com.alexandreesl.handson.dto.AccessLogDTO;
import org.apache.camel.Converter;
import org.apache.camel.TypeConverters;

import java.util.StringTokenizer;

/**
 * Created by alexandrelourenco on 30/06/17.
 */

public class StringToAccessLogDTOConverter implements TypeConverters {

    @Converter
    public AccessLogDTO convert(String row) {

        AccessLogDTO dto = new AccessLogDTO();

        StringTokenizer tokens = new StringTokenizer(row);

        dto.setIp(tokens.nextToken());
        dto.setUrl(tokens.nextToken());
        dto.setHttpMethod(tokens.nextToken());
        dto.setDuration(Long.parseLong(tokens.nextToken()));

        return dto;

    }

}
