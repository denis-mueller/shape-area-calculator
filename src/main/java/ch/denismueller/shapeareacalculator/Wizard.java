package ch.denismueller.shapeareacalculator;

import ch.denismueller.shapeareacalculator.ui_texts.UITexts;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class Wizard {
    private final Scanner scanner;
    private ShapeCalculation shapeCalculation;

    public Wizard(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        displayInstructions();

        chooseShapeCalculation();

        setValues(shapeCalculation.attributes());

        ensureShapeValidity();

        displayArea();
    }

    private void ensureShapeValidity() {
        while(!shapeCalculation.attributesValid()){
            System.out.println(UITexts.impossibleAttributesError);
            setValues(shapeCalculation.attributes());
        }
    }

    private void displayArea() {
        String area = Double.toString(shapeCalculation.area());
        System.out.println(UITexts.theAreaIs + area);
    }

    private void chooseShapeCalculation() {
        while (shapeCalculation == null) {
            int input = safeScanInt(UITexts.invalidShapeSelectionError);
            switch (input) {
                case 1:
                    shapeCalculation = ShapeCalculationDefinitions.baseWidthTriangleCalculation();
                    break;
                case 2:
                    shapeCalculation = ShapeCalculationDefinitions.sidesTriangleCalculation();
                    break;
                case 3:
                    shapeCalculation = ShapeCalculationDefinitions.trigonometryTriangleCalculation();
                    break;
                case 4:
                    shapeCalculation = ShapeCalculationDefinitions.radiusCircleCalculation();
                    break;
                default:
                    System.out.println(UITexts.invalidShapeSelectionError);
                    break;
            }
        }
    }

    private void displayInstructions() {
        System.out.println(UITexts.welcomeMessage);

        System.out.println(UITexts.baseWidthTriangle);
        System.out.println(UITexts.sidesTriangle);
        System.out.println(UITexts.trigonometryTriangle);
        System.out.println(UITexts.radiusCircle);
    }

    private void setValues(List<ShapeAttribute> attributes) {
        attributes.forEach((attribute) -> {
            System.out.println(UITexts.pleaseEnterThe + attribute.getName());
            attribute.setValue(safeScanDouble(attribute.getErrorMessage()));

            while (!attribute.isValid()) {
                System.out.println(attribute.getErrorMessage());
                attribute.setValue(safeScanDouble(attribute.getErrorMessage()));
            }
        });
    }

    private double safeScanDouble(String errorMessage){
        String rawInput;
        double input;

        rawInput = scanner.next();

        try{
            input = Double.parseDouble(rawInput);
        } catch(Exception e){
            System.out.println(errorMessage);
            input = safeScanDouble(errorMessage);
        }

        return input;
    }

    private int safeScanInt(String errorMessage){
        String rawInput;
        int input;

        rawInput = scanner.next();

        try{
            input = Integer.parseInt(rawInput);
        } catch(Exception e){
            System.out.println(errorMessage);
            input = safeScanInt(errorMessage);
        }

        return input;
    }

}
