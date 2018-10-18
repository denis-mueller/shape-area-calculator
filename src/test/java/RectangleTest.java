import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

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
