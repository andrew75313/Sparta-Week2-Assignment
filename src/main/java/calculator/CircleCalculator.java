package calculator;

import java.util.Deque;
import java.util.Scanner;

import static java.lang.Math.PI;

public class CircleCalculator extends Calculator {
    /*super을 통해 상위 Calculator 클래스 생성자에 보내줌*/
    public CircleCalculator(Deque<Double> calculationResult) {
        super(calculationResult);
    }

    /**
     * 원의 넓이를 구하는 메서드
     *
     * @param radius : 원의 반지름
     * @return 원의 넓이
     */
    public double calculateCircleArea(double radius) {
        double result = radius * radius * PI;
        super.setCalculationResult(result); //결과 저장
        return result;
    }

//    /* 원의 넓이 저장 컬렉션 Getter 메서드*/
//    public Deque<Double> getCircleAreaResult() {
//        return circleAreaResult; // 저장필드 전체 반환
//    }

    @Override
    public void inquiryResults() {
        Scanner sc = new Scanner(System.in);
        System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
        String input = sc.next();
        if (input.equals("inquiry")) {
            for (double resultIndex : super.getCalculationResult()) { //Calculator에서 가져다가 씀
                System.out.println(resultIndex); // 한 줄씩 출력
            }
        }

    }

//    /* 원의 넓이 Setter 메서드 */
//    public void setCircleAreaResult(double result) {
//        circleAreaResult.add(result); // 외부에서 연산 결과 추가
//    }


}

