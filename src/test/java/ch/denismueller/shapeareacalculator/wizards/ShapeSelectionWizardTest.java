package ch.denismueller.shapeareacalculator.wizards;

import ch.denismueller.shapeareacalculator.shapes.Triangle;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShapeSelectionWizardTest {
    private ShapeSelectionWizard wizard;

    // This test sets the value of the scanner beforehand, while the real application will prompt the user to input a value.
    @Test
    void selectShapeWithValidInput() {
        Scanner scanner = new Scanner("triangle");
        wizard = new ShapeSelectionWizard(scanner);
        assertEquals(wizard.run().getClass(), Triangle.class);
    }

    // This test sets the value of the scanner beforehand, while the real application will prompt the user to input a value.
    @Test
    void selectShapeWithValidCaseInsensitiveInput() {
        Scanner scanner = new Scanner("triANGle");
        wizard = new ShapeSelectionWizard(scanner);
        assertEquals(wizard.run().getClass(), Triangle.class);
    }

    // This test sets the value of the scanner beforehand, while the real application will prompt the user to input a value.
    @Test
    void selectShapeWithInvalidInput() {
        //Since torus is invalid the test will scan for another input, since the second provided input is triangle, it is valid.
        // TODO: is there a better way to test this?
        Scanner scanner = new Scanner("torus/triangle").useDelimiter("/");
        wizard = new ShapeSelectionWizard(scanner);
        assertEquals(wizard.run().getClass(), Triangle.class);
    }

    // This test sets the value of the scanner beforehand, while the real application will prompt the user to input a value.
    @Test
    void selectShapeWithEmptyInput() {
        Scanner scanner = new Scanner(" /triangle").useDelimiter("/");
        wizard = new ShapeSelectionWizard(scanner);
        assertEquals(wizard.run().getClass(), Triangle.class);
    }

}
