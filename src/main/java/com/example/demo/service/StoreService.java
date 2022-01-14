package com.example.demo.service;

import com.example.demo.domain.KeywordMappingModel;
import com.example.demo.domain.MenuModel;
import com.example.demo.domain.StoreModel;
import com.example.demo.repository.KeywordMappingRepository;
import com.example.demo.repository.MenuRepository;
import com.example.demo.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository repository;
    private final KeywordMappingRepository keywordMappingRepository;
    private final MenuRepository menuRepository;
    private final StoreModel storeModel;

    public List<StoreModel> getStores() {
        return repository.findAll();
    }

    public StoreModel getStore(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public StoreModel getStore(String name) {
        return repository.findByName(name).orElseThrow();
    }

    public StoreModel getStore(Long id, String name) {
        return repository.findByIdAndName(id, name).orElseThrow();
    }

    public List<StoreModel> getStores(Long keywordId) {

        List<Long> storeIds = keywordMappingRepository.findAllByKeywordId(keywordId)
                .stream().map(KeywordMappingModel::getStoreId)
                .collect(Collectors.toList());

        // (1,3,5)
        return repository.findAllById(storeIds);

    }

    public List<MenuModel> getStoreInfo(Long storeId){

            repository.findStoreById(storeId);                                // 매장 정보를 가지고 있음.
           storeModel.setMenus(menuRepository.findMenuById(storeId));         // 메뉴를 리스트로 갖고 있음

    return null;
    }

}
