package io.starter.persistence.main.entity;

import io.starter.persistence.main.entity.type.Role;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity @Getter @Setter
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
