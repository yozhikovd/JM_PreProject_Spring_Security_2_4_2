package yozhikovd.models;
import jakarta.validation.constraints.Min;
import org.hibernate.validator.constraints.*;


import javax.persistence.*;


@Entity
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

    public User() {
    }

    public User(Long id, String name, String lastName, int age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
