package ch.denismueller.shapeareacalculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class ShapeCalculation {
    private final List<ShapeAttribute> attributes;
    private Function<Map<String, Double>, Double> calculationMethod;
    public ShapeCalculation() {
        attributes = new ArrayList<>();
    }

    public void setCalculationMethod(Function<Map<String, Double>, Double> calculationMethod) {
        this.calculationMethod = calculationMethod;
    }

    public List<ShapeAttribute> attributes() {
        return attributes;
    }

    public double area() {
        return calculationMethod.apply(attributesAsMap());
    }

    private Map<String, Double> attributesAsMap() {
        Map<String, Double> attributesMap = new HashMap<>();

        for (ShapeAttribute attribute : attributes) {
            attributesMap.put(attribute.getName(), attribute.getValue());
        }

        return attributesMap;
    }
}
