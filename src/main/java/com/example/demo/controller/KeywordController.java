package com.example.demo.controller;

import com.example.demo.domain.KeywordModel;
import com.example.demo.service.KeywordService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/keyword")
public class KeywordController {

    private final KeywordService service;

    @GetMapping
    public ResponseEntity<List<KeywordModel>> getKeywords(){
//        return service.getKeywords();
        return ResponseEntity.ok(service.getKeywords());
    }
    @GetMapping("{id}")
    public ResponseEntity<KeywordModel> getKeyword(@PathVariable Long id){
//  public ResponseEntity<KeywordModel> getKeyword(@PathVariable(name="ids") Long id){   자유롭게 열어둠
        return ResponseEntity.ok(service.getKeyword(id));
    }
}
