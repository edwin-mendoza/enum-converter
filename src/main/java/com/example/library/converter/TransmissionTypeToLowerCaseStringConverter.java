package com.example.library.converter;

import com.example.library.model.TransmissionType;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Slf4j
@Converter(autoApply = true)
public class TransmissionTypeToLowerCaseStringConverter implements AttributeConverter<TransmissionType, String> {

    @Override
    public String convertToDatabaseColumn(TransmissionType type) {
        if (type == null) {
            return null;
        }
        return type.toString().toLowerCase();
    }

    @Override
    public TransmissionType convertToEntityAttribute(String type) {
        if (type == null) {
            return null;
        }
        return Stream.of(TransmissionType.values())
                .filter(c -> c.toString().equalsIgnoreCase(type))
                .findFirst()
                .orElse(null);
    }
}