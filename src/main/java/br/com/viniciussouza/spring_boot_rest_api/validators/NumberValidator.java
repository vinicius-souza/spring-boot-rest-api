package br.com.viniciussouza.spring_boot_rest_api.validators;

public class NumberValidator {

    public static Boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) return false;

        return strNumber
                .replaceAll(",", ".")
                .matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
