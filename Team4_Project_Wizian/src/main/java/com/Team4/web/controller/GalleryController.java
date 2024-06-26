package com.Team4.web.controller;
import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.Team4.web.dto.GalleryDto;
import com.Team4.web.entity.GalleryEntity;
import com.Team4.web.service.GalleryService;
import com.Team4.web.service.S3Service;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class GalleryController {
    private S3Service s3Service;
    private GalleryService galleryService;

    @GetMapping("/gallery")
    public String dispWrite(Model model) {
        List<GalleryDto> galleryDtoList = galleryService.getList();

        model.addAttribute("galleryList", galleryDtoList);

        return "content/gallery";
    }

    @PostMapping("/gallery")
    public String execWrite(GalleryDto galleryDto, @RequestParam("file") MultipartFile file) throws IOException {
        String imgPath = s3Service.upload(file);
        galleryDto.setFilePath(imgPath);



        galleryService.savePost(galleryDto);

        return "redirect:/gallery";
    }
    
    @PostMapping("/attachment")
    public ResponseEntity<String> atachment(GalleryDto galleryDto, @RequestParam("file") MultipartFile file) throws IOException {
    	//System.out.println("file : " + file);
        String imgPath = s3Service.upload(file);
        galleryDto.setFilePath(imgPath);

        Long attNo = galleryService.savePost(galleryDto).getId();
        
        String jsonResponse = "{\"attNo\": " + attNo.toString() + "}";
        
        return ResponseEntity.ok().body(jsonResponse);

    }
    
    @GetMapping("/gallerytest")
    public String gallerytest(Model model) {
        GalleryEntity galleryEntity = galleryService.getFile(23);
        galleryEntity.setImgFullPath("https://" + s3Service.CLOUD_FRONT_DOMAIN_NAME + "/" + galleryEntity.getFilePath());
        System.out.println(galleryEntity.getId());
        System.out.println(galleryEntity.getFilePath());

        model.addAttribute("galleryEntity", galleryEntity);

        return "content/gallerytest";
    }
}
