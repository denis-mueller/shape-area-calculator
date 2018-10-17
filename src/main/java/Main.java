import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Calculate square area");
//        System.out.println("Enter the length of a side:");
//        double side = scanner.nextDouble();
//
//        Shape square = new Square(side);
//
//        System.out.println("The square has an area of " + square.area());

        System.out.println("Calculate circle area");
        System.out.println("Enter the radius of the circle:");
        double radius = scanner.nextDouble();

        Shape circle = new Circle(radius);
        System.out.println("The circle has an area of " + circle.area());
    }
}
