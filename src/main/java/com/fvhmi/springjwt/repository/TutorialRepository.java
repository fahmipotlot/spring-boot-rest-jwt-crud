package com.fvhmi.springjwt.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fvhmi.springjwt.models.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    Page<Tutorial> findByPublished(boolean published, org.springframework.data.domain.Pageable paging);
    Page<Tutorial> findByTitleContaining(String title, org.springframework.data.domain.Pageable paging);
}