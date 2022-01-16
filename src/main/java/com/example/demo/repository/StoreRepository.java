package com.example.demo.repository;

import com.example.demo.domain.StoreModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StoreRepository extends JpaRepository<StoreModel, Long> {

    Optional<StoreModel> findByIdAndName(Long id, String name);

    Optional<StoreModel> findByName(String name);

    StoreModel findStoreById(Long id);   //  아이디로 매장정보 가져오기

    StoreModel findAllById (Long StoreId);   //매장아이디가 1441인 매장 정보가져와
    // 1441	롯데리아 선릉점
    // select * from store where keywordid = 변수
    // select * from keyword_mapping where keyword_id = 변수



}
