package calculator;

public interface Calculatable<T> {
    /*사칙연산 Operator에 공통으로 구현될 메서드*/
    /*새로운 연산클래스를 생성할때 구현*/
    T operate(T num1, T num2) throws CalculationException; //나눗셈 에외 발생 가능
}
