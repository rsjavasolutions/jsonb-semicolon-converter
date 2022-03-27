package com.rsjavasolutions.jsonb.utils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Converter
public class SemicolonSeparatedStringConverter implements AttributeConverter<Collection<String>, String> {

    public static final String SEPARATOR = ";";
    public static final String[] EMPTY_ARRAY = {};

    @Override
    public String convertToDatabaseColumn(Collection<String> values) {
        return String.join(SEPARATOR, values);
    }

    @Override
    public Collection<String> convertToEntityAttribute(String value) {
        return Stream.of(
                Optional.ofNullable(value).map(s -> s.split(SEPARATOR)).orElse(EMPTY_ARRAY)
        ).collect(Collectors.toSet());
    }
}