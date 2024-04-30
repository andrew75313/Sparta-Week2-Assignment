package calculator;

import java.util.Deque;
import java.util.Scanner;

public class ArithmeticCalculator extends Calculator {
//    /*사칙연산 클래스선언 */
//    private AddOperator addOperator;
//    private SubtractOperator subtractOperator;
//    private MultiplyOperator multiplyOperator;
//    private DivideOperator divideOperator;
//    private ModOperator modOperator;
//
//
//    /*사칙연산 클래스 초기화*/
//    public ArithmeticCalculator() {
//        this.addOperator = new AddOperator();
//        this.subtractOperator = new SubtractOperator();
//        this.multiplyOperator = new MultiplyOperator();
//        this.divideOperator = new DivideOperator();
//        this.modOperator = new ModOperator();
//    }

//    public double calculate(int num1, int num2, char operator) throws DivideException {
//        double result = 0;
//        /*사칙연산 & 나눗셈오류출력*/
//        if (operator == '/' && num2 == 0) { // 분모가 0인 나눗셈은 연산 없이 경고문구 출력
//            /**/
//            throw new DivideException("나눗셈 연산에서 분모에 0이 입력될 수 없습니다.");
//        } else {
//            /* 입력된 operator 값 + - * / 에 따라 각각 연산 후, 결과값 출력*/
//            switch (operator) {
//                case '+':
//                    result = addOperator.operate(num1, num2);
//                    break;
//                case '-':
//                    result = subtractOperator.operate(num1, num2);
//                    break;
//                case '*':
//                    result = multiplyOperator.operate(num1, num2);
//                    break;
//                case '/':
//                    result = divideOperator.operate(num1, num2);
//                    break;
//                case '%':
//                    result = modOperator.operate(num1, num2);
//            }
//
//        calculationResult.add(result);
//        return result;
//    }

    /*Calculatable 인터페이스 구현 사칙연산을 활용*/
    public double calculate(int num1, int num2, char operator) throws DivideException {
        double result = 0;

        /*enum을 활용하여 연산*/
        /*enum의 개념만 알고 있어서, 이렇게 활용하는지 잘 모르겠습니다..*/
        OperatorType operatorType = null; // 일단 초기화, enum은 새로운 객체생성 불가
        for (OperatorType op : OperatorType.values()) { // 입력된 operator와 enum의 symbol을 비교
            if (op.getSymbol() == operator) {
                operatorType = op;
            }
        }
        /*맞는 Symbol에 따라서 연산 operator 결정*/
        Calculatable calculatable = null; // switch 문내에서 객체생성 안됨
        switch (operatorType) {
            case ADD:
                calculatable = new AddOperator();
                break;
            case SUBSTRACT:
                calculatable = new SubtractOperator();
                break;
            case MULTIPLY:
                calculatable = new MultiplyOperator();
                break;
            case DIVIDE:
                calculatable = new DivideOperator();
                break;
            case MODE:
                calculatable = new ModOperator();
                break;
        }

        /*calculate 메서드를 사용할 때, operator만 구분해서 사용*/
        result = calculatable.operate(num1, num2);
        calculationResult.add(result);
        return result;
    }


    /* Getter 메서드 */
    public Deque<Double> getCalculationResult() {
        return calculationResult;
    }

    /* Setter 메서드 */
    public void setCalculationResult(double result) {
        calculationResult.add(result); // 결과 저장 메서드에 임의로 추가로 저장
    }

    /* 연산결과 중 첫번째 결과 삭제 메서드*/
    public void removeResult() {
        Scanner sc = new Scanner(System.in);
        /*remove입력시 calculationResult 최초 연산 삭제*/
        System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
        String input = sc.next();
        if (input.equals("remove")) {
            this.getCalculationResult().pollFirst(); // 가장 처음값 꺼내서 없애기
        }
    }

    /* 저당된 연산결과 조회 기능 메서드 */
    public void inquiryResults() {
        Scanner sc = new Scanner(System.in);
        System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
        String input = sc.next();
        if (input.equals("inquiry")) {
            for (double resultIndex : this.getCalculationResult()) {
                System.out.println(resultIndex); // 한 줄씩 출력
            }
        }

    }

}
