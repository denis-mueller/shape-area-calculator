package com.denismueller.shapes;

import com.denismueller.shapes.Rectangle;
import com.denismueller.shapes.Shape;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
    Shape rectangle = new Rectangle();
    double rectangleWidth = 10;
    double rectangleHeight = 5;

    @Test
    void areaWithAttributes() {
        rectangle.setAttribute("width", rectangleWidth);
        rectangle.setAttribute("height", rectangleHeight);
        assertEquals(50, rectangle.area());
    }
    @Test
    void areaWithoutAttributes() {
        assertThrows(NullPointerException.class, () -> { rectangle.area(); });
    }

}
