package com.example.demo.repository;

import com.example.demo.domain.MenuModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository <MenuModel,Long> {

    List<MenuModel> findMenuById(Long id);   // 아이디로 매장정보 가져오기
}
