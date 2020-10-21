package com.fvhmi.springjwt.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fvhmi.springjwt.helper.ExcelHelper;
import com.fvhmi.springjwt.models.Tutorial;
import com.fvhmi.springjwt.repository.TutorialRepository;

@Service
public class ExcelService {
    @Autowired
    TutorialRepository repository;

    public ByteArrayInputStream load() {
        List<Tutorial> tutorials = repository.findAll();

        ByteArrayInputStream in = ExcelHelper.tutorialsToExcel(tutorials);
        return in;
    }

}