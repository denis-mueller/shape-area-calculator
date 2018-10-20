package com.denismueller.wizards;

import com.denismueller.shapes.Circle;
import com.denismueller.shapes.Rectangle;
import com.denismueller.shapes.Shape;
import com.denismueller.shapes.Triangle;

import java.util.Scanner;

/**
 * A wizard that guides the user through selecting a shape.
 */
public class ShapeSelectionWizard extends Wizard {
    public ShapeSelectionWizard(Scanner scanner) {
        super(scanner);
    }

    /**
     * Prompts the user to select a valid shape. Asks for user input repeatedly until a valid shape name is provided.
     *
     * @return the selected shape
     */
    public Shape run() {
        Shape shape;
        String input;

        System.out.println("Which shape's area do you want to calculate?");
        System.out.println("Valid shapes are circle, triangle and rectangle.");

        input = scanInput();

        shape = stringToShape(input);

        return shape;
    }

    private String scanInput() {
        String input = scanner.next();

        if (isValidShapeName(input)) {
            return input;
        } else {
            System.out.println("Please enter a valid shape name.");
            return scanInput();
        }
    }

    private Shape stringToShape(String shapeName) {
        Shape shape = null;
        shapeName = shapeName.toLowerCase();

        switch (shapeName) {
            case "circle":
                shape = new Circle();
                break;
            case "rectangle":
                shape = new Rectangle();
                break;
            case "triangle":
                shape = new Triangle();
                break;
        }

        return shape;
    }

    private boolean isValidShapeName(String shapeName) {
        return stringToShape(shapeName) != null;
    }
}
