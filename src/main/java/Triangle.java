/**
 * The Triangle class has attributes of a triangle saved in a HashMap.
 * It has the attributes basewidth and height.
 * The attributes can be updated by using the {@link Shape#area() area()} method.
 */
class Triangle extends Shape {
    Triangle() {
        attributes.put("baseWidth", null);
        attributes.put("height", null);
    }

    /**
     * Calculates the area of a triangle.
     *
     * @return area of the triangle
     */
    double area() {
        double baseWidth = attributes.get("basewidth");
        double height = attributes.get("height");

        return baseWidth * height / 2;
    }
}
