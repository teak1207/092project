package com.example.demo.controller;

import com.example.demo.service.JsonService;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/json")
public class JsonController {

    private  final JsonService jsonService;


    @GetMapping("/store")
    public ResponseEntity<String> saveStores(){

        try {
            jsonService.saveStores( );
        } catch (IOException | ParseException e) {   // 리턴이 같아서 하나로 묶음
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("FAIL");
        }

        return ResponseEntity.ok("SUCCESS");
    }

}
