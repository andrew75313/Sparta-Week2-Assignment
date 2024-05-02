package calculator;

public class DivideOperator<T extends Number> implements Calculatable<T> {

    /*Class 클래스 type 선언*/
    public final Class<T> type;

    /*생성자*/
    public DivideOperator(Class<T> type){
        this.type = type;
    }
    @Override
    public T operate(T num1, T num2) throws CalculationException {
        if (num2.doubleValue() == 0) {
            throw new CalculationException("나눗셈에서 0으로 나눌 수 없습니다.");
        }
        double result = num1.doubleValue() / num2.doubleValue(); // 나눗셈

        return NumberConversion.convertNumberType(result, type);
    }
}
