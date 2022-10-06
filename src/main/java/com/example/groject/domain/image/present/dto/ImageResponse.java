package com.example.groject.domain.image.present.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class ImageResponse {
    private List<String> imageUrl;
}
