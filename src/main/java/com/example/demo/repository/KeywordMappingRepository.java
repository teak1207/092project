package com.example.demo.repository;

import com.example.demo.domain.KeywordMappingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface KeywordMappingRepository extends JpaRepository<KeywordMappingModel, Long> {

    List<KeywordMappingModel> findAllByKeywordId(Long keywordId);
}
