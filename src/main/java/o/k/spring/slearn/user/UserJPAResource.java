package o.k.spring.slearn.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import o.k.spring.slearn.exceptions.UserIdNotFoundException;


/**
 * UserResource
 */
@RestController
@RequestMapping("jpa/users")
public class UserJPAResource {
    
    @Autowired
    private UserRepository userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping(value="/{id}",produces={MediaType.APPLICATION_JSON_VALUE})
    public Resource<User> getUserWithId(@PathVariable int id) {
    	User user = userService.findById(id).orElseThrow(() -> new UserIdNotFoundException(id));
    	Resource<User> resource = new Resource<>(user);
    	ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getAllUsers());
    	resource.add(linkTo.withRel("all-users"));
        return resource;
    }

    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody User user) {
        User savedUser = userService.save(user);
        URI locationOfNewUser = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(locationOfNewUser).build();
    }
    
    @DeleteMapping(value="/{id}")
    public User deleteUser(@PathVariable int id) {
    	User user = userService.findById(id).orElseThrow(() -> new UserIdNotFoundException(id));
    	userService.deleteById(id);
    	return user;
    }
    
}