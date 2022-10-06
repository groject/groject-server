package com.example.groject.domain.image.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.example.groject.domain.image.present.dto.ImageResponse;
import com.example.groject.infra.s3.S3Facade;
import com.example.groject.infra.s3.S3Properties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ImageService {
    private final S3Facade s3Facade;

    @Transactional(readOnly = true)
    public ImageResponse queryImage(List<MultipartFile> file) {
        List<String> files = file.stream()
                .map(s3Facade::upload)
                .collect(Collectors.toList());

        return ImageResponse.builder()
                .imageUrl(files)
                .build();
    }
}
