package calculator;


import java.util.*;

public class App {
    public static void main(String[] args) throws DivideException {
//        /*연산 결과 10개를 저장할 길이 int배열 객체 생성*/
//        int[] calculationResult = new int[10];
//        /*연산 결과를 index에 저장하면서 카운트 초기값*/
//        int idx = 0;
//
//        /* 10개 이상 결과 무한 저장 Queue 생성*/
//        Queue<Integer> calculationResult = new LinkedList<>();

        Scanner sc = new Scanner(System.in);
        /* Calculator 객체 생성*/
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator(); // 기본 생성자 사용
        CircleCalculator circleCalculator = new CircleCalculator(); // 각각 생성
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
                    int num1 = sc.nextInt();
                    System.out.print("사칙연산 기호를 입력하세요: "); // + - * / 중 하나를 입력받음
                    /* charAt(idx)는 String타입 하나 입력된 기호를 charAt으로 char타입의 변수로 선언 */
                    char operator = sc.next().charAt(0);
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    /* Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다. */
                    int num2 = sc.nextInt();


//            int result = 0; // 연산 결과 초기값
//            /*연산 시작*/
//            if (operator == '/' && num2 == 0) { // 분모가 0인 나눗셈은 연산 없이 경고문구 출력
//                System.out.println("나눗셈 연산에서 분모에 0이 입력될 수 없습니다.");
//            } else {
//                /* 입력된 operator 값 + - * / 에 따라 각각 연산 후, 결과값 출력*/
//                switch (operator) {
//                    case '+':
//                        result = num1 + num2;
//                        break;
//                    case '-':
//                        result = num1 - num2;
//                        break;
//                    case '*':
//                        result = num1 * num2;
//                        break;
//                    case '/':
//                        result = num1 / num2;
//                        break;
//                }
//                System.out.println("결과: " + result);


                    /*Calculator의 DivideException Handling*/
                    try {
                        /*입력값에 따라 Operator 설정*/
                        Calculatable cal = null; // 조건문에서 생성된 것을 저장하기 위해
                        switch (operator) {
                            case '+':
                                cal = new AddOperator();
                                break;
                            case '-':
                                cal = new SubtractOperator();
                                break;
                            case '*':
                                cal = new MultiplyOperator();
                                break;
                            case '/':
                                cal = new DivideOperator();
                                break;
                            case '%':
                                cal = new ModOperator();
                                break;

                        }
                        /*Calculator 클래스를 활용한 사칙연산*/
                        double result = arithmeticCalculator.calculate(num1, num2, cal);
                        /*최근 연산값 출력*/
                        System.out.println("결과: " + result);
                    } catch (DivideException e1) {
                        System.out.println(e1.getMessage());
                    }


//                /*인덱스 9초과를 했을 경우, 처음 값을 지우고 앞으로 당겨 마지막에 저장*/
//                if (idx > 9) {
//                    for (int i = 0; i < 9; i++) { // index 하나씩 앞으로 당기면서 덮어쓰기
//                        calculationResult[i] = calculationResult[i + 1];
//                    }
//                    calculationResult[9] = result; // 새로 들어온값 index 9에 덮어쓰기
//                    idx++; // 연산 수 카운팅 이어서
//                } else { // idx 카운트가 9이하일때
//                    /*연산결과 배열에 저장*/
//                    calculationResult[idx] = result;
//                    idx++; // 다음 반복시 다음 인덱스에 넣기 위에 증가 연산자
//                }
//
//                /*calculationResult 연산저장*/
//                calculationResult.add(result);

//            /*remove입력시 calculationResult 최초 연산 삭제*/
//            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
//            input = sc.next();
//            if (input.equals("remove")) {
//                calculator.getCalculationResult().pollFirst(); // 가장 처음값 꺼내서 없애기
//            }

                    /* Calculator 클래스의 첫 연산결과 삭제 removeResult 메서드 실행 */
                    arithmeticCalculator.removeResult();


//            /*inquiry입력시 calculationResult 전부 출력*/
//            System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
//            input = sc.next();
//            if (input.equals("inquiry")) {
//                for (double resultIndex : calculator.getCalculationResult()) {
//                    System.out.println(resultIndex); // 한 줄씩 출력
//                }
//            }

                    /* Calculator 클래스의 저장 연산 결관 출력 inquiryResults 메서드 실행*/
                    arithmeticCalculator.inquiryResults();

                    break;
                case "Circle": // 원의 너비일 경우 실행
                    System.out.print("반지름을 입력하세요: ");
                    /* Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다. */
                    double radius = sc.nextDouble();

                    /* Calculator 클래스를 활용한 원의 너비 구하기*/
                    double result = circleCalculator.calculateCircleArea(radius);
                    System.out.println("결과: " + result);
                    /* 원의 넓이 저장*/
                    circleCalculator.setCircleAreaResult(result);
                    /* 저장된 원의 넓이 값들 바로 전체 조회*/
                    System.out.println("저장된 원의 넓이 값들입니다.: ");
                    for (double idx : circleCalculator.getCircleAreaResult()) {
                        System.out.println(idx);
                    }
                    break;
            }

            /*추가 연산 여부 확인*/
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            input = sc.next();

        } while (!(input.equals("exit"))); // exit이 입력되면 반복문 종료, 그 외에는 계속 반복와


    }
}