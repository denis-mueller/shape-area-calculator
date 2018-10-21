package ch.denismueller.shapeareacalculator;

import ch.denismueller.shapeareacalculator.shapes.Shape;
import ch.denismueller.shapeareacalculator.wizards.ShapeAttributesDefinitionWizard;
import ch.denismueller.shapeareacalculator.wizards.ShapeSelectionWizard;

import java.util.Scanner;

class ShapeAreaCalculatorStarter {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final ShapeSelectionWizard shapeSelectionWizard = new ShapeSelectionWizard(scanner);

        Shape shape;

        System.out.println("Welcome to the Shape Area Calculator.");

        shape = shapeSelectionWizard.run();

        final ShapeAttributesDefinitionWizard shapeAttributesDefinitionWizard = new ShapeAttributesDefinitionWizard(scanner, shape);

        shapeAttributesDefinitionWizard.run();

        System.out.println("The shape has an area of " + shape.area());
    }
}
