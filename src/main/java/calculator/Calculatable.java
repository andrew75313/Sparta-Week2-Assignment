package calculator;

public interface Calculatable {
    /*사칙연산 Operator에 공통으로 구현될 메서드*/
    /*새로운 연산클래스를 생성할때 구현*/
    double operate(int num1, int num2);
}
