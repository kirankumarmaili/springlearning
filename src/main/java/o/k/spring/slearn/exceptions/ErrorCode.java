package o.k.spring.slearn.exceptions;

/**
 * ErrorCode
 */
public enum ErrorCode {
    UNKNOWN(0),
    NOT_FOUND(1),
    USERID_NOT_FOUND(2),
    VALIDATION_FAILED(3);

    private final int value;

    private ErrorCode(int errorCode) {
        this.value = errorCode;
    }

    public int getValue() {
        return value;
    }


   
}