package project.nftshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.nftshop.service.model.response.ImageFileResDto;
import project.nftshop.service.service.ImageFileService;

import java.io.IOException;
import java.net.MalformedURLException;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ImageFileController {

    private final ImageFileService imageFileService;

    @GetMapping
    public ResponseEntity<?> download(@RequestParam(name = "productsName") String productsName) throws IOException {

        return imageFileService.hhjFileRead(productsName);
    }
}





