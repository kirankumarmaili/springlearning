package o.k.spring.slearn.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import o.k.spring.slearn.exceptions.UserIdNotFoundException;
import o.k.spring.slearn.user.User;
import o.k.spring.slearn.user.UserRepository;

@RestController
@RequestMapping(value="/posts")
public class PostResource {
	
	@Autowired
	PostDaoService postDaoService;
	
	@Autowired
	UserRepository userRespository;
	
	@GetMapping
	public List<Post> getAllPosts() {
		return postDaoService.findAll();
	}
	
	@PostMapping(value="{userid}")
	public void addPostFromUser(@PathVariable("userid") Integer userid, @RequestBody Post post) {
		User user = userRespository.findById(userid).orElseThrow(() -> new UserIdNotFoundException(userid));
		if(post.getId()!=null) {
			post.setId(null);
		}
		post.setUser(user);
	}
}
