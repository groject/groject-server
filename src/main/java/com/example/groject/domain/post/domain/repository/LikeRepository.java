package com.example.groject.domain.post.domain.repository;

import com.example.groject.domain.post.domain.Like;
import com.example.groject.domain.post.domain.Post;
import com.example.groject.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface LikeRepository extends CrudRepository<Like, Long> {
    Optional<Like> findByUserAndPost(User user, Post post);

    Optional<Like> findByPost(Post post);
}
