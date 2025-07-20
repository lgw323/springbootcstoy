package com.iamjesus.homework.domain.Comment.controller;

import com.iamjesus.homework.domain.Comment.controller.code.CommentSuccessCode;
import com.iamjesus.homework.domain.Comment.dto.CommentRequest;
import com.iamjesus.homework.domain.Comment.service.CommentService;
import com.iamjesus.homework.global.response.PostResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@AllArgsConstructor
public class CommentController {
    CommentService commentService;

    @PostMapping("/write")
    public PostResponse<Void> registerComment(@RequestHeader("Authorization") String username, @RequestBody CommentRequest req) {
        commentService.createComment(req.postid(), req.content(), username);
        return PostResponse.of(CommentSuccessCode.OK_REGISTERED_COMMENT);
    }
}
