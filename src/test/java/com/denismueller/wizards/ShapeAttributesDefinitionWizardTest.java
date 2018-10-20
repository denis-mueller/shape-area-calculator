package com.denismueller.wizards;

import com.denismueller.shapes.Triangle;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ShapeAttributesDefinitionWizardTest {
    private ShapeAttributesDefinitionWizard wizard;

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
