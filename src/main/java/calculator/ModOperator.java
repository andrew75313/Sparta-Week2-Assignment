package calculator;

public class ModOperator implements Calculatable {
    @Override
    public double operate(int num1, int num2) {
        return (double) (num1 % num2); // 나머지 연산
    }
}
