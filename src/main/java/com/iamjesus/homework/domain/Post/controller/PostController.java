package com.iamjesus.homework.domain.Post.controller;

import com.iamjesus.homework.domain.Post.controller.code.PostSuccessCode;
import com.iamjesus.homework.domain.Post.dto.PostRequest;
import com.iamjesus.homework.domain.Post.service.PostService;
import com.iamjesus.homework.global.response.PostResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/post")
public class PostController {
    PostService postService;

    @PostMapping("/write")
    public PostResponse<Long> writePost(@RequestHeader("Authorization") String username, @RequestBody PostRequest req) {
        return PostResponse.of(PostSuccessCode.OK_CREATED_POST, postService.createPost(username, req.title(), req.content()));
    }
}
