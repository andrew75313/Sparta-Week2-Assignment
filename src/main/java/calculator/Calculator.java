package calculator;

import java.util.Deque;
import java.util.LinkedList;

public abstract class Calculator<T extends Number> {

    private final Deque<T> calculationResult; // ArithmeticCalculator, CircleCalculator 값 모두 같은곳에 저장

    /*초기화 생성자*/
    public Calculator(Deque<T> calculationResult) {
        this.calculationResult = calculationResult;
    }

    /*calculationResult의 Getter*/
    public Deque<T> getCalculationResult() {
        return calculationResult;
    }

    /*calculationResult의 Setter*/
    public void setCalculationResult(T result) {
        calculationResult.add(result);
    }

    /*ArithmeticCalculator CircleCalculator 의 공통 메서드*/
    abstract void inquiryResults();

}