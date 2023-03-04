package com.example.techeer.persistence.post.dto.response;

import com.example.techeer.persistence.post.entity.Post;

import java.time.LocalDateTime;

import com.example.techeer.persistence.user.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostDTO {

  private long id;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  private String userNickName;

  private String title;
  private String body;

  @Builder
  public PostDTO(Post post, User user) {
    this.id = post.getId();
    this.createdAt = post.getCreatedAt();
    this.updatedAt = post.getUpdatedAt();
    this.userNickName = user.getNickName();
    this.title = post.getTitle();
    this.body = post.getBody();
  }
}