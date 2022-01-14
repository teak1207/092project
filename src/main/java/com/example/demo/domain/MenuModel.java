package com.example.demo.domain;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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


//    @ManyToOne
//    @JoinColumn(name = "id")
//    private StoreModel store;
}
