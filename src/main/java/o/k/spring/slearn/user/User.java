package o.k.spring.slearn.user;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import o.k.spring.slearn.post.Post;

/**
 * User
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	@Size(min = 2, max = 100, message = "Name should have atleat 2 chars")
	private String name;
	@Past(message = "Date to be in past")
	private Date birthDate;
	
	User(Integer id,String name,Date birthDate) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	
	@OneToMany(mappedBy="user")
	private List<Post> posts;
}