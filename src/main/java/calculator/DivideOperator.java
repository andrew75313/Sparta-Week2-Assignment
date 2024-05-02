package calculator;

public class DivideOperator implements Calculatable {
    @Override
    public double operate(double num1, double num2) throws CalculationException {
        if (num2 == 0) {
            throw new CalculationException("나눗셈에서 0으로 나눌 수 없습니다.");
        }
        return (double) (num1 / num2); // 나눗셈
    }
}
