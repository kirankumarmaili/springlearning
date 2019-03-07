package o.k.spring.slearn.post;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import o.k.spring.slearn.user.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="post")
public class Post {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@NotNull
	private String description;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private User user;
	
}
