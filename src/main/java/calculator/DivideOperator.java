package calculator;

public class DivideOperator implements Calculatable {
    @Override
    public double operate(int num1, int num2) {
        return (double) (num1 / num2); // 나눗셈
    }
}
