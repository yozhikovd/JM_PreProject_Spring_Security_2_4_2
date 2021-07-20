package yozhikovd.models;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.*;


import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @Length(min = 3, max = 30, message = "Name must be between 2 and 30 characters")
    private String name;

    @Column(name = "lastName")
    @Length(min = 3, max = 30, message = "LastName must be between 2 and 30 characters")
    private String lastName;

    @Min(value = 0)
    @Column(name = "age")
    private int age;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

 }
