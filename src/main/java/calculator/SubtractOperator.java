package calculator;

public class SubtractOperator implements Calculatable {
    @Override
    public double operate(int num1, int num2) {
        return num1 - num2; // 뺄셈
    }
}
