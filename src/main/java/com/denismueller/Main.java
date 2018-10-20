package com.denismueller;

import com.denismueller.shapes.Shape;
import com.denismueller.wizards.ShapeAttributesDefinitionWizard;
import com.denismueller.wizards.ShapeSelectionWizard;

import java.util.Scanner;

class Main {

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
