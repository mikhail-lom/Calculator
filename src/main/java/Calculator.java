import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    //class parameters
    public Double result = null;
    public Integer operation = null;

    private Logger logger;
    //class constructors

    Calculator() {

    }

    Calculator(Double fO, Double sO, Integer op, Logger log) {
        logger = log;
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
        try {
            logger.log(result.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    Double subtract(Double firstOperand, Double secondOperand) {
        result = firstOperand - secondOperand;
        try {
            logger.log(result.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }


    Double multiplicate(Double firstOperand, Double secondOperand) {
        result = firstOperand * secondOperand;
        try {
            logger.log(result.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    Double divide(Double firstOperand, Double secondOperand) {
        if (secondOperand == 0) {
            try {
                logger.log("Error: second operand = " + secondOperand.toString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            throw new ArithmeticException("Zero division!!!");
        }
        result = firstOperand / secondOperand;
        try {
            logger.log(result.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
