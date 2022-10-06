package com.example.groject.domain.post.present;

import com.example.groject.domain.post.service.LikeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "좋아요", description = "좋아요 api이고, postId는 Long 입니다")
@RestController
@RequiredArgsConstructor
@RequestMapping("/like")
public class LikeController {
    private final LikeService likeService;

    @Operation(summary = "좋아요")
    @PostMapping("/{postId}")
    public void topic(@PathVariable("postId") Long postId) {
        likeService.topic(postId);
    }

    @Operation(summary = "좋아요 취소")
    @DeleteMapping("/{postId}")
    public void delete(@PathVariable("postId") Long postId) {
        likeService.deleteLike(postId);
    }
}
