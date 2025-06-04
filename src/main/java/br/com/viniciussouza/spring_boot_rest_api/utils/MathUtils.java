package br.com.viniciussouza.spring_boot_rest_api.utils;

public class MathUtils {
    public static Double sum(Double numberOne, Double numberTwo) {
        return numberOne + numberTwo;
    }

    public static Double subtract(Double numberOne, Double numberTwo) {
        return numberOne - numberTwo;
    }

    public static Double multiply(Double numberOne, Double numberTwo) {
        return numberOne * numberTwo;
    }

    public static Double divide(Double numberOne, Double numberTwo) {
        if (numberTwo == 0) throw new IllegalArgumentException("Division by zero is not allowed");
        return numberOne / numberTwo;
    }

    public static Double squareRoot(Double number) {
        if (number < 0) throw new IllegalArgumentException("Cannot calculate square root of a negative number");
        return Math.sqrt(number);
    }

    public static Double mean(Double... numbers) {
        if (numbers == null || numbers.length == 0) throw new IllegalArgumentException("No numbers provided");
        Double sum = 0.0;
        for (Double number : numbers) {
            sum += number;
        }
        return sum / numbers.length;
    }
}
