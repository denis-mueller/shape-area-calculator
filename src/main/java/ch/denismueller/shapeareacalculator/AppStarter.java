package ch.denismueller.shapeareacalculator;

import java.util.Scanner;

class AppStarter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Wizard wizard = new Wizard(scanner);

        wizard.run();
    }
}
