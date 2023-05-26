package project.nftshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.nftshop.service.service.ImageFileService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/api/v1/image") // 경로 추가
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:63342", allowCredentials = "true")
public class ImageFileController {

    private final ImageFileService imageFileService;

    @GetMapping
    public ResponseEntity<?> readImage(@RequestParam(name = "productName") String productName) throws IOException {

        return imageFileService.hhjFileRead(productName);
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> downloadImage(@RequestParam String saveName) throws IOException {
        return imageFileService.downloadImage(saveName);
    }
}




