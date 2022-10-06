package com.example.groject.domain.image.present;

import com.example.groject.domain.image.present.dto.ImageResponse;
import com.example.groject.domain.image.service.ImageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Tag(name = "이미지", description = "이미지 업로드 api 입니다")
@RestController
@RequiredArgsConstructor
@RequestMapping("/image")
public class ImageController {
    private final ImageService imageService;

    @Operation(summary = "이미지 업로드")
    @PostMapping
    public ImageResponse upload(@RequestPart List<MultipartFile> file) {
        return imageService.queryImage(file);
    }
}
