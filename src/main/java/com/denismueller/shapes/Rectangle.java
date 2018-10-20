package com.denismueller.shapes;

/**
 * The Rectangle class has attributes of a rectangle saved in a HashMap.
 * It has the attributes width and height.
 * The attributes can be updated by using the {@link Shape#area() area()} method.
 */
public class Rectangle extends Shape {
    public Rectangle() {
        attributes.put("width", null);
        attributes.put("height", null);
    }

    /**
     * Calculates the area of the rectangle.
     *
     * @return area of the rectangle
     */
    public double area() {
        double width = attributes.get("width");
        double height = attributes.get("height");

        return width * height;
    }
}
