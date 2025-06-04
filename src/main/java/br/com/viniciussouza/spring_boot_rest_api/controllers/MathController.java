package br.com.viniciussouza.spring_boot_rest_api.controllers;

import br.com.viniciussouza.spring_boot_rest_api.exception.UnsupportedMathOperationException;
import br.com.viniciussouza.spring_boot_rest_api.utils.MathUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.viniciussouza.spring_boot_rest_api.converters.NumberConverter.convertToDouble;
import static br.com.viniciussouza.spring_boot_rest_api.validators.NumberValidator.isNumeric;


@RestController
@RequestMapping("/math")
public class MathController {

    @GetMapping("/sum/{firstNumber}/{secondNumber}")
    public Double sum(@PathVariable("firstNumber") String firstNumber, @PathVariable("secondNumber") String secondNumber) {

        if (!isNumeric(firstNumber) || !isNumeric(secondNumber)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return MathUtils.sum((convertToDouble(firstNumber)),convertToDouble(secondNumber));
    }

    @GetMapping("/subtraction/{firstNumber}/{secondNumber}")
    public Double subtract(@PathVariable("firstNumber") String firstNumber, @PathVariable("secondNumber") String secondNumber) {

        if (!isNumeric(firstNumber) || !isNumeric(secondNumber)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return MathUtils.subtract(convertToDouble(firstNumber),convertToDouble(secondNumber));
    }

    @GetMapping("/multiplication/{firstNumber}/{secondNumber}")
    public Double multiply(@PathVariable("firstNumber") String firstNumber, @PathVariable("secondNumber") String secondNumber) {

        if (!isNumeric(firstNumber) || !isNumeric(secondNumber)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return MathUtils.multiply(convertToDouble(firstNumber),convertToDouble(secondNumber));
    }

    @GetMapping("/division/{firstNumber}/{secondNumber}")
    public Double divide(@PathVariable("firstNumber") String firstNumber, @PathVariable("secondNumber") String secondNumber) {

        if (!isNumeric(firstNumber) || !isNumeric(secondNumber)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        if (convertToDouble(secondNumber) == 0) {
            throw new UnsupportedMathOperationException("Division by zero is not allowed!");
        }

        return MathUtils.divide(convertToDouble(firstNumber),convertToDouble(secondNumber));
    }

    @GetMapping("/square-root/{number}")
    public Double squareRoot(@PathVariable("number") String number) {

        if (!isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        Double num = convertToDouble(number);
        if (num < 0) {
            throw new UnsupportedMathOperationException("Square root of negative numbers is not allowed!");
        }

        return MathUtils.squareRoot(num);
    }

    @GetMapping("/mean/{firstNumber}/{secondNumber}")
    public Double mean(@PathVariable("firstNumber") String firstNumber, @PathVariable("secondNumber") String secondNumber) {

        if (!isNumeric(firstNumber) || !isNumeric(secondNumber)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return MathUtils.mean(convertToDouble(firstNumber), convertToDouble(secondNumber));
    }

}
