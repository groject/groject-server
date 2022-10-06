package com.example.groject.domain.post.domain.repository;

import com.example.groject.domain.post.domain.Post;
import com.example.groject.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByCategoryOrderByCreateTimeDesc(String category);

    List<Post> findAllByCategoryOrderByLikeCheckDesc(String category);

    @Query("select n from Post n order by n.createTime desc ")
    List<Post> findAllOrderByCreateTimeDate();

    @Query("select n from Post n order by n.likeCheck desc ")
    List<Post> findAllByOrderByLikeCheckDesc();

    Optional<Post> findById(Long postId);

    List<Post> findAllByUserOrderByCreateTimeDesc(User user);

    List<Post> findAllByUserOrderByLikeCheckDesc(User user);
}
