package com.example.demo.repository;

import com.example.demo.domain.KeywordModel;
import com.example.demo.domain.StoreModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StoreRepository  extends JpaRepository<StoreModel, Long> {
    Optional<StoreModel> findByIdAndName(Long id,String name);
    Optional<StoreModel> findByName(String name);

    StoreModel findStoreById(Long id);   //  아이디로 매장정보 가져오기


}
