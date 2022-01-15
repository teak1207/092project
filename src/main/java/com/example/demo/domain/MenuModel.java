package com.example.demo.domain;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@ToString
@Table(name = "MENU")
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SequenceGenerator(
        name = "MENU_SEQ_GEN", //시퀀스 제너레이터 이름
        sequenceName = "MENU_SEQ", //시퀀스 이름
        initialValue = 1, //시작값
        allocationSize = 1  //메모리를 통해 할당할 범위 사이즈
)
public class MenuModel {


    @Id
    @Column(name = "id")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE, //사용할 전략을 시퀀스로  선택
            generator = "MENU_SEQ_GEN" //식별자 생성기를 설정해놓은  STORE_SEQ_GEN 설정
    )
    private Long id;

    @Column(name = "store_id")
    private Long storeId;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private String price;     // 19,000원


    public MenuModel(Long storeId, String name, String price) {
        this.storeId = storeId;
        this.name = name;
        this.price = price;
    }
}
