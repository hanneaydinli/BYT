//demonstrates how calculations are performed and how the chain of responsibility is used

public class CalculatorExample {
    public static void main(String[] args) {
        CalculationHandler additionHandler = new AdditionHandler();
        CalculationHandler subtractionHandler = new SubtractionHandler();
        CalculationHandler multiplicationHandler = new MultiplicationHandler();
        CalculationHandler divisionHandler = new DivisionHandler();

        additionHandler.setNextHandler(subtractionHandler);
        subtractionHandler.setNextHandler(multiplicationHandler);
        multiplicationHandler.setNextHandler(divisionHandler);

        CalculationRequest requestAdd = new CalculationRequest(10, 5, "add");
        CalculationRequest requestSub = new CalculationRequest(10, 5, "sub");
        CalculationRequest requestMul = new CalculationRequest(10, 5, "mul");
        CalculationRequest requestDiv = new CalculationRequest(10, 5, "div");

        int resultAdd = additionHandler.calculate(requestAdd);
        int resultSub = additionHandler.calculate(requestSub);
        int resultMul = additionHandler.calculate(requestMul);
        int resultDiv = additionHandler.calculate(requestDiv);

        System.out.println("Addition Result: " + resultAdd); // Output: Addition Result: 15
        System.out.println("Subtraction Result: " + resultSub); // Output: Subtraction Result: 5
        System.out.println("Multiplication Result: " + resultMul); // Output: Multiplication Result: 50
        System.out.println("Division Result: " + resultDiv); // Output: Division Result: 2
    }
}
