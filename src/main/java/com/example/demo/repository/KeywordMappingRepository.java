package com.example.demo.repository;

import com.example.demo.domain.KeywordMappingModel;
import com.example.demo.domain.StoreModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface KeywordMappingRepository extends JpaRepository<KeywordMappingModel, Long> {

    List<KeywordMappingModel> findAllByKeywordId(Long keywordId);

    List<KeywordMappingModel> findByKeywordId (Long keywordId);  // 키워드가 15인 애들을 가져와
}
