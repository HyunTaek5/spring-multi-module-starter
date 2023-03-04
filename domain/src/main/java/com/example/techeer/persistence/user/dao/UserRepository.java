package com.example.techeer.persistence.user.dao;

import com.example.techeer.persistence.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long>, JpaRepository<User, Long> {
}
