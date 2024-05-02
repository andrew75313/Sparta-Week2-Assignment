package calculator;

public class MultiplyOperator<T extends Number> implements Calculatable<T> {
    /*Class 클래스 type 선언*/
    public final Class<T> type;

    /*생성자*/
    public MultiplyOperator(Class<T> type){
        this.type = type;
    }
    @Override
    public T operate(T num1, T num2) throws CalculationException {


        double result = num1.doubleValue() * num2.doubleValue(); ; // 곱셈
        return NumberConversion.convertNumberType(result, type);
    }
}
