package math_operations;

public class SumOperation implements CalculatorOperation {
    Integer operation;

    @Override
    public void setOperation(Integer operation) {
        this.operation = operation;
    }

    @Override
    public Integer getOperation() {
        return operation;
    }
}
