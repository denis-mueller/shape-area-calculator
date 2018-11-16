package ch.denismueller.shapeareacalculator;

import java.util.Map;

public class CalculationMethods {
    public static int baseWidthCircle(Map<String, ShapeAttribute> shapeAttributes){
        int baseWidth =  shapeAttributes.get("baseWidth").getValue();
        int height = shapeAttributes.get("height").getValue();

        int area = baseWidth * height / 2;

        return area;
    }
}
