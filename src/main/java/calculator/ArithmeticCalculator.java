package calculator;

import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Stream;

public class ArithmeticCalculator<T extends Number> extends Calculator { // Number클래스의 모든 타입을 가능

    /*Class 클래스 type 선언*/
    public final Class<T> type;

    /*super을 통해 상위 Calculator 클래스 생성자에 보내줌 + 타입초기화*/
    public ArithmeticCalculator(Deque<T> calculationResult, Class<T> type) {
        super(calculationResult);
        this.type = type;
    }

    /*인터페이스 구현*/
    private Calculatable calculatable; // switch 문내에서 객체생성 안됨


    /*Calculatable 인터페이스 구현 사칙연산을 활용*/
    public T calculate(T num1, T num2, char operator) throws CalculationException {

        super.setCalculationResult(operatorFactory(operator).operate(num1, num2)); // 결과 저장
        /*operatorFactory에 operator넣어서 연산자를 불러오고 다음에 operate 메서드를 불러와서 num1 num2 넣어서 계산*/
        return operatorFactory(operator).operate(num1, num2);
    }

    /*연산자를 정해주는 새로운 메서드*/
    private Calculatable<T> operatorFactory(char operator) throws CalculationException {
        /*operator타입에 따라 operatorType 불러오기*/
        OperatorType operatorType = OperatorType.fromOperator(operator);
        return switch (operatorType) {
            case ADD -> new AddOperator(type);
            case SUBSTRACT -> new SubtractOperator(type);
            case MULTIPLY -> new MultiplyOperator(type);
            case DIVIDE -> new DivideOperator(type);
            case MODE -> new ModOperator(type);
        };
    }


    /* 연산결과 중 첫번째 결과 삭제 메서드*/
    public void removeResult() {
        Scanner sc = new Scanner(System.in);
        /*remove입력시 calculationResult 최초 연산 삭제*/
        System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
        String input = sc.next();
        if (input.equals("remove")) {
            super.getCalculationResult().pollFirst(); // 가장 처음값 꺼내서 없애기
        }
    }

    /* 저당된 연산결과 조회 기능 메서드 오버라이드*/
    @Override
    public void inquiryResults() {
        Scanner sc = new Scanner(System.in);
        System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
        String input = sc.next();
        if (input.equals("inquiry")) {
            for (Object resultIndex : super.getCalculationResult()) { //Calculator에서 가져다가 씀
                System.out.println(resultIndex); // 한 줄씩 출력
            }
        }

    }

    /*저장 결과 중 Scanner 입력받은 값보다 큰 결과 값들 출력 메서드*/
    public void biggerResult(double number) {
        /*calculationResult Deque 컬렉션을 스트림으로 만들기*/
        /*컬렉션에 저장된 값을 변경하지 않아도 가능*/
        Stream<Double> biggerResultStream = super.getCalculationResult().stream();
        /*Stream 중간연산 filter 사용*/
        /*Stream 최종연산 forEach 사용*/
        biggerResultStream.filter(d -> d > number).forEach(System.out::println);
    }

}

