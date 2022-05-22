import file_controller.TypeOS;
import math_operations.CalculatorOperation;
import math_operations.SumOperation;

public class Calculator {
    //class parameters
    public Double result = null;
    public Integer operation = null;
    public Double firstOperand;
    public Double secondOperand;

    private Logger logger;
    private String filePath;
    //class constructors



    Calculator( Logger log, String filePath) {
        logger = log;
        this.filePath = filePath;
    }

    void init(Double fO, Double sO, Integer operation){
        switch (operation) {
            case 43 -> add(fO, sO);
            case 45 -> subtract(fO, sO);
            case 42 -> multiplicate(fO, sO);
            case 47 -> divide(fO, sO);
            default -> System.out.println("Incompatible operation");
        }

        CalculatorOperation operationI = new SumOperation();
    }

    //class methods
    Double add(Double firstOperand, Double secondOperand) {
        result = firstOperand + secondOperand;
        String filePath = logger.getFilePath(this.filePath, TypeOS.LINUX);
        logger.log(result.toString());
        return result;
    }

    Double subtract(Double firstOperand, Double secondOperand) {
        result = firstOperand - secondOperand;
        logger.log(result.toString());
        return result;
    }


    Double multiplicate(Double firstOperand, Double secondOperand) {
        result = firstOperand * secondOperand;
        logger.log(result.toString());
        return result;
    }

    Double divide(Double firstOperand, Double secondOperand) {
        if (secondOperand == 0) {
            logger.log("Error: second operand = " + secondOperand.toString());
            throw new ArithmeticException("Zero division!!!");
        }
        result = firstOperand / secondOperand;
        logger.log(result.toString());
        return result;
    }


}
