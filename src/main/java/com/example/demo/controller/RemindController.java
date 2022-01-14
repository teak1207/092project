package com.example.demo.controller;

import com.example.demo.domain.RemindModel;
import com.example.demo.service.RemindService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@Controller + @ResponseBody
//@ResponseBody를 모든 메소드에서 적용한다.->메소드의 반환 결과(문자열)를 JSON 형태로 반환한다.
@RequiredArgsConstructor
@RequestMapping("/remind")
public class RemindController {

    private final RemindService service;

    @GetMapping
    public ResponseEntity<List<RemindModel>> getInfomations() {
        return ResponseEntity.ok(service.getInfomations());
    }
}
