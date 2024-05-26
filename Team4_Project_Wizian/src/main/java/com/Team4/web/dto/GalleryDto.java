package com.Team4.web.dto;

import com.Team4.web.entity.GalleryEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class GalleryDto {
    private Long id;
    //private String title;
    private String filePath;
    private String imgFullPath;

    public GalleryEntity toEntity(){
        GalleryEntity build = GalleryEntity.builder()
                .id(id)
                //.title(title)
                .filePath(filePath)
                .build();
        return build;
    }

    @Builder
    public GalleryDto(Long id, String filePath, String imgFullPath) {
        this.id = id;
        //this.title = title;
        this.filePath = filePath;
        this.imgFullPath = imgFullPath;
    }
}