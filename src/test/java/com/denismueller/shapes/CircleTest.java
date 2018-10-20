package com.denismueller.shapes;

import com.denismueller.shapes.Circle;
import com.denismueller.shapes.Shape;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {
    private final Shape circle = new Circle();

    @Test
    void areaWithAttributes() {
        double circleRadius = 5;
        circle.setAttribute("radius", circleRadius);
        assertEquals(25 * Math.PI, circle.area());
    }
    @Test
    void areaWithoutAttributes() {
        assertThrows(NullPointerException.class, circle::area);
    }

}
