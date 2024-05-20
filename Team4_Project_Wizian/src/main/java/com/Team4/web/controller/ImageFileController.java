package com.Team4.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import com.Team4.web.entity.ImageFile;
import com.Team4.web.service.ImageFileService;

@Controller
public class ImageFileController {

    @Autowired
    private ImageFileService imageFileService;

    @GetMapping("/image")
    public String index(Model model) {
        model.addAttribute("files", imageFileService.getAllFiles());
        return "index";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, Model model) {
        try {
            imageFileService.saveFile(file);
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("message", "Failed to upload file: " + e.getMessage());
            return "error";
        }

        return "redirect:/";
    }

    @GetMapping("/files/{id}")
    public String getFile(@PathVariable Long id, Model model) {
        ImageFile imageFile = imageFileService.getFile(id);
        if (imageFile == null) {
            model.addAttribute("message", "File not found");
            return "error";
        }

        model.addAttribute("file", imageFile);
        return "file";
    }
}
