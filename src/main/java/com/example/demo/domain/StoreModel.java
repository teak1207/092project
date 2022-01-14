package com.example.demo.domain;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table(name = "STORE")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StoreModel {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "thumbnail")
    private String thumbnail;

    @Column(name = "keyword")
    private  String keyword;

    @Column(name = "tel")
    private String tel;

    @Column(name = "address")
    private String address;

    @Column(name = "rating")
    private String rating;

    @Column(name = "time")
    private String time;

    @Setter
    @OneToMany(targetEntity=MenuModel.class, mappedBy="storeId", fetch=FetchType.EAGER)
    private List<MenuModel> menus;

}
