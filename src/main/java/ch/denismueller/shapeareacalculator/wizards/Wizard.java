package ch.denismueller.shapeareacalculator.wizards;

import java.util.Scanner;

abstract class Wizard {
    final Scanner scanner;

    Wizard(Scanner scanner) {
        this.scanner = scanner;
    }
}
