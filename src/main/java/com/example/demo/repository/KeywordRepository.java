package com.example.demo.repository;

import com.example.demo.domain.KeywordModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeywordRepository extends JpaRepository<KeywordModel, Long> {
}
