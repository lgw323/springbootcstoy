package com.iamjesus.homework.domain.Comment.model;

import com.iamjesus.homework.domain.Member.model.Member;
import com.iamjesus.homework.domain.Post.model.Post;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @CreatedDate
    @Column(name = "createAt")
    private LocalDateTime createAt;

    private Comment(Post post, String content, Member member) {
        this.post = post;
        this.content = content;
        this.member = member;
    }

    public static Comment of(Post post, String content, Member member) {
        return new Comment(post, content, member);
    }
}