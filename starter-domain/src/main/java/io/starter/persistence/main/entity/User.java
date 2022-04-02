package io.starter.persistence.main.entity;

import io.starter.persistence.main.entity.type.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity @Getter @Setter
public class User extends Idle{
    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="role")
    private Role role;
}
