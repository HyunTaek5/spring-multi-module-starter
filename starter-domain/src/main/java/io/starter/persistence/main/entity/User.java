package io.starter.persistence.main.entity;

import io.starter.persistence.main.entity.type.Role;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity @Getter @Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @CreatedDate
    @Column(name="createdAt")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name="updatedAt")
    private Date updatedAt;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="role")
    private Role role;
}
