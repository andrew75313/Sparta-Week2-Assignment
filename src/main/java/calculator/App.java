package calculator;


import java.util.*;

public class App {
    public static void main(String[] args) throws CalculationException {
        Scanner sc = new Scanner(System.in);
        /* Calculator 객체 생성*/
        ArithmeticCalculator<Double> arithmeticCalculator = new ArithmeticCalculator<>(new LinkedList<>(), Double.class);
        CircleCalculator<Double> circleCalculator = new CircleCalculator<>(new LinkedList<>(), Double.class);


        /* exit 문자열이 입력될 때 까지 연산 반복 반복문*/
        String input = null; // do - while 반복문 조건에 넣기 위해 입력값 초기화

        /* 반복문 시작 */
        do {
            System.out.print("사칙연산, 원의너비 둘 중 어느 것을 구하겠습니까? (Arithmetic/Circle 중 입력): ");
            String decision = sc.next();

            switch (decision) {
                case "Arithmetic": // 사칙연산일경우 실행
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    /* Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다. */
                    double num1 = sc.nextDouble();
                    System.out.print("사칙연산 기호를 입력하세요: "); // + - * / 중 하나를 입력받음
                    /* charAt(idx)는 String타입 하나 입력된 기호를 charAt으로 char타입의 변수로 선언 */
                    char operator = sc.next().charAt(0);
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    /* Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다. */
                    double num2 = sc.nextDouble();

                    /*Calculator의 DivideException Handling*/
                    try {
                        /*Calculator 클래스를 활용한 사칙연산*/
                        double result = arithmeticCalculator.calculate(num1, num2, operator);
                        /*최근 연산값 출력*/
                        System.out.println("결과: " + result);
                    } catch (CalculationException e1) {
                        System.out.println(e1.getMessage());
                    }

                    /* Calculator 클래스의 저장 연산 결관 출력 inquiryResults 메서드 실행*/
                    arithmeticCalculator.inquiryResults();
                    /* 입력값 보다 가장 큰 결과값만 조회하는 biggerResult 메서드 실행*/
                    System.out.print("입력 값보다 더 큰 값을 출력하겠습니까? (yes 입력 시 조회)");
                    /*yes 입력시 기준값 입력*/
                    if (sc.next().equals("yes")) {
                        System.out.print("기준 값을 입력하세요.: ");
                        double num = sc.nextDouble();
                        arithmeticCalculator.biggerResult(num);
                    }


                    break;
                case "Circle": // 원의 너비일 경우 실행
                    System.out.print("반지름을 입력하세요: ");
                    /* Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다. */
                    double radius = sc.nextDouble();

                    /* Calculator 클래스를 활용한 원의 너비 구하기*/
                    double result = circleCalculator.calculateCircleArea(radius);

                    /*저장값 조회 메서드*/
                    circleCalculator.inquiryResults();
                    break;
            }

            /*추가 연산 여부 확인*/
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");

        } while (!(sc.next().equals("exit"))); // exit이 입력되면 반복문 종료, 그 외에는 계속 반복와


    }
}