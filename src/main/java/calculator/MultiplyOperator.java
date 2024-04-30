package calculator;

public class MultiplyOperator implements Calculatable {
    @Override
    public double operate(double num1, double num2) {
        return num1 * num2 ; // 곱셈
    }
}
