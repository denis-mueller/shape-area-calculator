package com.denismueller;

import com.denismueller.shapes.Rectangle;
import com.denismueller.shapes.Shape;
import com.denismueller.shapes.Triangle;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WizardTest {

    @Test
    void calculateShapeAreaWithValidInput() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        final PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        String expectedOutput = "The rectangle has an area of 50.0";

        Shape rectangle = new Rectangle();

        Wizard.calculateShapeArea(rectangle);

        //TODO: NOT WORKING this isnt working yet, idk why
        simulateUserInput("5"); // when asked for width input
        simulateUserInput("10"); // when asked for height input

        assert(outContent.toString().contains(expectedOutput));
        System.setOut(originalOut);
    }

    @Test
    void calculateShapeAreaWithInvalidInput() {
        //TODO: if the answer is invalid, the method will keep asking for an input until a valid input is provided. how do I test this?
    }

    @Test
    void selectShapeWithValidInput() {
        simulateUserInput("triangle");
        assertEquals(Wizard.selectShape().getClass(), Triangle.class);
    }

    @Test
    void selectShapeWithCaseInsensitiveValidInput() {
        simulateUserInput("TriANGle");
        assertEquals(Wizard.selectShape().getClass(), Triangle.class);
    }

    @Test
    void selectShapeWithEmptyInput() {
        simulateUserInput("");
        //TODO: if the answer is invalid, the method will keep asking for an input until a valid input is provided. how do I test this?
        simulateUserInput("triangle");

        assertEquals(Wizard.selectShape().getClass(), Triangle.class);
    }

    @Test
    void selectShapeWithInvalidInput() {
        simulateUserInput("torus");
        //TODO: if the answer is invalid, the method will keep asking for an input until a valid input is provided. how do I test this?
        simulateUserInput("triangle");

        assertEquals(Wizard.selectShape().getClass(), Triangle.class);
    }

    private void simulateUserInput(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}
