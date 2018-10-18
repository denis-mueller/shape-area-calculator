import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
     Shape triangle = new Triangle();
     double triangleBaseWidth = 10;
     double triangleHeight = 5;

    @Test
    // TODO: test attribute validity in Shape class test ( > 0 )
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
