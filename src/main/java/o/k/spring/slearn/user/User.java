package o.k.spring.slearn.user;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * User
 */
@Data
@AllArgsConstructor
public class User {

    private Integer id;
    private String name;
    private Date birDate;
}