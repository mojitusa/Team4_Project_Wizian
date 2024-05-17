package com.Team4.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Team4.web.entity.InquiryCsl;
import com.Team4.web.repository.InquiryCslRepo;

@Service
public class InquiryCslService {

    private final InquiryCslRepo inquiryCslRepo;

    @Autowired
    public InquiryCslService(InquiryCslRepo inquiryCslRepo) {
        this.inquiryCslRepo = inquiryCslRepo;
    }

    public List<InquiryCsl> getAllInquiryCsls() {
        return inquiryCslRepo.findAll();
    }
}