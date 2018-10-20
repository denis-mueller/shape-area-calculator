package com.denismueller.shapes;

/**
 * The Triangle class has attributes of a triangle saved in a HashMap.
 * It has the attributes basewidth and height.
 * The attributes can be updated by using the {@link Shape#area() area()} method.
 */
public class Triangle extends Shape {
    public Triangle() {
        attributes.put("baseWidth", null);
        attributes.put("height", null);
    }

    /**
     * Calculates the area of a triangle.
     *
     * @return area of the triangle
     */
    public double area() {
        double baseWidth = attributes.get("baseWidth");
        double height = attributes.get("height");

        return baseWidth * height / 2;
    }
}
