import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {
    Shape circle = new Circle();
    double circleRadius = 5;

    @Test
    void areaWithAttributes() {
        circle.setAttribute("radius", circleRadius);
        assertEquals(25 * Math.PI, circle.area());
    }
    @Test
    void areaWithoutAttributes() {
        assertThrows(NullPointerException.class, () -> { circle.area(); });
    }

}
