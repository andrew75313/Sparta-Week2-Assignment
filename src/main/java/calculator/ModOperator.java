package calculator;

public class ModOperator implements Calculatable {
    @Override
    public double operate(double num1, double num2) {
        return (double) (num1 % num2); // 나머지 연산
    }
}
