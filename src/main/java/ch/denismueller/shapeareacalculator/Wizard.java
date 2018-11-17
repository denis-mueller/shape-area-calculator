package ch.denismueller.shapeareacalculator;

import java.util.List;
import java.util.Scanner;

class Wizard {
    private final Scanner scanner;
    private ShapeCalculation shapeCalculation;


    public Wizard(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        System.out.println("Welcome, please enter the number of the shape you would like to calculate");
        System.out.println("1 - Triangle (using base width and height)");
        System.out.println("2 - Triangle (using side lengths)");
        System.out.println("3 - Triangle (using two side lengths and the angle between them)");
        System.out.println("4 - Circle (using the radius)");
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                shapeCalculation = ShapeCalculations.baseWidthTriangleCalculation();
                break;
            case 2:
                shapeCalculation = ShapeCalculations.sidesTriangleCalculation();
                break;
            case 3:
                shapeCalculation = ShapeCalculations.trigonometryTriangleCalculation();
                break;
            case 4:
                shapeCalculation = ShapeCalculations.radiusCircleCalculation();
                break;
        }

        setValues(shapeCalculation.attributes());

        String area = Double.toString(shapeCalculation.area());
        System.out.println("The area is " + area);
    }

    private void setValues(List<ShapeAttribute> attributes) {
        attributes.forEach((attribute) -> {
            System.out.println("Please enter the " + attribute.getName() + " of the shape.");
            attribute.setValue(scanner.nextInt());

            while (!attribute.isValid()) {
                System.out.println(attribute.getErrorMessage());
                attribute.setValue(scanner.nextInt());
            }
        });
    }
}
