package io.starter.persistence.main.entity;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

public class Idle {

    @Id @GeneratedValue
    @Column(name="id")
    private Long id;

    @CreatedDate
    @Column(name="createdAt")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name="updatedAt")
    private Date updatedAt;
}
