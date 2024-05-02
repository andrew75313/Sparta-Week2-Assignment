package calculator;

public class AddOperator<T extends Number> implements Calculatable<T> {

    /*Class 클래스 type 선언*/
    public final Class<T> type;

    /*생성자*/
    public AddOperator(Class<T> type){
        this.type = type;
    }
    @Override
    public T operate(T num1, T num2) throws CalculationException {
        double result = num1.doubleValue() + num2.doubleValue(); // 덧셈

        return NumberConversion.convertNumberType(result, type);
    }
}
