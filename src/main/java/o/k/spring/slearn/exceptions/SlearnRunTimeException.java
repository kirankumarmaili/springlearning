package o.k.spring.slearn.exceptions;

/**
 * Exception
 */
public abstract class SlearnRunTimeException extends RuntimeException {

    private static final long serialVersionUID = -6768800723912495763L;

    abstract ErrorCode getErrorCode();

    public SlearnRunTimeException(String message) {
        super(message);
    }
}