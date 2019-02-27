package o.k.spring.slearn.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * NotFoundException
 */

 @ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends SlearnRunTimeException {

    private static final long serialVersionUID = 3980264552886170179L;
    
    public NotFoundException(String message) {
        super(message);
    }

    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.NOT_FOUND;
    }
}