package o.k.spring.slearn.exceptions;

/**
 * ErrorCode
 */
public enum ErrorCode {
    UNKNOWN(0),
    NOT_FOUND(1),
    USERID_NOT_FOUND(2);

    private final int errorCode;

    private ErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }


   
}