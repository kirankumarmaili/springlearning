package o.k.spring.slearn.exceptions;

/**
 * UserIdNotFoundException
 */
public class UserIdNotFoundException extends NotFoundException {
    private static final long serialVersionUID = 2599429176586475691L;

    public UserIdNotFoundException(Integer id) {
        super("User id :" + id + " not found");
    }

    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.USERID_NOT_FOUND;
    }
}