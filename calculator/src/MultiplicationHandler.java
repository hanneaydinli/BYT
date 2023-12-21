//a handler that performs multiplication

public class MultiplicationHandler implements CalculationHandler {
    private CalculationHandler successor;

    @Override
    public void setNextHandler(CalculationHandler handler) {
        this.successor = handler;
    }

    @Override
    public int calculate(CalculationRequest request) {
        if (request.getOperation().equals("mul")) {
            return request.getNum1() * request.getNum2();
        } else if (successor != null) {
            return successor.calculate(request);
        } else {
            throw new IllegalArgumentException("Operation not supported");
        }
    }
}
