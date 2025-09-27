package ru.balybin;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyCalculatorTest {

    private MyCalculator calculator;

    @Before
    public void setUp() {
        calculator = new MyCalculator();
        calculator.setFirstArgument(6.5);
        calculator.setSecondArgument(24);
    }

    @Test
    public void sum() {
        assertEquals(4, calculator.sum(2, 2), 0.0);
    }

    @Test
    public void subtract() {
        assertEquals(0, calculator.subtract(2, 2), 0.0);
    }

    @Test
    public void multiply() {
        assertEquals(72, calculator.multiply(9, 8), 0.0);
        assertEquals(9.82 * 2.37, calculator.multiply(9.82, 2.37), 0.0);
    }

    @Test
    public void divide() {
        assertEquals(1117, calculator.divide(15638, 14), 0.0);
        assertEquals((double) 15652 /16, calculator.divide(15652, 16), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void divideByZeroThrowsException() {
        calculator.divide(5.0, 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void divideByVerySmallNumberThrowsException() {
        calculator.divide(5.0, 1e-9);
    }

    @Test
    public void divideByAcceptableSmallNumber() {
        double result = calculator.divide(5.0, 1e-7);
        assertEquals(5e7, result, 0.0);
    }

    @Test
    public void printResult() {
        String result = calculator.printResult(52.0);
        assertEquals("52.0", result);
    }

    @Test
    public void displayError() {
        calculator.displayError("Test error");
        calculator.displayError("Division by zero");
    }

    @Test
    public void setFirstArgument() {
        calculator.setFirstArgument(15.5);
        assertEquals("15.5", calculator.getFirstArgumentAsString());

        calculator.setFirstArgument(-3.14);
        assertEquals("-3.14", calculator.getFirstArgumentAsString());
    }

    @Test
    public void setSecondArgument() {
        calculator.setSecondArgument(20.1);
        assertEquals("20.1", calculator.getSecondArgumentAsString());

        calculator.setSecondArgument(0);
        assertEquals("0.0", calculator.getSecondArgumentAsString());
    }

    @Test
    public void getFirstArgumentAsString() {
        assertEquals("6.5", calculator.getFirstArgumentAsString());
    }

    @Test
    public void getSecondArgumentAsString() {
        assertEquals("24.0", calculator.getSecondArgumentAsString());
    }

    @Test
    public void onPlusClicked() {
        System.out.println("Plus clicked");
    }

    @Test
    public void onMinusClicked() {
        System.out.println("Minus clicked");
    }

    @Test
    public void onDivideClicked() {
        System.out.println("Divide clicked");
    }

    @Test
    public void onMultiplyClicked() {
        System.out.println("Multiply clicked");
    }
}