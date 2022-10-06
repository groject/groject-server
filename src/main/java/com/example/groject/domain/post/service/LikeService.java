package com.example.groject.domain.post.service;

import com.example.groject.domain.post.domain.Like;
import com.example.groject.domain.post.domain.Post;
import com.example.groject.domain.post.domain.repository.LikeRepository;
import com.example.groject.domain.post.domain.repository.PostRepository;
import com.example.groject.domain.post.exception.LikeNotFoundException;
import com.example.groject.domain.post.exception.PostNotFoundException;
import com.example.groject.domain.user.domain.User;
import com.example.groject.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class LikeService {
    private final LikeRepository likeRepository;
    private final PostRepository postRepository;
    private final UserFacade userFacade;

    @Transactional
    public void topic(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);

        User user = userFacade.getCurrentUser();

        likeRepository.save(
                Like.builder()
                        .post(post)
                        .user(user)
                        .build()
        );
        post.topic(post.getLikeCheck()+1);
    }

    @Transactional
    public void deleteLike(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);

        User user = userFacade.getCurrentUser();

        Like like = likeRepository.findByUserAndPost(user, post)
                .orElseThrow(() -> LikeNotFoundException.EXCEPTION);

        post.topic(post.getLikeCheck()-1);

        likeRepository.delete(like);
    }
}
