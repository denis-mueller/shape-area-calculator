package ch.denismueller.shapeareacalculator;

import ch.denismueller.shapeareacalculator.ui_texts.UITexts;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class WizardTest {
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void runWithValidInput() {
        Scanner scanner = new Scanner("4/5").useDelimiter("/");
        double result = 25 * Math.PI;
        String output = UITexts.theAreaIs + Double.toString(result);

        Wizard wizard = new Wizard(scanner);
        wizard.run();

        assert(systemOutRule.getLog().contains(output));
    }
    @Test
    public void runWithInvalidShapeSelection() {
        String[] invalidInputs = new String[]{"15", "0", "circle", ""};

        for(String input : invalidInputs){
            Scanner scanner = new Scanner("circle");

            Wizard wizard = new Wizard(scanner);

            try{
                wizard.run();
            }catch (NoSuchElementException e){}

            assert(systemOutRule.getLog().contains(UITexts.invalidShapeSelectionError));
        }
    }

    @Test
    public void runWithInvalidSideLength() {
        String[] invalidInputs = new String[]{"0", "-15", "five", "1000000"};

        for(String input : invalidInputs){
            Scanner scanner = new Scanner("3/" + input).useDelimiter("/");

            Wizard wizard = new Wizard(scanner);

            try{
                wizard.run();
            }catch (NoSuchElementException e){}

            assert(systemOutRule.getLog().contains(UITexts.invalidSideLengthError));
        }
    }
    @Test
    public void runWithInvalidAngle() {
        String[] invalidInputs = new String[]{"0", "180", "-15", "five", "1000000"};

        for(String input : invalidInputs){
            Scanner scanner = new Scanner("3/10/10/" + input).useDelimiter("/");

            Wizard wizard = new Wizard(scanner);

            try{
                wizard.run();
            }catch (NoSuchElementException e){}

            assert(systemOutRule.getLog().contains(UITexts.invalidAngleError));
        }
    }

    @Test
    public void runWithImpossibleShape() {
            Scanner scanner = new Scanner("2/10/2/2").useDelimiter("/");

            Wizard wizard = new Wizard(scanner);

            try{
                wizard.run();
            }catch (NoSuchElementException e){}

            assert(systemOutRule.getLog().contains(UITexts.impossibleAttributesError));
    }
}
