package com.iamjesus.homework.domain.Comment.service;

import com.iamjesus.homework.domain.Comment.controller.code.CommentExceptionCode;
import com.iamjesus.homework.domain.Comment.model.Comment;
import com.iamjesus.homework.domain.Comment.repository.CommentRepository;
import com.iamjesus.homework.domain.Member.model.Member;
import com.iamjesus.homework.domain.Member.repository.MemberRepository;
import com.iamjesus.homework.domain.Post.model.Post;
import com.iamjesus.homework.domain.Post.respository.PostRepository;
import com.iamjesus.homework.global.exception.domain.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentService {
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;
    private final CommentRepository commentRepository;

    public void createComment(Long postid, String content, String username) {
        Post post = postRepository.findById(postid).orElseThrow(() -> new NotFoundException(CommentExceptionCode.NOT_FOUND_POST));
        Member member = memberRepository.findByUsername(username).orElseThrow(() -> new NotFoundException(CommentExceptionCode.NOT_FOUND_MEMBER));
        Comment comment = Comment.of(post, content, member);
        commentRepository.save(comment);
    }
}
