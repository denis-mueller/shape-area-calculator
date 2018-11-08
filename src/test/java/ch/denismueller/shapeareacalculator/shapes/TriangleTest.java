package ch.denismueller.shapeareacalculator.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TriangleTest {
    private final Shape triangle = new Triangle();

    @Test
    void areaWithAttributes() {
        double triangleBaseWidth = 10;
        triangle.setAttribute("baseWidth", triangleBaseWidth);
        double triangleHeight = 5;
        triangle.setAttribute("height", triangleHeight);
        assertEquals(25, triangle.area());
    }

    @Test
    void areaWithoutAttributes() {
        assertThrows(NullPointerException.class, triangle::area);
    }
}
