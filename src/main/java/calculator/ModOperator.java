package calculator;

public class ModOperator<T extends Number> implements Calculatable<T> {
    /*Class 클래스 type 선언*/
    public final Class<T> type;

    /*생성자*/
    public ModOperator(Class<T> type){
        this.type = type;
    }
    @Override
    public T operate(T num1, T num2) throws CalculationException {
        double result = num1.doubleValue() % num2.doubleValue(); // 나머지 연산
        return NumberConversion.convertNumberType(result, type);
    }
}
