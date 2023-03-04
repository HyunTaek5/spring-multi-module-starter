package com.example.techeer.persistence.post.dto.request;


import com.example.techeer.persistence.post.entity.Post;
import com.example.techeer.persistence.user.entity.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostReq {

    private Long userId;

    private String title;

    private String body;

    public Post toEntity(User user) {
        return Post.builder()
                .title(title)
                .body(body)
                .user(user)
                .build();
    }

}