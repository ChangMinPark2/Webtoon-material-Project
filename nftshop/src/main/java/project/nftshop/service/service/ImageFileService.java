package project.nftshop.service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriUtils;
import project.nftshop.persistence.entity.ImageFile;
import project.nftshop.persistence.repository.ImageFileRepository;
import project.nftshop.service.model.request.FileReqDto;
import project.nftshop.service.model.response.ImageFileResDto;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ImageFileService {

    @Value("${image.upload.directory}")
    String FILE_PATH;

    private final ImageFileRepository fileRepository;

    @Transactional
    public void hhjFileCreate(MultipartFile file) throws IOException {

        String originName = file.getOriginalFilename();

        String saveName = toSaveName(originName);

        file.transferTo(new File(getFullPath(saveName)));

        String contentType = file.getContentType();

        ImageFile create = ImageFile.builder()
                .fileName(originName)
                .saveName(saveName)
                .contentType(contentType)
                .build();

        fileRepository.save(create);
    }

    public ResponseEntity<?> hhjFileRead(Long fileId) throws IOException {

        ImageFile imageFile = fileRepository.findById(fileId).get();

        String saveFile = imageFile.getSaveName();

        String originName = imageFile.getFileName();

        String contentType = imageFile.getContentType();

        Path path = Paths.get(getFullPath(saveFile));

        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.setContentDisposition(
                ContentDisposition.builder("attachment")
                        .filename(originName, StandardCharsets.UTF_8)
                        .build()
        );

        httpHeaders.add(HttpHeaders.CONTENT_TYPE, contentType);

        Resource resource = new InputStreamResource(Files.newInputStream(path));

        return new ResponseEntity<>(resource, httpHeaders, HttpStatus.OK);
    }

    private String getFullPath(String saveName) {

        return FILE_PATH + saveName;
    }

    private String toSaveName(String originName) {

        String ext = extractExtension(originName);

        String uuid = UUID.randomUUID().toString();

        return uuid + "." + ext;
    }

    private String extractExtension(String originName) {

        int position = originName.lastIndexOf(".");

        return originName.substring(position + 1);
    }
}
