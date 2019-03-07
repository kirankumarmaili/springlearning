package o.k.spring.slearn.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/posts")
public class PostResource {
	
	@Autowired
	PostDaoService postDaoService;
	
	@GetMapping
	public List<Post> getAllPosts() {
		return postDaoService.findAll();
	}
}
