package calculator;

import java.util.Deque;
import java.util.LinkedList;

public class Calculator {
    /* 필드 생성*/
    /* 상속해줄 클래스까지만 유효하게 하기 위해 protected 제어자 설정 */
    protected int num1;
    protected int num2;
    protected char operator;
    /* 연산 결과를 저장하는 Deque 선언 및 생성 (캡슐화 */
    protected Deque<Double> calculationResult = new LinkedList<>();

    /* 원넓이 저장 필드 생성 */
    /* static final 모두 사용할 수 있지만,
    동시에 초기값을 입력해서 그 값을 절대 바꿀수 없는 상수로 선언을 해야함.
    하지만, 컬렉션일 경우에는 final로 초기값을 선언해버린다고 해도 객체변경은 안되나
    계속해서 그 안의 데이터들을 마음대로 수정할 수 있기 때문에 final의 의미가 없음
    단, Null초기화를 컴파일러가 진행하기때문에 이때, add를 통해 값을 넣으려고 하면,
    NullPointerException 가능성이 있기 때문에 가급적 final과 함께 Deque을
    비어있는 LinkedList로 생성해줘야한다고 판단해서 static final을 사용했습니다*/
    static final Deque<Double> circleAreaResult = new LinkedList<>();





    /* 초기화를 위한 기본 생성자 */
//    public Calculator() {
//        calculationResult = new LinkedList<>();
//    }
//
//
//    public double calculate(int num1, int num2, char operator) throws DivideException {
//        this.num1 = num1;
//        this.num2 = num2;
//        this.operator = operator;
//
//        double result = 0;
//        /*사칙연산 & 나눗셈오류출력*/
//        if (operator == '/' && num2 == 0) { // 분모가 0인 나눗셈은 연산 없이 경고문구 출력
//            /**/
//            throw new DivideException("나눗셈 연산에서 분모에 0이 입력될 수 없습니다.");
//        } else {
//            /* 입력된 operator 값 + - * / 에 따라 각각 연산 후, 결과값 출력*/
//            switch (operator) {
//                case '+':
//                    result = num1 + num2;
//                    break;
//                case '-':
//                    result = num1 - num2;
//                    break;
//                case '*':
//                    result = num1 * num2;
//                    break;
//                case '/':
//                    result = (double) num1 / num2;
//                    break;
//            }
//            calculationResult.add(result);
//            return result;
//        }
//    }
//
//    /* Getter 메서드 */
//    public Deque<Double> getCalculationResult() {
//        return calculationResult;
//    }
//
//    /* Setter 메서드 */
//    public void setCalculationResult(double result) {
//        calculationResult.add(result); // 결과 저장 메서드에 임의로 추가로 저장
//    }
//
//    /* 연산결과 중 첫번째 결과 삭제 메서드*/
//    public void removeResult() {
//        Scanner sc = new Scanner(System.in);
//        /*remove입력시 calculationResult 최초 연산 삭제*/
//        System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
//        String input = sc.next();
//        if (input.equals("remove")) {
//            this.getCalculationResult().pollFirst(); // 가장 처음값 꺼내서 없애기
//        }
//    }
//
//    /* 저당된 연산결과 조회 기능 메서드 */
//    public void inquiryResults() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
//        String input = sc.next();
//        if (input.equals("inquiry")) {
//            for (double resultIndex : this.getCalculationResult()) {
//                System.out.println(resultIndex); // 한 줄씩 출력
//            }
//        }
//
//    }

//    /* 원의 넓이 계산 & 반환 메서드 */
//    public double calculateCircleArea(double radius) {
//        double circleArea = radius*radius*PI;
//        return circleArea;
//    }
//    /* 원의 넓이 저장 컬렉션 Getter 메서드*/
//    public Deque<Double> getCircleAreaResult() {
//        return circleAreaResult; // 저장필드 전체 반환
//    }
//    /* 원의 넓이 Setter 메서드 */
//    public void setCircleAreaResult(double result) {
//        circleAreaResult.add(result); // 외부에서 연산 결과 추가
//    }
//
//
//}



    /*사용자정의 예외 클래스 DivideException 정의*/
    class DivideException extends Exception {
        public DivideException(String input) {
            super(input);
        }
    }
}