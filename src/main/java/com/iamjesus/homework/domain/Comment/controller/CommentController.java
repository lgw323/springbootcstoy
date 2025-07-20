package com.iamjesus.homework.domain.Comment.controller;

import com.iamjesus.homework.domain.Comment.controller.code.CommentExceptionCode;
import com.iamjesus.homework.domain.Comment.controller.code.CommentSuccessCode;
import com.iamjesus.homework.domain.Comment.dto.CommentRequest;
import com.iamjesus.homework.domain.Comment.service.CommentService;
import com.iamjesus.homework.global.exception.domain.BadRequestException;
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
        if(req.postId() == null) {
            throw new BadRequestException(CommentExceptionCode.NOT_FOUND_POST);
        }
        if(req.content() == null || req.content().isBlank()) {
            throw new BadRequestException(CommentExceptionCode.BAD_REQUEST);
        }
        commentService.createComment(req.postId(), req.content(), username);
        return PostResponse.of(CommentSuccessCode.OK_REGISTERED_COMMENT);
    }
}
