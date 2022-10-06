package com.example.groject.domain.post.service;

import com.example.groject.domain.post.domain.Post;
import com.example.groject.domain.post.present.dto.BasicResponse;
import com.example.groject.domain.post.present.dto.PostRequest;
import com.example.groject.domain.post.present.dto.PostResponse;
import com.example.groject.domain.post.domain.repository.PostRepository;
import com.example.groject.domain.post.exception.PostNotFoundException;
import com.example.groject.domain.user.domain.User;
import com.example.groject.domain.user.exception.UserNotFoundException;
import com.example.groject.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserFacade userFacade;

    public void create(PostRequest request) {
        User user = userFacade.getCurrentUser();

        postRepository.save(
                Post.builder()
                        .imageUrl(request.getImageUrl())
                        .projectName(request.getProjectName())
                        .intro(request.getIntro())
                        .skill(request.getSkill())
                        .phoneNumber(request.getPhoneNumber())
                        .category(request.getCategory())
                        .user(user)
                        .isMine(true)
                        .likeCheck(0)
                        .build()
        );
    }

    public BasicResponse introPost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);

        return BasicResponse.builder()
                .id(post.getId())
                .imageUrl(post.getImageUrl())
                .projectName(post.getProjectName())
                .intro(post.getIntro())
                .skill(post.getSkill())
                .category(post.getCategory())
                .phoneNumber(post.getPhoneNumber())
                .isMine(post.isMine())
                .like(post.getLikeCheck())
                .build();
    }

    public PostResponse list(String category) {
        List<PostResponse.PostDto> list = postRepository.findAllByCategoryOrderByCreateTimeDesc(category)
                .stream()
                .map(post -> PostResponse.PostDto
                        .builder()
                        .id(post.getId())
                        .projectName(post.getProjectName())
                        .intro(post.getIntro())
                        .skill(post.getSkill())
                        .phoneNumber(post.getPhoneNumber())
                        .category(post.getCategory())
                        .imageUrl(post.getImageUrl())
                        .isMine(post.isMine())
                        .like(post.getLikeCheck())
                        .build()
                ).collect(Collectors.toList());

        return new PostResponse(list);
    }

    public PostResponse listByLike(String category) {
        List<PostResponse.PostDto> list = postRepository.findAllByCategoryOrderByLikeCheckDesc(category)
                .stream()
                .map(post -> PostResponse.PostDto
                        .builder()
                        .id(post.getId())
                        .projectName(post.getProjectName())
                        .intro(post.getIntro())
                        .skill(post.getSkill())
                        .phoneNumber(post.getPhoneNumber())
                        .category(post.getCategory())
                        .imageUrl(post.getImageUrl())
                        .isMine(post.isMine())
                        .like(post.getLikeCheck())
                        .build()
                ).collect(Collectors.toList());

        return new PostResponse(list);
    }

    public PostResponse listAllByTime() {
        List<PostResponse.PostDto> list = postRepository.findAllOrderByCreateTimeDate()
                .stream()
                .map(post -> PostResponse.PostDto
                        .builder()
                        .id(post.getId())
                        .projectName(post.getProjectName())
                        .intro(post.getIntro())
                        .skill(post.getSkill())
                        .phoneNumber(post.getPhoneNumber())
                        .category(post.getCategory())
                        .imageUrl(post.getImageUrl())
                        .isMine(post.isMine())
                        .like(post.getLikeCheck())
                        .build()
                ).collect(Collectors.toList());

        return new PostResponse(list);
    }

    public PostResponse listAllByLike() {
        List<PostResponse.PostDto> list = postRepository.findAllByOrderByLikeCheckDesc()
                .stream()
                .map(post -> PostResponse.PostDto
                        .builder()
                        .id(post.getId())
                        .projectName(post.getProjectName())
                        .intro(post.getIntro())
                        .skill(post.getSkill())
                        .phoneNumber(post.getPhoneNumber())
                        .category(post.getCategory())
                        .imageUrl(post.getImageUrl())
                        .isMine(post.isMine())
                        .like(post.getLikeCheck())
                        .build()
                ).collect(Collectors.toList());

        return new PostResponse(list);
    }

    @Transactional
    public void deletePost(Long postId) {
        User user = userFacade.getCurrentUser();

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);

        if(!post.getUser().equals(user)) {
            throw UserNotFoundException.EXCEPTION;
        }

        postRepository.delete(post);
    }

    @Transactional
    public void updatePost(Long postId, PostRequest request) {
        User user = userFacade.getCurrentUser();

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> PostNotFoundException.EXCEPTION);

        if(!post.getUser().equals(user)) {
            throw UserNotFoundException.EXCEPTION;
        }

        post.update(request.getImageUrl(), request.getProjectName(), request.getIntro(), request.getSkill(), request.getPhoneNumber(), request.getCategory());

    }
}
