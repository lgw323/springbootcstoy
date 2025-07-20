package com.iamjesus.homework.domain.Post.service;

import com.iamjesus.homework.domain.Comment.model.Comment;
import com.iamjesus.homework.domain.Comment.repository.CommentRepository;
import com.iamjesus.homework.domain.Member.controller.code.MemberExceptionCode;
import com.iamjesus.homework.domain.Member.model.Member;
import com.iamjesus.homework.domain.Member.repository.MemberRepository;
import com.iamjesus.homework.domain.Post.controller.code.PostExceptionCode;
import com.iamjesus.homework.domain.Post.dto.Author;
import com.iamjesus.homework.domain.Post.dto.CommentforPost;
import com.iamjesus.homework.domain.Post.dto.PostDetail;
import com.iamjesus.homework.domain.Post.dto.PostListResponse;
import com.iamjesus.homework.domain.Post.model.Post;
import com.iamjesus.homework.domain.Post.respository.PostRepository;
import com.iamjesus.homework.global.exception.domain.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;
    private final CommentRepository commentRepository;

    public Long createPost(String username, String title, String content) {
        Member member = memberRepository.findByUsername(username).orElseThrow(() -> new NotFoundException(MemberExceptionCode.NOT_FOUND_MEMBER));
        return postRepository.save(Post.of(title, content, member)).getId();
    }

    public List<PostListResponse> findAllPost() {
        return postRepository.findAll().stream().map(PostListResponse::from).collect(Collectors.toList());
    }

    public PostDetail findPostById(Long postid) {
        Post post = postRepository.findById(postid).orElseThrow(() -> new NotFoundException(PostExceptionCode.NOT_FOUND_POST));
        List<CommentforPost> comments = commentRepository.findByPostId(post.getId()).stream().map(CommentforPost::from).collect(Collectors.toList());
        return new PostDetail(post.getId(), Author.from(post.getMember()), post.getCreateAt(), post.getTitle(), post.getContent(), comments);
    }
}
