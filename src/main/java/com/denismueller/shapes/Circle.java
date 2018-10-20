package com.denismueller.shapes;

/**
 * The Circle class has attributes of a circle saved in a HashMap.
 * It has the attribute radius.
 * The attribute can be updated by using the {@link Shape#area() area()} method.
 */
public class Circle extends Shape {
    public Circle() {
        attributes.put("radius", null);
    }

    /**
     * Calculates the area of a circle.
     *
     * @return area of the circle
     */
    public double area() {
        double radius = attributes.get("radius");

        return radius * radius * Math.PI;
    }
}
