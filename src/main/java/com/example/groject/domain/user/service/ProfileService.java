package com.example.groject.domain.user.service;

import com.example.groject.domain.post.domain.repository.PostRepository;
import com.example.groject.domain.post.present.dto.PostResponse;
import com.example.groject.domain.user.domain.User;
import com.example.groject.domain.user.domain.repository.UserRepository;
import com.example.groject.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProfileService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final UserFacade userFacade;

    public PostResponse listMyPageByTime() {
        User user = userFacade.getCurrentUser();

        List<PostResponse.PostDto> list = postRepository.findAllByUserOrderByCreateTimeDesc(user)
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

    public PostResponse ListMyPageByLike() {
        User user = userFacade.getCurrentUser();

        List<PostResponse.PostDto> list = postRepository.findAllByUserOrderByLikeCheckDesc(user)
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
}
