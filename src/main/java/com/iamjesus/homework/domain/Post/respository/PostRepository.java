package com.iamjesus.homework.domain.Post.respository;

import com.iamjesus.homework.domain.Post.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
