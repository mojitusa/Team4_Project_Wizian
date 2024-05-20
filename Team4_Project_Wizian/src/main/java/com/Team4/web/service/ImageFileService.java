package com.Team4.web.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Team4.web.entity.ImageFile;
import com.Team4.web.repository.ImageFileRepository;

@Service
public class ImageFileService {

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    private ImageFileRepository imageFileRepository;

    public ImageFile saveFile(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new RuntimeException("File is empty");
        }

        // Save the file locally
        byte[] bytes = file.getBytes();
        Path path = Paths.get(uploadPath + file.getOriginalFilename());
        Files.write(path, bytes);

        // Save the file path to the database
        ImageFile imageFile = new ImageFile();
        imageFile.setFileName(file.getOriginalFilename());
        imageFile.setFilePath(path.toString());

        return imageFileRepository.save(imageFile);
    }

    public ImageFile getFile(Long id) {
        return imageFileRepository.findById(id).orElse(null);
    }

    public List<ImageFile> getAllFiles() {
        return imageFileRepository.findAll();
    }
}