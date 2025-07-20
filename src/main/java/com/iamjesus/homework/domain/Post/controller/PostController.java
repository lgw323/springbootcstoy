package com.iamjesus.homework.domain.Post.controller;

import com.iamjesus.homework.domain.Post.controller.code.PostSuccessCode;
import com.iamjesus.homework.domain.Post.dto.PostDetail;
import com.iamjesus.homework.domain.Post.dto.PostListResponse;
import com.iamjesus.homework.domain.Post.dto.PostRequest;
import com.iamjesus.homework.domain.Post.service.PostService;
import com.iamjesus.homework.global.response.PostResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/post")
public class PostController {
    PostService postService;

    @PostMapping("/write")
    public PostResponse<Long> writePost(@RequestHeader("Authorization") String username, @RequestBody PostRequest req) {
        return PostResponse.of(PostSuccessCode.OK_CREATED_POST, postService.createPost(username, req.title(), req.content()));
    }

    @GetMapping
    public PostResponse<List<PostListResponse>> getAllPost() {
        return PostResponse.of(PostSuccessCode.OK_GET_POST, postService.findAllPost());
    }

    @GetMapping("/{postid}")
    public PostResponse<PostDetail> getPost(@PathVariable Long postid) {
        PostDetail postDetail = postService.findPostById(postid);
        return PostResponse.of(PostSuccessCode.OK_GET_POST_BYID);
    }
}