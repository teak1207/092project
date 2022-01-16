package com.example.demo.domain;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@ToString
@Table(name = "STORE")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SequenceGenerator(
        name = "STORE_SEQ_GEN", //시퀀스 제너레이터 이름
        sequenceName = "STORE_SEQ", //시퀀스 이름
        initialValue = 1, //시작값
        allocationSize = 1 //메모리를 통해 할당할 범위 사이즈
)
public class StoreModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE, //사용할 전략을 시퀀스로  선택
            generator = "STORE_SEQ_GEN" //식별자 생성기를 설정해놓은  STORE_SEQ_GEN 설정
    )
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "thumbnail")
    private String thumbnail;


    @Column(name = "tel")
    private String tel;

    @Column(name = "address")
    private String address;

    @Column(name = "rating")
    private String rating;

    @Column(name = "time")
    private String time;

    @Setter
    @OneToMany(targetEntity = MenuModel.class, mappedBy = "id", fetch = FetchType.EAGER)
    private List<MenuModel> menus;




    public StoreModel(String name, String thumbnail, String tel, String address, String rating, String time) {
        this.name = name;
        this.thumbnail = thumbnail;
        this.tel = tel;
        this.address = address;
        this.rating = rating;
        this.time = time;
    }
}
