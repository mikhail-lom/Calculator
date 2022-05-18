import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Calculator {
    //class parameters
    public Double result = null;
    public Integer operation = null;
    //class constructors

    Calculator() {

    }

    Calculator(Double fO, Double sO, Integer op) {
        operation = op;
        switch (operation) {
            case 43 -> add(fO, sO);
            case 45 -> subtract(fO, sO);
            case 42 -> multiplicate(fO, sO);
            case 47 -> divide(fO, sO);
            default -> System.out.println("Incompatible operation");
        }
    }

    //class methods
    Double add(Double firstOperand, Double secondOperand) {
        result = firstOperand + secondOperand;
        return result;
    }

    Double subtract(Double firstOperand, Double secondOperand) {
        result = firstOperand - secondOperand;
        return result;
    }


    Double multiplicate(Double firstOperand, Double secondOperand) {
        result = firstOperand * secondOperand;
        return result;
    }

    Double divide(Double firstOperand, Double secondOperand) {
        if (secondOperand == 0) {
            System.out.println("Null division!");
        }
        result = firstOperand / secondOperand;
        return result;
    }
}
