package com.example.library.converter;

import com.example.library.model.TransmissionType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TransmissionTypeToLowerCaseStringConverterTest {

    @Autowired
    TransmissionTypeToLowerCaseStringConverter converter;

    @BeforeEach
    void setup() {
        converter = new TransmissionTypeToLowerCaseStringConverter();
    }

    @Test
    void convertToDatabaseColumn() {
        String transmission = converter.convertToDatabaseColumn(TransmissionType.AUTOMATIC);
        assertEquals("automatic", transmission);
        transmission = converter.convertToDatabaseColumn(TransmissionType.MANUAL);
        assertEquals("manual", transmission);
    }

    @Test
    void convertToDatabaseColumnBadValue() {
        String transmission = converter.convertToDatabaseColumn(null);
        assertNull(transmission);
    }

    @Test
    void convertToEntityAttribute() {
        TransmissionType transmission = converter.convertToEntityAttribute("automatic");
        assertEquals(TransmissionType.AUTOMATIC, transmission);
        transmission = converter.convertToEntityAttribute("manual");
        assertEquals(TransmissionType.MANUAL, transmission);
    }

    @Test
    void convertToEntityAttributeBadValue() {
        TransmissionType transmission = converter.convertToEntityAttribute("standard");
        assertNull(transmission);
        transmission = converter.convertToEntityAttribute(null);
        assertNull(transmission);
    }
}