package com.denismueller.shapes;

import com.denismueller.shapes.Rectangle;
import com.denismueller.shapes.Shape;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
    private final Shape rectangle = new Rectangle();

    @Test
    void areaWithAttributes() {
        double rectangleWidth = 10;
        rectangle.setAttribute("width", rectangleWidth);
        double rectangleHeight = 5;
        rectangle.setAttribute("height", rectangleHeight);
        assertEquals(50, rectangle.area());
    }
    @Test
    void areaWithoutAttributes() {
        assertThrows(NullPointerException.class, rectangle::area);
    }

}
