package calculator;

public class SubtractOperator implements Calculatable {
    @Override
    public double operate(double num1, double num2) {
        return num1 - num2; // 뺄셈
    }
}
