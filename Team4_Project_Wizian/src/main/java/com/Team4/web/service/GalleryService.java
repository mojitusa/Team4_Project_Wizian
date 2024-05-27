package com.Team4.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Team4.web.dto.GalleryDto;
import com.Team4.web.entity.GalleryEntity;
import com.Team4.web.repository.GalleryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GalleryService {
    private GalleryRepository galleryRepository;
    private S3Service s3Service;

    public GalleryEntity savePost(GalleryDto galleryDto) {
        return galleryRepository.save(galleryDto.toEntity());
    }
    
    public List<GalleryDto> getList() {
        List<GalleryEntity> galleryEntityList = galleryRepository.findAll();
        List<GalleryDto> galleryDtoList = new ArrayList<>();

        for (GalleryEntity galleryEntity : galleryEntityList) {
            galleryDtoList.add(convertEntityToDto(galleryEntity));
        }

        return galleryDtoList;
    }
    
    public GalleryEntity getFile (int no) {
    	return galleryRepository.findById((long) no).orElse(null);
    }

    private GalleryDto convertEntityToDto(GalleryEntity galleryEntity) {
        return GalleryDto.builder()
                .id(galleryEntity.getId())
                //.title(galleryEntity.getTitle())
                .filePath(galleryEntity.getFilePath())
                .imgFullPath("https://" + s3Service.CLOUD_FRONT_DOMAIN_NAME + "/" + galleryEntity.getFilePath())
                .build();
    }
}
