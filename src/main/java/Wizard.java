import java.util.Scanner;

/**
 * A Wizard that guides the user through the calculation of the area of a shape.
 *
 * @author Denis Müller
 */
class Wizard {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Prompts the user to input the necessary attributes to calculate the area of a Shape.
     * Prints out the area that was calculated by the {@link Shape#area() area()} method.
     *
     * @param shape Shape object whose area will be calculated.
     */
    static void calculateShapeArea(Shape shape) {
        String shapeName = shape.getClass().getSimpleName().toLowerCase();

        scanShapeAttributes(shape);

        System.out.println("The " + shapeName + " has an area of " + shape.area());
    }

    private static void scanShapeAttributes(Shape shape) {
        for (String attributeName : shape.attributes.keySet()) {
            System.out.println("Enter the " + attributeName + ":");
            double input = scanDoubleInput();
            while (input <= 0) { input = reScanDoubleInput(); }
            shape.setAttribute(attributeName, input);
        }
    }

    private static double scanDoubleInput() {
        double input;
        try {
            input = scanner.nextDouble();
        } catch (Exception e) {
            input = reScanDoubleInput();
        }
        return input;
    }

    private static double reScanDoubleInput() {
        System.out.println("Please enter a number that is greater than zero: ");
        return scanner.nextDouble();
    }

    /**
     * Prompts the user to select a valid shape. Asks for user input repeatedly until a valid shape name is provided.
     *
     * @return the selected shape
     */
    static Shape selectShape() {
        Shape shape = null;

        System.out.println("Which shape's area do you want to calculate?");
        System.out.println("Valid shapes are circle, triangle and rectangle.");

        while (shape == null) {
            String input = scanner.next().toLowerCase();

            switch (input) {
                case "circle":
                    shape = new Circle();
                    break;
                case "rectangle":
                    shape = new Rectangle();
                    break;
                case "triangle":
                    shape = new Triangle();
                    break;
                default:
                    System.out.println("Please select a valid shape");
                    break;
            }
        }

        return shape;
    }
}
