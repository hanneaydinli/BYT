//contains methods required for implementing the chain of responsibility

public interface CalculationHandler {
    void setNextHandler(CalculationHandler handler);
    int calculate(CalculationRequest request);
}
