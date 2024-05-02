package calculator;

public class NumberConversion {

    @SuppressWarnings("unchecked")
    public static <T extends Number> T convertNumberType(Number number, Class<T> type) throws CalculationException { //지네릭 메서드
        if (type == Integer.class) {
            return (T) Integer.valueOf(number.intValue());
        } else if (type == Double.class) {
            return (T) Double.valueOf(number.doubleValue());
        } else if (type == Float.class) {
            return (T) Float.valueOf(number.floatValue());
        } else if (type == Long.class) {
            return (T) Long.valueOf(number.longValue());
        } else {
            throw new CalculationException("지원하지 않는 숫자 타입입니다.");
        }
    }
}
