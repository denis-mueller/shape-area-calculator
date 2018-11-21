package ch.denismueller.shapeareacalculator;

import ch.denismueller.shapeareacalculator.ui_texts.UITexts;

import java.util.Map;

// TODO: better class name idea?
class ShapeCalculationDefinitions {
    public static ShapeCalculation baseWidthTriangleCalculation() {
        ShapeCalculation shapeCalculation = new ShapeCalculation();

        ShapeAttribute baseWidthAttribute = new ShapeAttribute(
                UITexts.baseWidth,
                1,
                9999,
                UITexts.invalidSideLengthError
        );

        ShapeAttribute heightAttribute = new ShapeAttribute(
                UITexts.height,
                1,
                9999,
                UITexts.invalidSideLengthError
        );

        shapeCalculation.attributes().add(baseWidthAttribute);
        shapeCalculation.attributes().add(heightAttribute);

        shapeCalculation.setCalculationMethod(
                (Map<String, Double> attributes) -> {
                    double baseWidth = attributes.get(UITexts.baseWidth);
                    double height = attributes.get(UITexts.height);

                    return baseWidth * height / 2;
                }
        );

        return shapeCalculation;
    }

    public static ShapeCalculation sidesTriangleCalculation() {
        ShapeCalculation shapeCalculation = new ShapeCalculation();

        ShapeAttribute side1attribute = new ShapeAttribute(
                UITexts.side1,
                1,
                9999,
                UITexts.invalidSideLengthError
        );

        ShapeAttribute side2attribute = new ShapeAttribute(
                UITexts.side2,
                1,
                9999,
                UITexts.invalidSideLengthError
        );

        ShapeAttribute side3attribute = new ShapeAttribute(
                UITexts.side3,
                1,
                9999,
                UITexts.invalidSideLengthError
        );

        shapeCalculation.attributes().add(side1attribute);
        shapeCalculation.attributes().add(side2attribute);
        shapeCalculation.attributes().add(side3attribute);

        shapeCalculation.setCalculationMethod(
                (Map<String, Double> attributes) -> {
                    double side1 = attributes.get(UITexts.side1);
                    double side2 = attributes.get(UITexts.side2);
                    double side3 = attributes.get(UITexts.side3);

                    double s = (side1 + side2 + side3) / 2; // s = semiperimeter
                    return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
                }
        );

        return shapeCalculation;
    }

    public static ShapeCalculation trigonometryTriangleCalculation() {
        ShapeCalculation shapeCalculation = new ShapeCalculation();

        ShapeAttribute side1attribute = new ShapeAttribute(
                UITexts.side1,
                0,
                9999,
                UITexts.invalidSideLengthError
        );

        ShapeAttribute side2attribute = new ShapeAttribute(
                UITexts.side2,
                0,
                9999,
                UITexts.invalidSideLengthError
        );

        ShapeAttribute angleAttribute = new ShapeAttribute(
                UITexts.angle,
                0,
                180,
                UITexts.invalidAngleError
        );

        shapeCalculation.attributes().add(side1attribute);
        shapeCalculation.attributes().add(side2attribute);
        shapeCalculation.attributes().add(angleAttribute);

        shapeCalculation.setCalculationMethod(
                (Map<String, Double> attributes) -> {
                    double side1 = attributes.get(UITexts.side1);
                    double side2 = attributes.get(UITexts.side2);
                    double angle = attributes.get(UITexts.angle);

                    double radians = angle * Math.PI / 180;

                    return (side1 * side2 / 2) * Math.sin(radians);
                }
        );

        return shapeCalculation;
    }

    public static ShapeCalculation radiusCircleCalculation() {
        ShapeCalculation shapeCalculation = new ShapeCalculation();

        ShapeAttribute radiusAttribute = new ShapeAttribute(
                UITexts.radius,
                0,
                9999,
                UITexts.invalidSideLengthError
        );

        shapeCalculation.attributes().add(radiusAttribute);

        shapeCalculation.setCalculationMethod(
                (Map<String, Double> attributes) -> {
                    double radius = attributes.get(UITexts.radius);

                    return radius * radius * Math.PI;
                }
        );

        return shapeCalculation;
    }
}
