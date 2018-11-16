package ch.denismueller.shapeareacalculator;

import ch.denismueller.shapeareacalculator.CalculationMethods;
import ch.denismueller.shapeareacalculator.ShapeAttribute;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class Wizard {
    Scanner scanner;
    Map<String, ShapeAttribute> attributes;
    Function<Map<String, ShapeAttribute>, Integer> calculationMethod;

    public Wizard(Scanner scanner) {
        this.scanner = scanner;
        attributes = new HashMap<>();
    }

    public void run(){
        int area = 0;

        System.out.println("Welcome, please enter the number of the shape you would like to calculate");
        System.out.println("1 - Circle (using base width and height)");
        int input = scanner.nextInt();
        switch (input){
            case 1: area = baseWidthCircle();
            break;
        }

        System.out.println("The area is " + Integer.toString(area) );
    }

    private int baseWidthCircle(){
        calculationMethod = CalculationMethods::baseWidthCircle;

        ShapeAttribute baseWidth = new ShapeAttribute(1, 9999, "Please enter a number between 1 and 9999");
        ShapeAttribute height = new ShapeAttribute(1, 9999, "Please enter a number between 1 and 9999");

        attributes.put("baseWidth", baseWidth);
        attributes.put("height", height);

        setValues(attributes);

        return calculateArea();
    }

    private void setValues(Map<String, ShapeAttribute> attributes){
        attributes.forEach((attributeName, attribute) -> {
            System.out.println("Please enter the " + attributeName);
            attribute.setValue(scanner.nextInt());

            while (!attribute.isValid()){
                System.out.println(attribute.getErrorMessage());
                attribute.setValue(scanner.nextInt());
            }
        });
    }

    private int calculateArea(){
        return calculationMethod.apply(attributes);
    }
}
