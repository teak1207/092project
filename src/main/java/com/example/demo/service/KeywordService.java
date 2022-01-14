package com.example.demo.service;

import com.example.demo.domain.KeywordModel;
import com.example.demo.repository.KeywordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KeywordService {

    private final KeywordRepository repository;

    public List<KeywordModel> getKeywords() {
        return repository.findAll();
    }

    public KeywordModel getKeyword(Long id) {
        return repository.findById(id).orElseThrow();
    }
}
