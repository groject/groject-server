package com.example.groject.infra.s3;

import org.springframework.web.multipart.MultipartFile;

public interface ImageUtil {
    String upload(MultipartFile file);
}
