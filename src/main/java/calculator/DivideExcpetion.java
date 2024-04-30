package calculator;

/*사용자정의 예외 클래스 DivideException 정의*/
/*Calculator 클래스에서 따로 뺌*/
class DivideException extends Exception {
    public DivideException(String input) {
        super(input);
    }
}