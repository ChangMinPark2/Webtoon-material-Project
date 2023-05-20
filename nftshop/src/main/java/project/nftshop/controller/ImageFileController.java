package project.nftshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.nftshop.service.service.ImageFileService;
import java.io.IOException;


@RestController
@RequestMapping("/api/v1/image") // 경로 추가
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:63342", allowCredentials = "true")
public class ImageFileController {

    private final ImageFileService imageFileService;

    @GetMapping
    public ResponseEntity<?> readImage(@RequestParam(name = "productsName") String productsName) throws IOException {

        return imageFileService.hhjFileRead(productsName);
    }
}





