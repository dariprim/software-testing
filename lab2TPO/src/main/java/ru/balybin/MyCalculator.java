package ru.balybin;

public class MyCalculator implements Calculator,CalculatorView,CalculatorPresenter {
    private double firstArgument;
    private double secondArgument;


    @Override
    public double sum(double a, double b) {
        return a + b;
    }


    @Override
    public double subtract(double a, double b) {
        return a - b;
    }

    @Override
    public double multiply(double a, double b) {
        return a * b;
    }

    @Override
    public double divide(double a, double b) {
        if (Math.abs(b) < 10e-8) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }

    @Override
    public String printResult(double result) {
        String resultString = String.valueOf(result);
        System.out.println(resultString);
        return resultString;
    }

    @Override
    public void displayError(String message) {
        System.err.println(message);
    }

    public double setFirstArgument(double firstArgument) {
        this.firstArgument = firstArgument;
        return firstArgument;
    }

    public double setSecondArgument(double secondArgument) {
        this.secondArgument = secondArgument;
        return secondArgument;
    }

    @Override
    public String getFirstArgumentAsString() {
        return String.valueOf(firstArgument);
    }

    @Override
    public String getSecondArgumentAsString() {
        return String.valueOf(secondArgument);
    }

    @Override
    public void onPlusClicked() {
        System.out.println("Plus clicked");
    }

    @Override
    public void onMinusClicked() {
        System.out.println("Minus clicked");
    }

    @Override
    public void onDivideClicked() {
        System.out.println("Divide clicked");
    }

    @Override
    public void onMultiplyClicked() {
        System.out.println("Multiply clicked");
    }
}
