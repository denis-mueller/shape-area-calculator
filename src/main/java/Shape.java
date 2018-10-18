import java.util.HashMap;
import java.util.Map;

abstract class Shape {
    final Map<String, Double> attributes = new HashMap<>();

    abstract double area();

    /**
     * Checks whether a shape has an attribute and if it does it sets the value for the attribute.
     *
     * @param attributeName  name of the attribute as string
     * @param attributeValue value of the attribute as double
     */
    void setAttribute(String attributeName, double attributeValue) {
        if (attributes.containsKey(attributeName)) attributes.put(attributeName, attributeValue);
    }
}
