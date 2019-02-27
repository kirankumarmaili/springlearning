package o.k.spring.slearn.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.micrometer.core.ipc.http.HttpSender.Response;
import o.k.spring.slearn.exceptions.UserIdNotFoundException;


/**
 * UserResource
 */
@RestController
public class UserResource {
    
    @Autowired
    private UserDaoService userService;

    @GetMapping(value="/users")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    
    @GetMapping(value="/users/{id}")
    public User getUserWithId(@PathVariable int id) {
        return userService.findOne(id).orElseThrow(() -> new UserIdNotFoundException(id));
    }
    

    @PostMapping(value="/users")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        User savedUser = userService.save(user);
        //Creating the location of the userid , /users/{id}
        URI locationOfNewUser = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(locationOfNewUser).build();
    }
    
}