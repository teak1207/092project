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

    public StoreModel getStoreInfo(Long storeId) {

        // 매장 정보를 가지고 와서 storeInfos에 넣어둠
        StoreModel storeInfos =  repository.findStoreById(storeId);

        /*
         storeInfos이 갖고 있는 List<MenuModel> menus를
         menuRepository.findMenuById(storeId) 초기화
         menus가 메뉴정보를 갖게됨
         */
        storeInfos.setMenus(menuRepository.findMenuById(storeId));

        return storeInfos;
    }

}
