package com.example.techeer.controller.post;

import com.example.techeer.persistence.post.application.PostService;
import com.example.techeer.persistence.post.dto.request.PatchPostReq;
import com.example.techeer.persistence.post.dto.request.PostReq;
import com.example.techeer.persistence.post.dto.response.PostDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Optional;

@Tag(name = "posts", description = "게시물 API")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    @Resource(name = "postService")
    private final PostService postService;

    @Operation(summary = "getPosts", description = "게시글 목록 조회")
    @GetMapping()
    public ResponseEntity<Page<PostDTO>> getPosts(
            @PageableDefault(sort = "id", direction = Sort.Direction.DESC)Pageable pageable,
            @RequestParam(value = "keyword", required = false) Optional<String> keyword
    ) {
        return new ResponseEntity<>(postService.findAll(pageable, keyword), HttpStatus.OK);
    }


    @Operation(summary = "createPost", description = "게시글 생성")
    @PostMapping()
    public ResponseEntity<PostDTO> create(@RequestBody final PostReq postReq) {
        return new ResponseEntity<>(postService.create(postReq), HttpStatus.CREATED);
    }

    @Operation(summary = "getPostById", description = "게시글 상세 조회")
    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getPost(@PathVariable long id) {
        return new ResponseEntity<>(postService.findById(id), HttpStatus.OK);
    }

    @Operation(summary = "patchPostById", description = "게시글 수정")
    @PatchMapping("/{id}")
    public ResponseEntity<PostDTO> patchPost(
            @PathVariable long id,
            @RequestBody PatchPostReq patchPostReq) {
        return new ResponseEntity<>(postService.patchById(id, patchPostReq), HttpStatus.OK);
    }

    @Operation(summary = "deletePostById", description = "게시글 삭제")
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable long id) {
        postService.deleteById(id);
    }
}
