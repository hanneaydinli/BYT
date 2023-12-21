//a handler that performs addition

public class AdditionHandler implements CalculationHandler {
    private CalculationHandler successor;

    @Override
    public void setNextHandler(CalculationHandler handler) {
        this.successor = handler;
    }

    @Override
    public int calculate(CalculationRequest request) {
        if (request.getOperation().equals("add")) {
            return request.getNum1() + request.getNum2();
        } else if (successor != null) {
            return successor.calculate(request);
        } else {
            throw new IllegalArgumentException("Operation not supported");
        }
    }
}
