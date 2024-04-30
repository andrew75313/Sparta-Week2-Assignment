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

    /*해당 symbol을 얻을 수 있는 Getter*/
    public char getSymbol() {
        return symbol;
    }

}
