package az.developia.compshopsemseddinsalehli.enums;

public enum ExceptionCode {
    USER_NOT_FOUND(100),
    VALIDATION_EXCEPTION(101),
    COMPUTER_NOT_FOUND(102),
    BASKET_NOT_FOUND(103);

    private final int code;

    ExceptionCode(int i) {
        code = i;
    }

    public int getCode() {
        return code;
    }
}
