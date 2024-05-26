package com.Team4.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Team4.web.entity.GalleryEntity;


public interface GalleryRepository extends JpaRepository<GalleryEntity, Long> {
    @Override
    List<GalleryEntity> findAll();
}
