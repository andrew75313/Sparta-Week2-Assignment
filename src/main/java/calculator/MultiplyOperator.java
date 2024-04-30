package calculator;

public class MultiplyOperator implements Calculatable {
    @Override
    public double operate(int num1, int num2) {
        return num1 * num2; // 곱셈
    }
}
