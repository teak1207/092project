package com.example.demo.controller;

import com.example.demo.domain.StoreModel;
import com.example.demo.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class StoreController {

    private final StoreService service;

    @GetMapping // 키워드에 상관없이 모든 매장을 가져옴.
    public ResponseEntity<List<StoreModel>> getStores() {

        return ResponseEntity.ok(service.getStores());
    }

    @GetMapping("{keywordId}")  //  키워드를 클릭했을때, 해당 값을 갖고 있는 매장불러옴
    public ResponseEntity<List<StoreModel>> getStores(@PathVariable Long keywordId) {
        return ResponseEntity.ok(service.getStores(keywordId));
    }

    @GetMapping("/detail/{storeId}")
    public ResponseEntity<StoreModel> getStoreInfo(@PathVariable Long storeId) {
        return ResponseEntity.ok(service.getStoreInfo(storeId));
    }


    //==========================================================================

    // Not Use
    @GetMapping("/name")
    public ResponseEntity<StoreModel> getStore(@RequestParam(name = "name") String name) {
        return ResponseEntity.ok(service.getStore(name));
    }

    @GetMapping("/name/{id}")
    public ResponseEntity<StoreModel> getStore(@PathVariable Long id, @RequestParam(name = "name") String name) {
        return ResponseEntity.ok(service.getStore(id, name));
    }
}
