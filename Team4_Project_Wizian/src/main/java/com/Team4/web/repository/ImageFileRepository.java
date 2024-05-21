package com.Team4.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Team4.web.entity.ImageFile;

public interface ImageFileRepository extends JpaRepository<ImageFile, Long> {
}
