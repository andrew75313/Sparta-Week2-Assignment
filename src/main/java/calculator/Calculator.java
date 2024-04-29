package calculator;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Calculator {
    /* 필드 생성*/
    private int num1;
    private int num2;
    private char operator;
    /* 연산 결과를 저장하는 Deque 선언 및 생성 */
    private Deque<Double> calculationResult = new LinkedList<>();

    public Deque<Double> calculate(int num1, int num2, char operator) throws DivideException {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;

        double result = 0;
        /*사칙연산 & 나눗셈오류출력*/
        if (operator == '/' && num2 == 0) { // 분모가 0인 나눗셈은 연산 없이 경고문구 출력
            /**/
            throw new DivideException("나눗셈 연산에서 분모에 0이 입력될 수 없습니다.");
        } else {
            /* 입력된 operator 값 + - * / 에 따라 각각 연산 후, 결과값 출력*/
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = (double) num1 / num2;
                    break;
            }
            calculationResult.add(result);
            return calculationResult;
        }
    }
    /* Getter 메서드 */
    public Deque<Double> getCalculationResult() {
        return this.calculationResult;
    }

    /* Setter 메서드 */
    public void setCalculationResult(int num1, int num2, char operator) {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
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


/*사용자정의 예외 클래스 DivideException 정의*/
class DivideException extends Exception {
    public DivideException(String input) {
        super(input);
    }
}
