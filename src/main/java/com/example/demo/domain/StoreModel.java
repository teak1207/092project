package com.example.demo.domain;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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

    @Column(name = "address")
    private String address;

    @Column(name = "rating")
    private String rating;

    @Column(name = "tel")
    private String tel;

    @Column(name = "time")
    private String time;

    @Setter
    private List<MenuModel> menus;

}
