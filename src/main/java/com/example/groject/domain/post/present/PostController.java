package com.example.groject.domain.post.present;

import com.example.groject.domain.post.present.dto.BasicResponse;
import com.example.groject.domain.post.present.dto.PostRequest;
import com.example.groject.domain.post.present.dto.PostResponse;
import com.example.groject.domain.post.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "게시글", description = "게시글 관련 API 입니다, category는 String 타입, postId는 Long타입 입니다")
@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @Operation(summary = "게시글 작성")
    @PostMapping
    public void create(@RequestBody @Valid PostRequest request) {
        postService.create(request);
    }

    @Operation(summary = "게시글 상세보기")
    @GetMapping("/enter/{postId}")
    public BasicResponse enter(@PathVariable("postId") Long postId) {
        return postService.introPost(postId);
    }

    @Operation(summary = "게시글 카테고리 별로 최신순 정렬")
    @GetMapping("/time/{category}")
    public PostResponse listPost(@PathVariable("category") String category) {
        return postService.list(category);
    }

    @Operation(summary = "게시글 카테고리 별로 인기순 정렬")
    @GetMapping("/like/{category}")
    public PostResponse listByLike(@PathVariable("category") String category) {
        return postService.listByLike(category);
    }

    @Operation(summary = "게시글 카테고리 없이 전체 최신순 정렬")
    @GetMapping("/time")
    public PostResponse listTime() {
        return postService.listAllByTime();
    }

    @Operation(summary = "게시글 카테고리 없이 전체 인기순 정렬")
    @GetMapping("/like")
    public PostResponse listLike() {
        return postService.listAllByLike();
    }

    @Operation(summary = "게시글 삭제")
    @DeleteMapping("/{postId}")
    public void delete(@PathVariable("postId") Long postId) {
        postService.deletePost(postId);
    }

    @Operation(summary = "게시글 수정")
    @PatchMapping("/{postId}")
    public void update(@PathVariable("postId") Long postId, @RequestBody @Valid PostRequest request) {
         postService.updatePost(postId, request);
    }
}
