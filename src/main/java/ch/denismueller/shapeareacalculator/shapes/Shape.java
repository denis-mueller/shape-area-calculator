package ch.denismueller.shapeareacalculator.shapes;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

abstract public class Shape {
    final Map<String, Double> attributes = new HashMap<>();

    abstract public double area();

    /**
     * Checks whether a shape has an attribute and if it does it sets the value for the attribute.
     *
     * @param attributeName  name of the attribute as string
     * @param attributeValue value of the attribute as double
     */
    public void setAttribute(String attributeName, double attributeValue) {
        if (attributeValue <= 0) throw new InvalidParameterException();
        attributes.put(attributeName, attributeValue);
    }

    /**
     * Takes all the attribute names a shape has and returns them.
     *
     * @return a {@link java.util.Set set} with all the attribute names.
     */
    public Set<String> attributeNames() {
        return attributes.keySet();
    }
}
