package ch.denismueller.shapeareacalculator.wizards;

import ch.denismueller.shapeareacalculator.shapes.Triangle;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShapeAttributesDefinitionWizardTest {
    private ShapeAttributesDefinitionWizard wizard;

    // This test sets the value of the scanner beforehand, while the real application will prompt the user to input a value.
    @Test
    void DefineShapeAttributesWithValidInput() {
        double baseWidth = 12;
        double height = 5.5;
        Scanner scanner = new Scanner(baseWidth + "/" + height).useDelimiter("/");
        Triangle triangle = new Triangle();
        wizard = new ShapeAttributesDefinitionWizard(scanner, triangle);

        wizard.run();

        assertEquals(triangle.area(), height * baseWidth / 2);
    }

    // This test sets the value of the scanner beforehand, while the real application will prompt the user to input a value.
    // After entering an invalid value the method will ask for another value. So therefor the valid value will be used by the method.
    @Test
    void DefineShapeAttributesWithInvalidInput() {
        String invalidBaseWidth = "twelve";
        double baseWidth = 12;
        double invalidHeight = 0;
        double height = 5.5;
        Scanner scanner = new Scanner(invalidBaseWidth + "/" + baseWidth + "/" + invalidHeight + "/" + height).useDelimiter("/");
        Triangle triangle = new Triangle();
        wizard = new ShapeAttributesDefinitionWizard(scanner, triangle);

        wizard.run();

        assertEquals(triangle.area(), height * baseWidth / 2);
    }

}
