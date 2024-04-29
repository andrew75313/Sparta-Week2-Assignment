package calculator;

import java.util.Deque;

import static java.lang.Math.PI;

public class CircleCalculator extends Calculator {
    /* 원의 넓이 계산 & 반환 메서드 */
    public double calculateCircleArea(double radius) {
        double circleArea = radius * radius * PI;
        return circleArea;
    }

    /* 원의 넓이 저장 컬렉션 Getter 메서드*/
    public Deque<Double> getCircleAreaResult() {
        return circleAreaResult; // 저장필드 전체 반환
    }

    /* 원의 넓이 Setter 메서드 */
    public void setCircleAreaResult(double result) {
        circleAreaResult.add(result); // 외부에서 연산 결과 추가
    }


}

