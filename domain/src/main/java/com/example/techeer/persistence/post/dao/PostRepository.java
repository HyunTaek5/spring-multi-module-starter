package com.example.techeer.persistence.post.dao;

import com.example.techeer.persistence.post.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface PostRepository extends PagingAndSortingRepository<Post, Long>, JpaRepository<Post, Long> {

  @Query("select p from Post p where p.title LIKE %:keyword% or p.body LIKE %:keyword% and p.isDeleted is false")
  Page<Post> findAllWithKeyword(Pageable pageable, Optional<String> keyword);
}
