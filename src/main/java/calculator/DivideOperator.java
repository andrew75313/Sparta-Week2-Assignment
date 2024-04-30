package calculator;

public class DivideOperator implements Calculatable {
    @Override
    public double operate(double num1, double num2) {
        return (double) (num1 / num2); // 나눗셈
    }
}
