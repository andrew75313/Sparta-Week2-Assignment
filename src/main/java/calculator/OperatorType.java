package calculator;

public enum OperatorType {
    /*열거형 멤버*/
    ADD('+'),
    SUBSTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/'),
    MODE('%');

    /*생성자의 저장되는 필드 변수*/
    private final char symbol;

    /*생성자*/
    private OperatorType(char symbol) {
        this.symbol = symbol;
    }

    /**
     * char operator 값을 받아 해당 OperatorType 반환 메서드
     *
     * @return OperatorType
     * @parma char : operator
     */
    public static OperatorType fromOperator(char operator) throws CalculationException { // 일단 초기화, enum은 새로운 객체생성 불가
        for (OperatorType op : OperatorType.values()) { // 입력된 operator와 enum의 symbol을 비교
            if (op.symbol == operator) { // enum에서 저장된 필드변수를 바로 불러올 수 있음 getter 필요 X
               return op;
            }
        }
        throw new CalculationException("잘못 입력된 연산기호 입니다.");
    }
}
//
//
//    public char getSymbol() {
//        return symbol;
//    }
