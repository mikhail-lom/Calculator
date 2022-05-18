import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculatorDemo {
    static Double firstValue;
    static Double secondValue;
    static Integer operation;


    public static void main(String[] args) {
        enterValues();
        Calculator calc = new Calculator(firstValue,secondValue,operation);
        if (calc.result != null){
            System.out.println("Result is: " + calc.result);
        }

    }

    static void enterValues(){
        System.out.println("Enter first value:");

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            firstValue = Double.parseDouble(reader.readLine());

            System.out.println("Enter second value:");

            reader = new BufferedReader(new InputStreamReader(System.in));
            secondValue = Double.parseDouble(reader.readLine());

            System.out.println("Enter operation:");

            reader = new BufferedReader(new InputStreamReader(System.in));
            Integer buffer = reader.read();
            switch (buffer) {
                case 43 -> operation = buffer;//"+"
                case 45 -> operation = buffer;//"-"
                case 42 -> operation = buffer;//"*"
                case 47 -> operation = buffer;//"/"
                default -> System.out.println("Incorrect operation");
            }
        } catch (NumberFormatException e){
            System.out.println("Incorrect value");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }






}
