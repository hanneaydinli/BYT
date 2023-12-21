//a handler that performs division

public class DivisionHandler implements CalculationHandler {
    private CalculationHandler successor;

    @Override
    public void setNextHandler(CalculationHandler handler) {
        this.successor = handler;
    }

    @Override
    public int calculate(CalculationRequest request) {
        if (request.getOperation().equals("div")) {
            if (request.getNum2() != 0) {
                return request.getNum1() / request.getNum2();
            } else {
                throw new ArithmeticException("Division by zero");
            }
        } else if (successor != null) {
            return successor.calculate(request);
        } else {
            throw new IllegalArgumentException("Operation not supported");
        }
    }
}
