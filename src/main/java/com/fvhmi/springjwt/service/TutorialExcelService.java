package com.fvhmi.springjwt.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fvhmi.springjwt.helper.TutorialExcelHelper;
import com.fvhmi.springjwt.models.Tutorial;
import com.fvhmi.springjwt.repository.TutorialRepository;

@Service
public class TutorialExcelService {
    @Autowired
    TutorialRepository repository;

    public ByteArrayInputStream load() {
        List<Tutorial> tutorials = repository.findAll();

        ByteArrayInputStream in = TutorialExcelHelper.tutorialsToExcel(tutorials);
        return in;
    }

    public void save(MultipartFile file) {
        try {
            List<Tutorial> tutorials = TutorialExcelHelper.excelToTutorials(file.getInputStream());
            repository.saveAll(tutorials);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    public List<Tutorial> getAllTutorials() {
        return repository.findAll();
    }
}