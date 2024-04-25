package calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 숫자를 입력하세요: ");
        /* Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다. */
        int num1 = sc.nextInt();
        System.out.print("두 번째 숫자를 입력하세요: ");
        /* Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다. */
        int num2 = sc.nextInt();

        System.out.println("사칙연산 기호를 입력하세요: "); // + - * / 중 하나를 입력받음
        /* charAt(idx)는 String타입 하나 입력된 기호를 charAt으로 char타입의 변수로 선언 */
        char operator = sc.next().charAt(0);
    }
}
