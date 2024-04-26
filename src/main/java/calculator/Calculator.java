package calculator;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Calculator {
    /* 연산 결과를 저장하는 Deque 선언 및 생성 */
    static Deque<Double> calculationResult = new LinkedList<>();

    public static Deque<Double> calculate(int num1, int num2, char operator) throws DivideException {
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
                    result = (double)num1 / num2;
                    break;
            }
            calculationResult.add(result);
            return calculationResult;
        }
    }
}

class DivideException extends Exception {
    public DivideException(String input) {
        super(input);
    }
}
