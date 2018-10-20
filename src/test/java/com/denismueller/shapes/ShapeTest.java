package com.denismueller.shapes;

import com.denismueller.shapes.Shape;
import com.denismueller.shapes.Triangle;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ShapeTest {
    private final Shape triangle = new Triangle();

    @Test
    void setValidAttribute() {
        assertDoesNotThrow(() -> triangle.setAttribute("height", 5));
    }

    @Test
    void setInvalidAttribute() {
        assertThrows(InvalidParameterException.class, () -> triangle.setAttribute("height", 0));
        assertThrows(InvalidParameterException.class, () -> triangle.setAttribute("height", -10));
    }
}
