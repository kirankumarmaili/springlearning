package o.k.spring.slearn.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDaoService extends JpaRepository<Post, Integer>{

}
