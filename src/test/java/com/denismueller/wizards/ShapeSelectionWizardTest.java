package com.denismueller.wizards;

import com.denismueller.shapes.Triangle;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ShapeSelectionWizardTest {
    private ShapeSelectionWizard wizard;

    @Test
    void selectShapeWithValidInput() {
        Scanner scanner = new Scanner("triangle");
        wizard = new ShapeSelectionWizard(scanner);
        assertEquals(wizard.run().getClass(), Triangle.class);
    }
@Test
    void selectShapeWithValidCaseInsensitiveInput() {
        Scanner scanner = new Scanner("triANGle");
        wizard = new ShapeSelectionWizard(scanner);
        assertEquals(wizard.run().getClass(), Triangle.class);
    }
@Test
    void selectShapeWithInvalidInput() {
        //Since torus is invalid the test will scan for another input, since the second provided input is triangle, it is valid.
        // TODO: is there a better way to test this?
        Scanner scanner = new Scanner("torus/triangle").useDelimiter("/");
        wizard = new ShapeSelectionWizard(scanner);
        assertEquals(wizard.run().getClass(), Triangle.class);
    }
@Test
    void selectShapeWithEmptyInput() {
    Scanner scanner = new Scanner(" /triangle").useDelimiter("/");
        wizard = new ShapeSelectionWizard(scanner);
        assertEquals(wizard.run().getClass(), Triangle.class);
    }

}
