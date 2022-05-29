package jp.co.axa.apidemo.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "USER")
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"password"})
public class User {
    @Getter
    @Setter
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID", updatable = false, nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private UUID id;

    @Getter
    @Setter
    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Getter
    @Setter
    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    @Getter
    @Setter
    @Column(name = "PASSWORD", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
