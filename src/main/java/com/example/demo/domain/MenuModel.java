package com.example.demo.domain;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "MENU")
@Getter
@Entity
@NoArgsConstructor(access =  AccessLevel.PROTECTED)
public class MenuModel {


    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "store_id")
    private Long storeId;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private String price;     // 19,000원

}
