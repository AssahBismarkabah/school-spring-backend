package com.ssegning.com.school.converter;

import jakarta.persistence.AttributeConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@RequiredArgsConstructor
public abstract class CollectionConverter<T extends Serializable> implements AttributeConverter<Collection<T>, String> {

    private final AttributeConverter<T, String> delegate;

    private static final String SEPARATOR = ", ";

    @Override
    public String convertToDatabaseColumn(Collection<T> attribute) {
        if (null == attribute) return null;
        var collect = attribute.stream().map(delegate::convertToDatabaseColumn).collect(Collectors.toUnmodifiableSet());
        return StringUtils.join(collect, SEPARATOR);
    }

    @Override
    public Collection<T> convertToEntityAttribute(String dbData) {
        if (StringUtils.isBlank(dbData))
            return Collections.emptyList();

        try (Stream<String> stream = Arrays.stream(dbData.split(SEPARATOR))) {
            return stream.map(delegate::convertToEntityAttribute).collect(Collectors.toList());
        }
    }

}
