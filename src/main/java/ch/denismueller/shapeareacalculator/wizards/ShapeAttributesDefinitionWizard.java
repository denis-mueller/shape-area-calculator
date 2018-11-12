package ch.denismueller.shapeareacalculator.wizards;

import ch.denismueller.shapeareacalculator.shapes.Shape;

import java.util.Scanner;

/**
 * A wizard that guides the user through defining the attributes for a shape.
 */
public class ShapeAttributesDefinitionWizard extends Wizard {
    private final Shape shape;

    public ShapeAttributesDefinitionWizard(Scanner scanner, Shape shape) {
        super(scanner);
        this.shape = shape;
    }

    /**
     * Prompts the user to input the necessary attributes to calculate the area of a Shape.
     */
    public void run() {
        for (String attributeName : shape.attributeNames()) {
            System.out.println("Enter the " + attributeName + ":");

            double input = scanInput();

            shape.setAttribute(attributeName, input);
        }
    }

    private double scanInput() {
        double inputValue;

        String input = scanner.next();

        if (isValidInput(input)) {
            inputValue = Double.parseDouble(input);
        } else {
            System.out.println("Please enter a number greater than zero.");
            inputValue = scanInput();
        }

        return inputValue;

    }

    private boolean isValidInput(String input) {
        if (!isParsableToDouble(input)) return false;

        double inputValue = Double.parseDouble(input);

        return hasValidRange(inputValue);
    }

    private boolean isParsableToDouble(String input) {
        try {
            Double.parseDouble(input);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    private boolean hasValidRange(double value) {
        return (value > 0);
    }
}
