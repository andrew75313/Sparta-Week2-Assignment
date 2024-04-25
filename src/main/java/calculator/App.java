package calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /* exit 문자열이 입력될 때 까지 연산 반복 반복문*/
        String input = null; // do - while 반복문 조건에 넣기 위해 입력값 초기화
        do {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            /* Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다. */
            int num1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            /* Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다. */
            int num2 = sc.nextInt();
            System.out.print("사칙연산 기호를 입력하세요: "); // + - * / 중 하나를 입력받음
            /* charAt(idx)는 String타입 하나 입력된 기호를 charAt으로 char타입의 변수로 선언 */
            char operator = sc.next().charAt(0);


            int result = 0; // 연산 결과 초기값
            /*연산 시작*/
            if (operator == '/') { // 분모가 0인 나눗셈은 연산 없이 경고문구 출력
                System.out.println("나눗셈 연산에서 분모에 0이 입력될 수 없습니다.");
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
                        result = num1 / num2;
                        break;
                }
                System.out.println("결과: " + result);
                System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
                input = sc.next();
            }
        } while (!(input.equals("exit"))); // exit이 입력되면 반복문 종료, 그 외에는 계속 반복와
}