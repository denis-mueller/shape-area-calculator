import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

abstract class Shape {
    // TODO: I want to make this private so it cannot be accessed from outside, but I want the classes who extend this class to have access.
    // Is this possible?
    final Map<String, Double> attributes = new HashMap<>();

    abstract double area();

    /**
     * Checks whether a shape has an attribute and if it does it sets the value for the attribute.
     *
     * @param attributeName  name of the attribute as string
     * @param attributeValue value of the attribute as double
     */
    void setAttribute(String attributeName, double attributeValue) {
        if (attributeValue <= 0) throw new InvalidParameterException();
        attributes.put(attributeName, attributeValue);
    }
}
