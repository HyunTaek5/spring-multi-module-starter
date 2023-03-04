package com.example.techeer.persistence.post.application;

import com.example.techeer.persistence.post.dto.request.PatchPostReq;
import com.example.techeer.persistence.post.dto.request.PostReq;
import com.example.techeer.persistence.post.dao.PostRepository;

import com.example.techeer.persistence.post.dto.response.PostDTO;
import com.example.techeer.persistence.post.entity.Post;
import com.example.techeer.persistence.user.application.UserService;
import com.example.techeer.persistence.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PostService {

  private final PostRepository postRepository;
  private final UserService userService;

  public PostDTO create(PostReq postReq) {
    User user = userService.findByIdInner(postReq.getUserId());

    Post post = postReq.toEntity(user);

    postRepository.save(post);

    return new PostDTO(post, user);
  }

  @Transactional(readOnly = true)
  public Page<PostDTO> findAll(Pageable pageable, Optional<String> keyword) {
    if(keyword.isEmpty()) {
      Page<Post> posts = postRepository.findAll(pageable);

      return posts.map(post -> new PostDTO(post, post.getUser()));
    }

    Page<Post> posts = postRepository.findAllWithKeyword(pageable, keyword);

    return posts.map(post -> new PostDTO(post, post.getUser()));
  }

  public PostDTO findById(long id) {
    Post post = postRepository.findById(id).orElseThrow();

    return new PostDTO(post, post.getUser());
  }


  public PostDTO patchById(long id, PatchPostReq patchPostReq) {
    Post post = postRepository.findById(id).orElseThrow();

    post.setTitle(patchPostReq.getTitle());
    post.setBody(patchPostReq.getBody());

    postRepository.save(post);

    return new PostDTO(post, post.getUser());
  }

  public void deleteById(long id) {
    postRepository.deleteById(id);
  }
}
