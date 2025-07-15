package com.iamjesus.homework.domain.Post.service;

import com.iamjesus.homework.domain.Member.controller.code.MemberExceptionCode;
import com.iamjesus.homework.domain.Member.model.Member;
import com.iamjesus.homework.domain.Member.repository.MemberRepository;
import com.iamjesus.homework.domain.Post.model.Post;
import com.iamjesus.homework.domain.Post.respository.PostRepository;
import com.iamjesus.homework.global.exception.domain.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    public Long createPost(String username, String title, String content) {
        Member member = memberRepository.findByUsername(username).orElseThrow(() -> new NotFoundException(MemberExceptionCode.NOT_FOUND_MEMBER));
        return postRepository.save(Post.of(title, content, member)).getId();
    }
}
