package o.k.spring.slearn.exceptions;

import lombok.Data;

/**
 * UserIdNotFoundException
 */
@Data
public class UserIdNotFoundException extends NotFoundException {
    private static final long serialVersionUID = 2599429176586475691L;

    public UserIdNotFoundException(Integer id) {
        super("User id :" + id + " not found");
    }
}