package br.com.viniciussouza.spring_boot_rest_api.converters;

public class NumberConverter {

    public static Double convertToDouble(String strNumber) {
        return Double.parseDouble(strNumber.replaceAll(",", "."));
    }
}
