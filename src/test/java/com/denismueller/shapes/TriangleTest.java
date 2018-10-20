package com.denismueller.shapes;

import com.denismueller.shapes.Shape;
import com.denismueller.shapes.Triangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
     Shape triangle = new Triangle();
     double triangleBaseWidth = 10;
     double triangleHeight = 5;

    @Test
    void areaWithAttributes() {
        triangle.setAttribute("baseWidth", triangleBaseWidth);
        triangle.setAttribute("height", triangleHeight);
        assertEquals(25, triangle.area());
    }
    @Test
    void areaWithoutAttributes() {
        assertThrows(NullPointerException.class, () -> { triangle.area(); });
    }

}
