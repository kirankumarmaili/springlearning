package o.k.spring.slearn.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * UserDaoService
 */
@Component
public class UserDaoService {
    private final static List<User> users  = new ArrayList<>();
    private static int userCount = 3;
    static {
        users.add(new User(1,"Adam",new Date()));
        users.add(new User(2,"Eve",new Date()));
        users.add(new User(3,"Jack", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User u) {
        if(u.getId() !=null)
            u.setId(++userCount);
        users.add(u);
        return u;
    }

    public User findOne(int id) {
        for(User user:users) {
            if(user.getId()==id)
                return user;
        }
        return null;
    }
}