package o.k.spring.slearn.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * User
 */
@Data
@AllArgsConstructor
public class User {
	private Integer id;
	@Size(min = 2, max = 100, message = "Name should have atleat 2 chars")
	private String name;
	@Past(message="Date to be in past")
	private Date birthDate;
}